package com.example.postDo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.postDo.entity.Folder;

public interface FolderRepository extends JpaRepository<Folder, Long>{

//	List<Folder> findAllByAccountAndParentFolderIsNull();

	List<Folder> findByParent(Folder folder);
}
