package com.example.postDo.service;

import java.util.List;

import com.example.postDo.entity.Photo;

public interface PhotoServiceInterface {

	Photo findOne(Integer id);
	
	List<Photo> findAll();
	
	Photo save(Photo photo);
	
	void remove(Integer id);
}
