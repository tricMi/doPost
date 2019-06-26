package com.example.postDo.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


import com.example.postDo.dto.PhotoDTO;
import com.example.postDo.entity.Photo;
import com.example.postDo.service.PhotoServiceInterface;

@RestController
@RequestMapping(value = "api/photos")
public class PhotoController {

	@Autowired
	private PhotoServiceInterface photoService;
	
	@GetMapping
	public ResponseEntity<List<PhotoDTO>> getPhotos() {
		
		List<Photo> photos = photoService.findAll();
		
		List<PhotoDTO> photoDTO = new ArrayList<PhotoDTO>();
		
		for(Photo p: photos) {
			photoDTO.add(new PhotoDTO(p));
		}
		
		return new ResponseEntity<List<PhotoDTO>>(photoDTO, HttpStatus.OK);
	}
	
	@PostMapping(value = "/uploadImage", consumes="multipart/form-data")
	public ResponseEntity<Void> uploadImage(@RequestParam("img") MultipartFile file) throws IOException {

		
		if(file != null) {


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
	
	@PostMapping
	public ResponseEntity<PhotoDTO> savePhoto(@RequestBody PhotoDTO photoDTO) {
		
		Photo photo = new Photo();
		
		photo.setPath(photoDTO.getPath());
	
		photo = photoService.save(photo);
		
		return new ResponseEntity<PhotoDTO>(new PhotoDTO(photo), HttpStatus.CREATED);	
	}
}
