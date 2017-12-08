package com.jt.manage.controller;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.jt.common.vo.PicUploadResult;
import com.jt.manage.service.PicUpLoadService;

@Controller
public class PicUpLoadController {
	@Autowired
	private PicUpLoadService picUpLoadService;
	
	private static final Logger log=Logger.getLogger(PicUpLoadController.class);
	@RequestMapping("/pic/upload")
	@ResponseBody
	public PicUploadResult picUpload(MultipartFile uploadFile){
		PicUploadResult result=new PicUploadResult();
		try {
			result=picUpLoadService.picUpload(uploadFile);
		} catch (IOException e) {
			String message=e.getMessage();
			log.error(message);
			result.setError(1); 
		}
		return result;
	}
}
