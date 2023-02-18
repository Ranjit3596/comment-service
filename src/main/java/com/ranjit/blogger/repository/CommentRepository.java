package com.ranjit.blogger.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ranjit.blogger.entity.CommentEntity;

public interface CommentRepository extends JpaRepository<CommentEntity, Integer> {
	
	

}
