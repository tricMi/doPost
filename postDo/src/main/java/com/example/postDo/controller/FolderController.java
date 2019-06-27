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
import com.example.postDo.service.AccountServiceInterface;
import com.example.postDo.service.FolderServiceInterface;


@RestController
@RequestMapping(value = "api/folders")
public class FolderController {
	
	@Autowired
	private FolderServiceInterface folderService;
	
	@Autowired
	private AccountServiceInterface accountService;
	
	
	
	@GetMapping
	public ResponseEntity<List<FolderDTO>> getFolders() {
		
		List<Folder> folders = folderService.findAll();
		
		List<FolderDTO> folderDTO = new ArrayList<FolderDTO>();
		
				
		for(Folder f: folders) {
			List<Folder> subFolders = folderService.findByParent(f);
			for (Folder f1 : subFolders) {
				f.getFolders().add(f1);
				for(Folder f2: f.getFolders()) {
					System.out.println(f2.getName());
					System.out.println(f.getName());
				}
				
			}
			System.out.println(f.getName());
			
//			if(f.getParent() != null) {
//				f.getFolders().add(f.getParent());
//			}
			
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
		
		folder.setName(folderDTO.getName());
		folder.setAccount(accountService.findOne(folderDTO.getAccount().getId()));
		//folder.setRules(new ArrayList<RuleDTO>());
		
		if(folderDTO.getParent() != null && folderDTO.getParent().getId() != null){
			Folder parentFolder = folderService.findOne(folderDTO.getParent().getId()); 
			folder.setParent(parentFolder);
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
		folder.setAccount(accountService.findOne(folderDTO.getAccount().getId()));
		folder.setName(folderDTO.getName());
		
		if(folderDTO.getParent() != null && folderDTO.getParent().getId() != null){
			Folder parentFolder = folderService.findOne(folderDTO.getParent().getId()); 
			folder.setParent(parentFolder);
		}
	
		folder = folderService.save(folder);
		return new ResponseEntity<FolderDTO>(new FolderDTO(folder), HttpStatus.OK);	
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> deleteFolder(@PathVariable("id") Long id) {
		System.out.println("Called");
		Folder folder = folderService.findOne(id);
		if (folder != null){
			System.out.println("Id je: " + id + " " + "Tip je: " + id.TYPE);
			folderService.remove(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} 
		else 
		{		
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
	

	@PostMapping(value="/findSubFolders")
	public ResponseEntity<List<FolderDTO>> findSubFolders(@RequestBody FolderDTO dir) {
		ArrayList<FolderDTO> dirs = new ArrayList<>();
		List<Folder> allFolders = folderService.findAll();
		
		for(Folder f : allFolders) {
			if(f.getParent() != null) {
				if(f.getParent().getId() == dir.getId()) {
					dirs.add(new FolderDTO(f));
//					System.out.println("Tag added manually");
				}
			}
			
		}
		return new ResponseEntity<List<FolderDTO>>(dirs, HttpStatus.OK);
		
	}
	
}
