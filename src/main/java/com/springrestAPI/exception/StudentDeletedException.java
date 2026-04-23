package com.springrestAPI.exception;

public class StudentDeletedException extends RuntimeException {

	public StudentDeletedException(int id) {
		super("Student is deleted with id: " + id);
	}
}
