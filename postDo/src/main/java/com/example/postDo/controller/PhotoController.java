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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.postDo.dto.PhotoDTO;
import com.example.postDo.entity.Photo;
import com.example.postDo.service.ContactServiceInterface;
import com.example.postDo.service.PhotoServiceInterface;

@RestController
@RequestMapping(value = "api/photos")
public class PhotoController {

	@Autowired
	private PhotoServiceInterface photoService;
	
	@Autowired
	private ContactServiceInterface contactService;
	
	@PostMapping(value = "/uploadImage", consumes="multipart/form-data")
	public ResponseEntity<PhotoDTO> uploadImage(@RequestParam("img") MultipartFile file, @RequestBody PhotoDTO photoDTO) throws IOException {
		
		Photo photo = new Photo();
		
		//check if there is image file
		if(file != null) {
			photo.setPath(file.getOriginalFilename());
			photo.setContact(contactService.findOne(photo.getContact().getId()));

			File convertFile = new File("src/main/resources/static/" + file.getOriginalFilename());
			
			System.out.println(file.getOriginalFilename());
			convertFile.createNewFile();

			FileOutputStream fileOutputStream = new FileOutputStream(convertFile);
		
			fileOutputStream.write(file.getBytes());
			
			fileOutputStream.close();
			return new ResponseEntity<PhotoDTO>(new PhotoDTO(photo), HttpStatus.CREATED);
		}
		
		return new ResponseEntity<PhotoDTO>(HttpStatus.BAD_REQUEST);
		
	}
}
