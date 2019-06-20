package com.example.postDo.service;

import java.util.List;

import com.example.postDo.entity.Tag;

public interface TagServiceInterface {
	
	Tag findOne(Long id);
	
	List<Tag> findAll();
	
	Tag save(Tag tag);
	
	void remove(Long id);

}
