package com.jq.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.jq.service.FileService;
import com.jq.vo.PicUploadResult;

@RestController
@RequestMapping("/manage")
public class FileController {

	@Autowired
    FileService fileService;

	    
	    @RequestMapping("/upload")
	    public PicUploadResult uploadFile(@RequestParam("file") MultipartFile[] file, HttpServletRequest request,  String dir) {
	    
	    	 return fileService.uploadFile(file,request,  dir);
	   
}
}