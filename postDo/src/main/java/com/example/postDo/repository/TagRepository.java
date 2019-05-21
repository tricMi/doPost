package com.example.postDo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.postDo.entity.Account;
import com.example.postDo.entity.Tag;

public interface TagRepository extends JpaRepository<Tag, Integer>{

//	Tag findOne(Integer id);

}
