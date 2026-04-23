package com.springrestAPI.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "student", schema = "student_app")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int rollno;

	@NotBlank(message = "name is required")
	@Column(name = "student_name")
	private String name;

	@Min(value = 0, message = "percentage cannot be negative")
	@Max(value = 100, message = "percentage cannot be greater than 100")
	@Column(name = "student_percentage")
	private float percentage;

	@NotBlank(message = "branch is required")
	@Column(name = "student_branch")
	private String branch;

	@Column(name = "recordstatus")
	private String recordstatus;

	@Column(name = "created_on", updatable = false)
	private LocalDateTime created_on;

	@NotNull(message = "api_request_ID is required")
	@Column(name = "api_request_ID", nullable = false)
	private Integer api_request_ID;

	@PrePersist
	public void setCreatedon() {
		this.created_on = LocalDateTime.now();
	}

	public Student() {
	}

	public Student(int rollno, String name, float percentage, String branch, String recordstatus) {
		super();
		this.rollno = rollno;
		this.name = name;
		this.percentage = percentage;
		this.branch = branch;
		this.recordstatus = recordstatus;
	}

	public int getRollno() {
		return rollno;
	}

	public void setRollno(int rollno) {
		this.rollno = rollno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPercentage() {
		return percentage;
	}

	public void setPercentage(float percentage) {
		this.percentage = percentage;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getRecordstatus() {
		return recordstatus;
	}

	public void setRecordstatus(String recordstatus) {
		this.recordstatus = recordstatus;
	}

	public LocalDateTime getCreated_on() {
		return created_on;
	}

	public Integer getApi_request_ID() {
		return api_request_ID;
	}

	public void setApi_request_ID(Integer api_request_ID) {
		this.api_request_ID = api_request_ID;
	}

	@Override
	public String toString() {
		return "Student [rollno=" + rollno + ", name=" + name + ", percentage=" + percentage + ", branch=" + branch
				+ ", recordstatus=" + recordstatus + "]";
	}
}
