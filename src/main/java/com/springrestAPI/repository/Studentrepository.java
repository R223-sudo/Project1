package com.springrestAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springrestAPI.entity.Student;

public interface Studentrepository extends JpaRepository<Student, Integer> {

}
