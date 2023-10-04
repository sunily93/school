package com.school.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.school.dto.SingleStudentDto;
import com.school.dto.StudentDto;
import com.school.dto.StudentLeaveDto;
import com.school.service.admin.StudentService;

@RestController
@RequestMapping("/api/students")
public class StudentController {

	@Autowired
	private StudentService service;
	
	@GetMapping("/{id}")
	public ResponseEntity<SingleStudentDto> getStudentById(@PathVariable int id)
	{
		SingleStudentDto dto=service.getStudentById(id);
		if(dto==null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(dto);
	}
	
	@PostMapping("/leave")
	public ResponseEntity<?> applyLeave(@RequestBody StudentLeaveDto leaveDto)
	{
		StudentLeaveDto studentLeaveDto=service.applyLeave(leaveDto);
		if(studentLeaveDto==null)
			return new ResponseEntity<>("Something went wrong",HttpStatus.BAD_REQUEST);
		return ResponseEntity.status(HttpStatus.CREATED).body(studentLeaveDto);
		
	}
	
	@GetMapping("/leave/{studentId}")
	public ResponseEntity<List<StudentLeaveDto>> getAllApplyLeaveStudentById(@PathVariable int studentId)
	{
		List<StudentLeaveDto> dto=service.getAllApplyLeaveStudentById(studentId);
		if(dto==null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(dto);
	}
	
	@PutMapping("/{studentId}")
	public ResponseEntity<?> updateStudent(@PathVariable int studentId,@RequestBody StudentDto dto)
	{
		StudentDto studentDto=service.updateStudent(studentId,dto);
		System.out.println(studentDto.getName());
		if(studentDto==null)
			return new ResponseEntity<>("Something went wrong..",HttpStatus.BAD_REQUEST);
		return ResponseEntity.status(HttpStatus.CREATED).body(studentDto);
	}
}
