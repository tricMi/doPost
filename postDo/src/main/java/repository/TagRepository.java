package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import entity.Account;
import entity.Tag;

public interface TagRepository extends JpaRepository<Tag, Integer>{

	Tag findOne(Integer id);

}
