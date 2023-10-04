package com.school.entity;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.school.dto.TeacherDto;

@Entity
public class Teacher {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private String gender;
	private String dept;
	private String qulification;
	private Date dob;
	private String address;
	
	public TeacherDto getTeacherDto()
	{
		TeacherDto dto=new TeacherDto();
		dto.setId(id);
		dto.setName(name);
		dto.setQulification(qulification);
		dto.setDept(dept);
		dto.setAddress(address);
		dto.setGender(gender);
		dto.setDob(dob);
		return dto;
	}
	
	public Teacher() {
		// TODO Auto-generated constructor stub
	}

	public Teacher(int id, String name, String gender, String dept, String qulification, Date dob, String address) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.dept = dept;
		this.qulification = qulification;
		this.dob = dob;
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getQulification() {
		return qulification;
	}

	public void setQulification(String qulification) {
		this.qulification = qulification;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
}
