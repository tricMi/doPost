package com.example.postDo.service;

import java.util.List;

import com.example.postDo.entity.Tag;

public interface TagServiceInterface {
	
	Tag findOne(Integer id);
	
	List<Tag> findAll();
	
	Tag save(Tag tag);
	
	void remove(Integer id);

}
