package com.school.entity;



import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.school.dto.StudentDto;
import com.school.enums.UserRole;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private String email;
	private String password;
	private String fatherName;
	private String motherName;
	private String studentClass;
	private String address;
	private String gander;
	private Date dob;
	private UserRole role;
	
	public StudentDto getStudentDto()
	{
		StudentDto dto=new StudentDto();
		dto.setId(id);
		dto.setEmail(email);
		dto.setName(name);
		dto.setFatherName(fatherName);
		dto.setMotherName(motherName);
		dto.setStudentClass(studentClass);
		dto.setPassword(password);
		dto.setAddress(address);
		dto.setGander(gander);
		dto.setDob(dob);
		return dto;
	}
}
