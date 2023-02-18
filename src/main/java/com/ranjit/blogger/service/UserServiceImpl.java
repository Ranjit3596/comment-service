package com.ranjit.blogger.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.catalina.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.ranjit.blogger.Exception.ResourceNotFoundException;
import com.ranjit.blogger.dto.Comment;
import com.ranjit.blogger.entity.CommentEntity;
import com.ranjit.blogger.repository.CommentRepository;

@Service
public class UserServiceImpl implements CommentService {

	@Autowired
	CommentRepository commentRepo;
	
	@Autowired
	ModelMapper mapper;

	@Override
	public Comment saveComment(Comment user) {
		return this.comment(user);
	}

	@Override
	public Comment comment(Comment comment) {
		CommentEntity commentEntity = this.mapper.map(comment, CommentEntity.class);
		commentEntity = commentRepo.save(commentEntity);
		comment = this.mapper.map(commentEntity, Comment.class);
		return comment;
	}

	@Override
	public Comment updateUser(Comment user, Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Comment getUserById(Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Comment> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteUserById(Integer userId) {
		// TODO Auto-generated method stub
		
	}

	/*
	 * @Override public Comment updateUser(Comment user, Integer userId) { Comment
	 * updateUser = new Comment(); CommentEntity userEntity =
	 * commentRepo.findById(userId).orElseThrow(()-> new
	 * ResourceNotFoundException("User","Id",userId)); CommentEntity updateUsers =
	 * this.mapper.map(user, CommentEntity.class); updateUsers =
	 * commentRepo.save(updateUsers); Comment updatedUsers =
	 * this.mapper.map(updateUsers, Comment.class); return updatedUsers; }
	 * 
	 * @Override public Comment getUserById(Integer userId) {
	 * 
	 * CommentEntity userEntity = commentRepo.findById(userId).orElseThrow(()-> new
	 * ResourceNotFoundException("User","Id",userId)); Comment users =
	 * this.mapper.map(userEntity, Comment.class); return users; }
	 * 
	 * @Override public List<Comment> getAllUsers() { List<CommentEntity> list =
	 * commentRepo.findAll(); List<Comment> listOfUser =
	 * list.stream().map(userEntity -> { Comment user = new Comment();
	 * user.setUserid(userEntity.getUserid()); user.setEmail(userEntity.getEmail());
	 * user.setName(userEntity.getName()); user.setAbout(userEntity.getAbout());
	 * return user; }).collect(Collectors.toList()); return listOfUser; }
	 * 
	 * @Override public void deleteUserById(Integer userId) {
	 * commentRepo.deleteById(userId); }
	 */
}
