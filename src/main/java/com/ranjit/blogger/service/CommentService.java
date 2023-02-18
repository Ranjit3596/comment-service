package com.ranjit.blogger.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ranjit.blogger.dto.Comment;
import com.ranjit.blogger.entity.CommentEntity;


public interface CommentService {

	public Comment saveComment(Comment user);
	public Comment comment(Comment user);
	public Comment updateUser(Comment user,Integer userId);
	public Comment getUserById(Integer userId);
	public List<Comment> getAllUsers();
	public void deleteUserById(Integer userId);
	
	
}
