package com.example.postDo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.postDo.entity.Account;
import com.example.postDo.entity.Photo;

public interface PhotoRepository extends JpaRepository<Photo, Integer>{

	Photo findOne(Integer id);

}
