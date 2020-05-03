package com.jq.service;

import java.awt.image.BufferedImage;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.imageio.ImageIO;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.jq.service.FileService;
import com.jq.vo.PicUploadResult;
@Service
public class FileServiceImpl implements FileService{
 
	//Spring容器通过注解的形式,动态的获取数据
	private String LPath = "D:/jt-upload/";
	
	private String uPath = "D:/jt-upload/";//TODO  后续用nginx路由一个虚拟路径给前端去调用
	@Override
	public PicUploadResult uploadFile(MultipartFile uploadFile) {
		
		PicUploadResult result = new PicUploadResult();
		
		//1.获取文件的名称     abc.jpg
		String fileName = uploadFile.getOriginalFilename();
		
		//2.判断是否为图片类型  .代表任意一个不为空格的字符
		if(!fileName.matches("^.*(jpg|png|gif)$")){
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
				result.setError(1);
				return result;
			}
			
			//如果程序执行到这里表示图片正常
			//5.定义本地磁盘的路径
			//String LPath = "E:/jt-upload/";
			
			//6.采用时间格式分文件存储 yyyy/MM/dd/HH
			String datePath = 
					new SimpleDateFormat("yyyy/MM/dd/HH")
					.format(new Date());
			
			//7.拼接存储文件夹   E:/jt-upload/yyyy/MM/dd/HH
			String filePath = LPath + datePath;
			
			//8.判断文件夹是否存在
			File file = new File(filePath);
			
			if(!file.exists()){
				//表示文件不存在
				file.mkdirs();	//创建文件夹
			}
			
			//9.重构文件名,让文件名称尽可能不一致
			
			//获取文件的类型    abc.jpg===>.jpg
			String fileType = 
					fileName.substring(fileName.lastIndexOf("."));
			
			//使用UUID生成文件名称  sdfsdfsdf-sdfsdfa-sadfasdf-asdfasd
			String uuid = UUID.randomUUID().toString()
					.replace("-", "");
			
			/**
			 * 形成文件的完成路径  E:/jt-upload/yyyy/MM/dd/HH/asdfasdfasdf.jpg
			 */
			String realPath = filePath + "/" + uuid + fileType;
			
			//10.写盘操作
			uploadFile.transferTo(new File(realPath));
			
			//11.封装虚拟路径,用户图片的展现
			//String uPath = "http://image.jt.com/";
			
			//拼接虚拟路径 
			//http://image.jt.com/2018/03/02/16/
			String realUrlPath = uPath +  datePath + "/"
					+ uuid + fileType;
			
			result.setUrl(realUrlPath);	//赋值url路径
			result.setHeight(height + "");
			result.setWidth(width + "");
			return result;	
		} catch (Exception e) {
			result.setError(1); //表示非法图片
			return result;
		}
	}

	
	
}
