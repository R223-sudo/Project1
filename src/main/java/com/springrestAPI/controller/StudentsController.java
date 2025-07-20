package com.springrestAPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.springrestAPI.entity.Student;
import com.springrestAPI.repository.Studentrepository;

@RestController
public class StudentsController {

	@Autowired
	Studentrepository repo;

	// get all students list
	@GetMapping("/Student")
	public List<Student> getAllStudents() {
		List<Student> Students = repo.findAll();
		return Students;
	}

	// localhost:8080/Student/1
	@GetMapping("/Student/{id}")
	public Student getStudent(@PathVariable int id) {
		Student student = repo.findById(id).get();
		return student;
	}

	@PostMapping("/Student/add")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void CreateStudent(@RequestBody Student student) {
		repo.save(student);
	}

	@DeleteMapping("/Student/delete/{id}")
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	public void removeStudent(@PathVariable int id) {
		Student student = repo.findById(id).get();
		repo.delete(student);
	}

}
