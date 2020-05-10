package com.jq.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.jq.vo.PicUploadResult;

@Service
public interface FileService {

	PicUploadResult uploadFile(MultipartFile[] uploadFiles,  HttpServletRequest request, String dir);
	
}
