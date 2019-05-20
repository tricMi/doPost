package com.example.postDo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entity.Photo;
import repository.PhotoRepository;

@Service
public class PhotoService implements PhotoServiceInterface{
	
	@Autowired
	PhotoRepository photoRepository;

	@Override
	public Photo findOne(Integer id) {
		return photoRepository.findOne(id);
	}

	@Override
	public List<Photo> findAll() {
		return photoRepository.findAll();
	}

	@Override
	public Photo save(Photo photo) {
		return photoRepository.save(photo);
	}

	@Override
	public void remove(Integer id) {
		photoRepository.deleteById(id);
		
	}

}
