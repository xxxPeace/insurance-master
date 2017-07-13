package com.synergy.insurance.controller;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletContext;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.synergy.insurance.dao.FileUploadDao;

@Controller
public class ImageController {
	@Autowired
	ServletContext servletContext;
	
	@ResponseBody
	@RequestMapping(value = "/photo", method = RequestMethod.GET, produces = MediaType.IMAGE_JPEG_VALUE)
	public byte[] testphoto(@RequestParam String id) throws IOException {
		FileUploadDao fud = new FileUploadDao();
		int id2 = -1;
		try{
		id2 = Integer.parseInt(id);
		} catch(Exception ex){
			System.out.println("not a number");
		}
		String file = "empty";
		if(id2>=0){
			file = fud.getFile(id);
		}
		if(file.equals("empty")){
			InputStream in = servletContext.getResourceAsStream("document/empty.jpg");
			return IOUtils.toByteArray(in);
		}
	    InputStream in = servletContext.getResourceAsStream("/document/" +id+"/"+fud.getFile(id));
	    System.out.println(fud.getFile(id));
	    return IOUtils.toByteArray(in);
	}
}
