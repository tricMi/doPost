package com.example.postDo.service;

import java.util.List;

import com.example.postDo.entity.Photo;

public interface PhotoServiceInterface {

	Photo findOne(Long id);
	
	List<Photo> findAll();
	
	Photo save(Photo photo);
	
	void remove(Long id);
}
