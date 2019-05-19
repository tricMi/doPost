package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import entity.Account;
import entity.Attachment;

public interface AttachmentRepository extends JpaRepository<Attachment, Integer>{

}
