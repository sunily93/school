package com.school.dto;

import java.util.Date;

import com.school.enums.StudentLeaveStatus;

public class StudentLeaveDto {

	private int id;
	private String subject;
	private String body;
	private Date date;
	private StudentLeaveStatus studentLeaveStatus;

	private int userId;
	
	public StudentLeaveDto() {
		// TODO Auto-generated constructor stub
	}

	public StudentLeaveDto(int id, String subject, String body, Date date, StudentLeaveStatus studentLeaveStatus,int userId) {
		super();
		this.id = id;
		this.subject = subject;
		this.body = body;
		this.date = date;
		this.studentLeaveStatus = studentLeaveStatus;
		this.userId=userId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public StudentLeaveStatus getStudentLeaveStatus() {
		return studentLeaveStatus;
	}

	public void setStudentLeaveStatus(StudentLeaveStatus studentLeaveStatus) {
		this.studentLeaveStatus = studentLeaveStatus;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	
}
