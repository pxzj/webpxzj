package com.jq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.jq.service.FileService;
import com.jq.vo.PicUploadResult;

@RestController
@RequestMapping("/manage")
public class FileController {


	@Autowired
	private FileService fileService;
	
	
	//处理文件上传  {"error":0,"url":"图片的保存路径","width":图片的宽度,"height":图片的高度}
	@RequestMapping("/upload")
	public PicUploadResult uploadFile(MultipartFile  uploadFile){
		
		return fileService.uploadFile(uploadFile);
	
	}
	
	
}
