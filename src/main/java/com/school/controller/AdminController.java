package com.school.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.school.dto.FeeDto;
import com.school.dto.SingleStudentDto;
import com.school.dto.StudentDto;
import com.school.service.admin.AdminService;

@RestController
@RequestMapping("/api/admin")
//@CrossOrigin("http://localhost:4200")
public class AdminController {

	@Autowired
	private AdminService service;
	
	@PostMapping("/student")
	public ResponseEntity<?> addStudent(@RequestBody StudentDto dto)
	{
		StudentDto studentDto=service.postStudent(dto);
		System.out.println(studentDto.getName());
		if(studentDto==null)
			return new ResponseEntity<>("Something went wrong..",HttpStatus.BAD_REQUEST);
		return ResponseEntity.status(HttpStatus.CREATED).body(studentDto);
	}
	
	@GetMapping("/students")
	public ResponseEntity<List<StudentDto>> getAllStudent()
	{
		return ResponseEntity.ok(service.getAllStudents());
	}
	
	@DeleteMapping("/student/{id}")
	public ResponseEntity<Void> deleteStudent(@PathVariable int id)
	{
		System.out.println(id+" aaaa");
		service.deleteStudent(id);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/student/{id}")
	public ResponseEntity<SingleStudentDto> getStudentById(@PathVariable int id)
	{
		SingleStudentDto dto=service.getStudentById(id);
		if(dto==null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(dto);
	}
	
	@PutMapping("/student/{studentId}")
	public ResponseEntity<?> updateStudent(@PathVariable int studentId,@RequestBody StudentDto dto)
	{
		StudentDto studentDto=service.updateStudent(studentId,dto);
		System.out.println(studentDto.getName());
		if(studentDto==null)
			return new ResponseEntity<>("Something went wrong..",HttpStatus.BAD_REQUEST);
		return ResponseEntity.status(HttpStatus.CREATED).body(studentDto);
	}
	
	@PostMapping("/fee/{studentId}")
	public ResponseEntity<?> payFee(@PathVariable int studentId,@RequestBody FeeDto dto)
	{
		FeeDto feeDto=service.payFee(studentId,dto);
		if(feeDto==null)
			return new ResponseEntity<>("Something went wrong..",HttpStatus.BAD_REQUEST);
		return ResponseEntity.status(HttpStatus.CREATED).body(feeDto);
	}
}
