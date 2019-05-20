package com.example.postDo.service;

import java.util.List;

import entity.Folder;

public interface FolderServiceInterface {
	
	Folder findOne(Integer id);
	
	List<Folder> findAll();
	
	Folder save(Folder folder);
	
	void remove(Integer id);

}
