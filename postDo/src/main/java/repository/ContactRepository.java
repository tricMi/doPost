package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import entity.Account;
import entity.Contact;

public interface ContactRepository extends JpaRepository<Contact, Integer>{

	Contact findOne(Integer id);

}
