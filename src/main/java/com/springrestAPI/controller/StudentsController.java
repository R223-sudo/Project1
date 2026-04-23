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
import com.springrestAPI.exception.StudentDeletedException;
import com.springrestAPI.exception.StudentNotFoundException;
import com.springrestAPI.repository.Studentrepository;

import jakarta.validation.Valid;

@RestController
public class StudentsController {

	@Autowired
	Studentrepository repo;

	@GetMapping("/Student")
	public List<Student> getAllStudents() {
		return repo.findByrecordstatus("1");
	}

	@GetMapping("/Student/{id}")
	public Student getStudent(@PathVariable int id) {
		Student student = repo.findById(id).orElseThrow(() -> new StudentNotFoundException(id));

		if (!"1".equals(student.getRecordstatus())) {
			throw new StudentDeletedException(id);
		}

		return student;
	}

	@PostMapping("/Student/add")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void createStudent(@Valid @RequestBody Student student) {
		student.setRecordstatus("1");
		repo.save(student);
	}

	@DeleteMapping("/Student/delete/{id}")
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	public void removeStudent(@PathVariable int id) {
		Student student = repo.findById(id).orElseThrow(() -> new StudentNotFoundException(id));
		student.setRecordstatus("-1");
		repo.save(student);
	}
}
