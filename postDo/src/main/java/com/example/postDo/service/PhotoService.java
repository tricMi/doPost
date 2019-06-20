package com.example.postDo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.postDo.entity.Photo;
import com.example.postDo.repository.PhotoRepository;

@Service
public class PhotoService implements PhotoServiceInterface{
	
	@Autowired
	PhotoRepository photoRepository;

	@Override
	public Photo findOne(Long id) {
		return photoRepository.findById(id).orElse(null);
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
	public void remove(Long id) {
		photoRepository.deleteById(id);
		
	}

}
