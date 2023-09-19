package com.school.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {

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
}
