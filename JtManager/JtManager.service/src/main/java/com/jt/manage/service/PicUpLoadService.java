package com.jt.manage.service;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

import org.apache.commons.lang3.RandomUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.jt.common.vo.PicUploadResult;

@Service
public class PicUpLoadService {
	
	public PicUploadResult picUpload(MultipartFile uploadFile) throws IOException {
		PicUploadResult result=new PicUploadResult();
		String oldFileName=uploadFile.getOriginalFilename();
		String endFileName=oldFileName.substring(oldFileName.lastIndexOf("."));
		if(!endFileName.matches("^.*(jpg|png|gif)$")){
			result.setError(1);
		}
		BufferedImage bufImage=ImageIO.read(uploadFile.getInputStream());
		result.setHeight(bufImage.getHeight()+"");
		result.setWidth(bufImage.getWidth()+"");
		String dir="/images/"+new SimpleDateFormat("yyyy/MM/dd").format(new Date())+"/";
		String urlPrefix="http://image.jt2.com"+dir;
		String path="d:/tts9/jt-upload/images"+dir;
		File _dir=new File(path);
		if(!_dir.exists()){
			_dir.mkdirs();
		}
		String fileName=System.currentTimeMillis()+""+RandomUtils.nextInt(100, 999)+endFileName;
		result.setUrl(urlPrefix+fileName);
		uploadFile.transferTo(new File(path+fileName));
		
		return result;
	}
	
	
}
