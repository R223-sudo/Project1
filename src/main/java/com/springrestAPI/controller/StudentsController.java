package com.springrestAPI.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.springrestAPI.entity.Student;
import com.springrestAPI.repository.Studentrepository;

@RestController
public class StudentsController {

	@Autowired
	Studentrepository repo;

	// get all students list
	@GetMapping("/Student")
	public List<Student> getAllStudents() {
		//List<Student> Students = repo.findAll();
		return repo.findByrecordstatus("1");
	}

	// localhost:8080/Student/1
	@GetMapping("/Student/{id}")
	public Student getStudent(@PathVariable int id) {
		Optional<Student> Studentopt = repo.findById(id);
		// add the validation
		if (Studentopt.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not found");
		}	
		Student student=Studentopt.get();
		
		if (!student.getRecordstatus().equals("1"))  {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Student is deleted");
		}
		
		return student;
		
		/*Student student = repo.findById(id).get();
		return student;*/
	}

	@PostMapping("/Student/add")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void CreateStudent(@RequestBody Student student) {
		student.setRecordstatus("1"); // default active 
		repo.save(student);
	}

	@DeleteMapping("/Student/delete/{id}")
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	public void removeStudent(@PathVariable int id) {
		Student student = repo.findById(id).orElseThrow(() -> new RuntimeException("Student not Found"));
		student.setRecordstatus("-1"); // mark as deleted
		repo.save(student); //update instead of delete 

	}

}
