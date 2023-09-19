package com.school.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.school.dto.StudentLeaveDto;
import com.school.enums.StudentLeaveStatus;

@Entity
public class StudentLeave {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String subject;
	private String body;
	private Date date;
	private StudentLeaveStatus studentLeaveStatus;
	
	@ManyToOne(fetch=FetchType.LAZY,optional=false)
	@JoinColumn(name="user_id",nullable=false)
	@OnDelete(action=OnDeleteAction.CASCADE)
	@JsonIgnore
	private User user;
	
	public StudentLeave() {
		// TODO Auto-generated constructor stub
	}

	public StudentLeave(int id, String subject, String body, Date date, StudentLeaveStatus studentLeaveStatus,
			User user) {
		super();
		this.id = id;
		this.subject = subject;
		this.body = body;
		this.date = date;
		this.studentLeaveStatus = studentLeaveStatus;
		this.user = user;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public StudentLeaveDto getStudentLeaveDto()
	{
		StudentLeaveDto dto=new StudentLeaveDto();
		dto.setId(id);
		dto.setSubject(subject);
		dto.setBody(body);
		dto.setDate(date);
		dto.setStudentLeaveStatus(studentLeaveStatus);
		dto.setUserId(user.getId());
		return dto;
	}
	
 }
