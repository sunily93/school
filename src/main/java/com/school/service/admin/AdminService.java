package com.school.service.admin;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.school.dto.FeeDto;
import com.school.dto.SingleStudentDto;
import com.school.dto.StudentDto;

public interface AdminService {

	StudentDto postStudent(StudentDto dto);

	List<StudentDto> getAllStudents();

	void deleteStudent(int id);

	SingleStudentDto getStudentById(int id);

	StudentDto updateStudent(int studentId, StudentDto dto);

	FeeDto payFee(int studentId, FeeDto dto);

}
