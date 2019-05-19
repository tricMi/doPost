package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entity.Attachment;
import repository.AttachmentRepository;

@Service
public class AttachmentService implements AttachmentServiceInterface{
	
	@Autowired
	AttachmentRepository attachmentRepository;

	@Override
	public Attachment findOne(Integer id) {
		return attachmentRepository.findOne(id);
	}

	@Override
	public List<Attachment> findAll() {
		return attachmentRepository.findAll();
	}

	@Override
	public Attachment save(Attachment attachment) {
		return attachmentRepository.save(attachment);
	}

	@Override
	public void remove(Integer id) {
		attachmentRepository.deleteById(id);
		
	}

}
