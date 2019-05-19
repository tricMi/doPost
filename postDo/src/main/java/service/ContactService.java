package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entity.Contact;
import repository.ContactRepository;

@Service
public class ContactService implements ContactServiceInterface {
	
	@Autowired
	ContactRepository contactRepository;

	@Override
	public Contact findOne(Integer id) {
		return contactRepository.findOne(id);
	}

	@Override
	public List<Contact> findAll() {
		return contactRepository.findAll();
	}

	@Override
	public Contact save(Contact contact) {
		return contactRepository.save(contact);
	}

	@Override
	public void remove(Integer id) {
		contactRepository.deleteById(id);
		
	}

}
