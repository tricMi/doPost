package com.example.postDo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.postDo.entity.Folder;
import com.example.postDo.repository.FolderRepository;

@Service
public class FolderService implements FolderServiceInterface {
	
	@Autowired
	FolderRepository folderRepository;
	
//	@Override
//	public List<Folder> findByParent(Folder parent) {
//		return folderRepository.findByParent(parent);
//	}

	@Override
	public Folder findOne(Long id) {
		return folderRepository.findById(id).orElse(null);
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
	public void remove(Long id) {
		folderRepository.deleteById(id);
		
	}

}
