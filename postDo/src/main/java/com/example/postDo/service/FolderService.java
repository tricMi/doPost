package com.example.postDo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entity.Folder;
import repository.FolderRepository;

@Service
public class FolderService implements FolderServiceInterface {
	
	@Autowired
	FolderRepository folderRepository;

	@Override
	public Folder findOne(Integer id) {
		return folderRepository.findOne(id);
	}

	@Override
	public List<Folder> findAll() {
		return folderRepository.findAll();
	}

	@Override
	public Folder save(Folder folder) {
		return folderRepository.save(folder);
	}

	@Override
	public void remove(Integer id) {
		folderRepository.deleteById(id);
		
	}

}
