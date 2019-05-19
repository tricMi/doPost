package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import entity.Account;
import entity.Message;

public interface MessageRepository extends JpaRepository<Message, Integer>{

	Message findOne(Integer id);

}
