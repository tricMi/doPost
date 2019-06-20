package com.example.postDo.service;

import java.util.List;

import com.example.postDo.entity.Attachment;

public interface AttachmentServiceInterface {
	
	Attachment findOne(Long id);
	
	List<Attachment> findAll();
	
	Attachment save(Attachment attachment);
	
	void remove(Long id);

}
