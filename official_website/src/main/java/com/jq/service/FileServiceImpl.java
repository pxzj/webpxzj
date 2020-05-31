package com.jq.service;

import java.awt.image.BufferedImage;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.jq.config.UrlConfig;
import com.jq.service.FileService;
import com.jq.vo.Photo;
import com.jq.vo.PicUploadResult;
@Service
public class FileServiceImpl implements FileService{
 	
    //这个注入配置文件，主要是因为本地的路径和服务器url路径需要动态配置，可以自己写死，也可以动态获取
	 @Autowired
	 UrlConfig urlConfig;
	 private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Override
	public PicUploadResult uploadFile(MultipartFile[] uploadFiles, HttpServletRequest request) {
	
      
       PicUploadResult result = new PicUploadResult();
      List<Photo> list = new ArrayList<>();
 
         if(uploadFiles == null){
         return PicUploadResult.fail(1, list);
        }
      
      for (MultipartFile uploadFile : uploadFiles) {
	
    	 //1.获取文件的名称     abc.jpg
   		String fileName = uploadFile.getOriginalFilename();
   		
   		//2.判断是否为图片类型  .代表任意一个不为空格的字符
   		if(!fileName.matches("^.*(jpg|png|gif)$")){
   			logger.debug("upload is not picture type, fileName = [" + fileName + "]");
   			result.setError(1); //表示不是一个图片
   			return result;
   		}
   		
   		try {
   			//3.判断是否为恶意程序
   			BufferedImage bufferedImage = 
   					ImageIO.read(uploadFile.getInputStream());
   			
   			//4.获取图片的高度和宽度
   			int height = bufferedImage.getHeight();//获取高度
   			int width = bufferedImage.getWidth();  //获取宽度
   			
   			if(height == 0 || width == 0){
   				//表示不是图片
   				logger.debug("upload is not picture , fileName = [" + fileName + "]");
   				result.setError(1);
   				return result;
   			}
   			
   			//如果程序执行到这里表示图片正常
   			//5.定义本地磁盘的路径
   			//String LPath = "E:/jt-upload/";
   		
   			//6.拼接存储文件夹   E:/jt-upload/yyyy/MM/dd/HH
   			String filePath = urlConfig.getFilepath();
   			
   			//7.判断文件夹是否存在
   			File file = new File(filePath);
   			
   			if(!file.exists()){
   				//表示文件不存在
   				file.mkdirs();	//创建文件夹
   			}
   			
   			//8.重构文件名,让文件名称尽可能不一致
   			
   			//获取文件的类型    abc.jpg===>.jpg
   			String fileType = 
   					fileName.substring(fileName.lastIndexOf("."));
   			
   			//使用UUID生成文件名称  sdfsdfsdf-sdfsdfa-sadfasdf-asdfasd
   			String uuid = UUID.randomUUID().toString()
   					.replace("-", "");
   			
   			/**
   			 * 形成文件的完成路径  E:/jt-upload/yyyy/MM/dd/HH/asdfasdfasdf.jpg
   			 */
   			String realPath = file.getAbsolutePath()  + "/" + uuid + fileType;
	
   			//9.写盘操作
   			uploadFile.transferTo(new File(realPath));
   			
   			//10.封装虚拟路径,用户图片的展现
   			//String uPath = "http://image.jt.com/";
   			
   			//拼接虚拟路径 
   			//http://image.jt.com/2018/03/02/16/
   			String realUrlPath = urlConfig.getUrlpath() + "/"
   					+ uuid + fileType;
   			Photo Photo = new Photo();
   			Photo.setUrl(realUrlPath);
   			Photo.setHeight(height + "");
   			Photo.setWidth(width + "");
            list.add(Photo);
    	
   	
   		} catch (Exception e) {
   			logger.error("upload fail , e = [" + e + "]");
   			result.setError(1); //表示非法图片
   			return result;
   		}   
    	   
      }
     
     result.setData(list);
  	return result;	
	}
	
	}


