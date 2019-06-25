package com.example.postDo.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.postDo.service.PhotoServiceInterface;

@RestController
@RequestMapping(value = "api/photos")
public class PhotoController {

	@Autowired
	private PhotoServiceInterface photoService;
	
	@PostMapping(value = "/uploadImage", consumes="multipart/form-data")
	public ResponseEntity<Void> uploadImage(@RequestParam("img") MultipartFile file) throws IOException {
		System.out.println("DO YOU COPY");
		
		if(file != null) {
			System.out.println("DO YOU COPY");

			File convertFile = new File("src/main/resources/static/" + file.getOriginalFilename());
			
			System.out.println(file.getOriginalFilename());
			convertFile.createNewFile();

			FileOutputStream fileOutputStream = new FileOutputStream(convertFile);
		
			fileOutputStream.write(file.getBytes());
			
			fileOutputStream.close();
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		
		return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		
	}
}
