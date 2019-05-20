package com.example.postDo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.postDo.entity.Account;
import com.example.postDo.entity.Folder;

public interface FolderRepository extends JpaRepository<Folder, Integer>{

}
