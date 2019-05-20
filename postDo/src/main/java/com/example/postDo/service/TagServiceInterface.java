package com.example.postDo.service;

import java.util.List;

import entity.Tag;

public interface TagServiceInterface {
	
	Tag findOne(Integer id);
	
	List<Tag> findAll();
	
	Tag save(Tag tag);
	
	void remove(Integer id);

}
