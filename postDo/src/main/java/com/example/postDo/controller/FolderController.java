package com.example.postDo.controller;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.postDo.dto.FolderDTO;
import com.example.postDo.entity.Folder;
import com.example.postDo.service.FolderServiceInterface;
import com.example.postDo.service.RuleServiceInterface;


@RestController
@RequestMapping(value = "api/folders")
public class FolderController {
	
	@Autowired
	private FolderServiceInterface folderService;
	
	@Autowired
	private RuleServiceInterface ruleService;
	
	@GetMapping
	public ResponseEntity<List<FolderDTO>> getFolders() {
		
		List<Folder> folders = folderService.findAll();
		
		List<FolderDTO> folderDTO = new ArrayList<FolderDTO>();
		
		for(Folder f: folders) {
			folderDTO.add(new FolderDTO(f));
		}
		
		return new ResponseEntity<List<FolderDTO>>(folderDTO, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<FolderDTO> getFolder(@PathVariable("id") Long id) {
		
		Folder folder = folderService.findOne(id);
		
		if(folder == null){
			return new ResponseEntity<FolderDTO>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<FolderDTO>(new FolderDTO(folder), HttpStatus.OK);
	}
	
	@PostMapping(consumes="application/json")
	public ResponseEntity<FolderDTO> saveFolder(@RequestBody FolderDTO folderDTO) {
		
		Folder folder = new Folder();
		
		folder.setName(folder.getName());
		folder.setRule(ruleService.findOne(folder.getId()));
		
		if(folderDTO.getParentFolder() != null && folderDTO.getParentFolder().getId() != null){
			Folder parentFolder = folderService.findOne(folderDTO.getParentFolder().getId()); 
			folder.setFolder(parentFolder);
		}
	
		folder = folderService.save(folder);
		return new ResponseEntity<FolderDTO>(new FolderDTO(folder), HttpStatus.CREATED);	
	}
	
	
	@PutMapping(value="/{id}", consumes="application/json")
	public ResponseEntity<FolderDTO> updateFolder(@RequestBody FolderDTO folderDTO, @PathVariable("id") Long id) {
		
		Folder folder = folderService.findOne(id); 
		
		if (folder == null) {
			return new ResponseEntity<FolderDTO>(HttpStatus.BAD_REQUEST);
		}	
		
		folder.setName(folder.getName());
		folder.setRule(ruleService.findOne(folder.getId()));
		
		if(folderDTO.getParentFolder() != null && folderDTO.getParentFolder().getId() != null){
			Folder parentFolder = folderService.findOne(folderDTO.getParentFolder().getId()); 
			folder.setFolder(parentFolder);
		}
	
		folder = folderService.save(folder);
		return new ResponseEntity<FolderDTO>(new FolderDTO(folder), HttpStatus.CREATED);	
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> deleteFolder(@PathVariable("id") Long id) {
		Folder folder = folderService.findOne(id);
		if (folder != null){
			folderService.remove(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} 
		else 
		{		
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
	

}
