package com.ranjit.blogger.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ranjit.blogger.dto.ApiResponse;
import com.ranjit.blogger.dto.Comment;
import com.ranjit.blogger.service.CommentService;

@RestController
@RequestMapping("/api/comment")
public class CommentController {

	@Autowired
	CommentService commentService;

	@Value("${server.port}")
	public String port;

	@GetMapping("/getPort")
	public void getPort() {
		System.out.println("Port :" + port);
	}
	
	@PostMapping("/saveComment")
	public ResponseEntity<Comment> saveComment(@Valid @RequestBody Comment comment) {
		comment = commentService.saveComment(comment);
		return new ResponseEntity<Comment>(comment, HttpStatus.CREATED);
	}

	@GetMapping("/getCommentById/{id}")
	public ResponseEntity<Comment> getCommentByUserId(@PathVariable("id") String id) {
		Comment users = commentService.getUserById(Integer.parseInt(id));
		return new ResponseEntity<Comment>(users, HttpStatus.OK);
	}

	@GetMapping("/getAllComment")
	public ResponseEntity<List<Comment>> getAllComment() {
		List<Comment> lsitOfUsers = commentService.getAllUsers();
		return new ResponseEntity<List<Comment>>(lsitOfUsers, HttpStatus.OK);

	}

	@DeleteMapping("/deleteCommentById/{id}")
	public ResponseEntity<ApiResponse> deleteUserById(@PathVariable("id") Integer id) {
		this.commentService.deleteUserById(id);
		return new ResponseEntity<ApiResponse>(new ApiResponse("User delete Successfully", true), HttpStatus.OK);
	}

	 
}
