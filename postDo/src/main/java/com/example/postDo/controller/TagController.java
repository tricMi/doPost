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

import com.example.postDo.dto.MessageDTO;
import com.example.postDo.dto.TagDTO;
import com.example.postDo.entity.Tag;
import com.example.postDo.service.TagServiceInterface;

@RestController
@RequestMapping(value = "/api/tags")
public class TagController {
	
	@Autowired
	private TagServiceInterface tagService;
	
	@GetMapping
	public ResponseEntity<List<TagDTO>> getTags() {
		
		List<Tag> tags = tagService.findAll();
		
		List<TagDTO> tagDTO = new ArrayList<TagDTO>();
		
		for(Tag t: tags) {
			tagDTO.add(new TagDTO(t));
		}
		
		return new ResponseEntity<List<TagDTO>>(tagDTO, HttpStatus.OK);
	}
	
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<TagDTO> getTag(@PathVariable("id") Long id) {
		
		Tag tag = tagService.findOne(id);
		
		if(tag == null){
			return new ResponseEntity<TagDTO>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<TagDTO>(new TagDTO(tag), HttpStatus.OK);
	}
	
	@PostMapping(consumes="application/json")
	public ResponseEntity<TagDTO> saveTag(@RequestBody TagDTO tagDTO) {
		
		Tag tag = new Tag();
		
		tag.setName(tagDTO.getName());
		
		tag = tagService.save(tag);
		return new ResponseEntity<TagDTO>(new TagDTO(tag), HttpStatus.CREATED);	
	}
	
	@PutMapping(value="/{id}", consumes="application/json")
	public ResponseEntity<TagDTO> updateTag(@RequestBody TagDTO tagDTO, @PathVariable("id") Long id) {
		
		Tag tag = tagService.findOne(id); 
		
		if (tag == null) {
			return new ResponseEntity<TagDTO>(HttpStatus.BAD_REQUEST);
		}
		
		tag.setName(tagDTO.getName());
		
		tag = tagService.save(tag);
		return new ResponseEntity<TagDTO>(new TagDTO(tag), HttpStatus.OK);	
	
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> deleteTag(@PathVariable("id") Long id) {
		Tag tag = tagService.findOne(id);
		if (tag != null){
			tagService.remove(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} 
		else 
		{		
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping(value="/findTags")
	public ResponseEntity<List<TagDTO>> findTags(@RequestBody MessageDTO msg) {
		ArrayList<TagDTO> tags = new ArrayList<>();
		List<Tag> allTags = tagService.findAll();
		
		for(Tag t : allTags) {
			if(t.getMessage() != null) {
				if(t.getMessage().getId() == msg.getId()) {
					tags.add(new TagDTO(t));
//					System.out.println("Tag added manually");
				}
			}
			
		}
		return new ResponseEntity<List<TagDTO>>(tags, HttpStatus.OK);
		
	}

}
