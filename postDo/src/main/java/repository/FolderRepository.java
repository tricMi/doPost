package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import entity.Account;
import entity.Folder;

public interface FolderRepository extends JpaRepository<Folder, Integer>{

	Folder findOne(Integer id);

}
