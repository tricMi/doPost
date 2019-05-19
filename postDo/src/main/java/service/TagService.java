package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entity.Tag;
import repository.TagRepository;

@Service
public class TagService implements TagServiceInterface {
	
	@Autowired
	TagRepository tagRespository;

	@Override
	public Tag findOne(Integer id) {
		return tagRespository.findOne(id);
	}

	@Override
	public List<Tag> findAll() {
		return tagRespository.findAll();
	}

	@Override
	public Tag save(Tag tag) {
		return tagRespository.save(tag);
	}

	@Override
	public void remove(Integer id) {
		tagRespository.deleteById(id);
		
	}

}
