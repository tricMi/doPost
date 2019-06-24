package com.example.postDo.service;

import java.util.List;

import com.example.postDo.entity.Folder;

public interface FolderServiceInterface {
	
	List<Folder> findByParent(Folder folder);
	
	//public List<Folder> findAllByAccountAndParentFolderIsNull();
	
	Folder findOne(Long id);
	
	List<Folder> findAll();
	
	Folder save(Folder folder);
	
	void remove(Long id);

}
