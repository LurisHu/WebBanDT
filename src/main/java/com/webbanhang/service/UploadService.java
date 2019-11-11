package com.webbanhang.service;

import java.io.File;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UploadService {
	@Autowired
	ServletContext app;
	
	public String uploadImage(MultipartFile file) {
		String url;
		if (file.isEmpty()) {
			url="default.png";
		} else {
			url=file.getOriginalFilename();
			try {
				String pathlink = app.getRealPath("/static/images/" + url);
				System.out.println("đường dẫn là: "+pathlink);
				file.transferTo(new File(pathlink));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return url;
	}
}
