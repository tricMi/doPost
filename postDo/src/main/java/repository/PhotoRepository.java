package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import entity.Account;
import entity.Photo;

public interface PhotoRepository extends JpaRepository<Photo, Integer>{

	Photo findOne(Integer id);

}
