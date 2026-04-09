package com.springrestAPI.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springrestAPI.entity.Student;
 
public interface Studentrepository extends JpaRepository<Student, Integer> {
	List<Student> findByrecordstatus(String recordstatus);
}
