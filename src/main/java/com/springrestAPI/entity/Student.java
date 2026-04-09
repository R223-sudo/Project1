package com.springrestAPI.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "student",schema = "student_app")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int rollno;
	@Column(name = "student_name")
	private String name;
	@Column(name = "student_percentage")
	private float percentage;
	@Column(name = "student_branch")
	private String branch;
	@Column(name = "recordstatus")
	private String recordstatus;
	@Column(name = "created_on",updatable = false)
	private LocalDateTime created_on;
	@NotNull
	@Column (name ="api_request_ID", nullable = false)
	private int api_request_ID;
	
	@PrePersist
	public void setCreatedon() {
		this.created_on= LocalDateTime.now();
	}
    
	public Student() {
		// TODO Auto-generated constructor stub
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

	@Override
	public String toString() {
		return "Student [rollno=" + rollno + ", name=" + name + ", percentage=" + percentage + ", branch=" + branch
				+ ", recordstatus=" + recordstatus + "]";
	}

}
