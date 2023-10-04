package com.school.service.admin;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.dto.SingleStudentDto;
import com.school.dto.StudentDto;
import com.school.dto.StudentLeaveDto;
import com.school.entity.StudentLeave;
import com.school.entity.User;
import com.school.enums.StudentLeaveStatus;
import com.school.repository.StudentLeaveRepository;
import com.school.repository.UserRepository;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	private UserRepository repository;
	@Autowired
	private StudentLeaveRepository leaveRepo;

	@Override
	public SingleStudentDto getStudentById(int id) {
		Optional<User> findById = repository.findById(id);
			SingleStudentDto singleStudentDto = new SingleStudentDto();
			//singleStudentDto.setStudentDto(findById.get().getStudentDto());
			findById.ifPresent(user->singleStudentDto.setStudentDto(findById.get().getStudentDto()));
			return singleStudentDto;
	}

	@Override
	public StudentLeaveDto applyLeave(StudentLeaveDto leaveDto) {
		Optional<User> findById = repository.findById(leaveDto.getUserId());
		if(findById.isPresent())
		{
			StudentLeave leave = new StudentLeave();
			leave.setSubject(leaveDto.getSubject());
			leave.setBody(leaveDto.getBody());
			leave.setDate(new Date());
			leave.setStudentLeaveStatus(StudentLeaveStatus.Pending);
			leave.setUser(findById.get());
			StudentLeave studentLeave = leaveRepo.save(leave);
			StudentLeaveDto studentLeaveDto=new StudentLeaveDto();
			studentLeaveDto.setId(studentLeave.getId());
			return studentLeaveDto;
		}
		return null;
	}

	@Override
	public List<StudentLeaveDto> getAllApplyLeaveStudentById(int studentId) {
		
		return leaveRepo.findAllByUserId(studentId).stream().map(StudentLeave::getStudentLeaveDto).collect(Collectors.toList());
	}

	@Override
	public StudentDto updateStudent(int studentId, StudentDto dto) {
		Optional<User> findById = repository.findById(studentId);
		if(findById.isPresent())
		{
			User user = findById.get();
			user.setName(dto.getName());
			user.setGander(dto.getGander());
			user.setAddress(dto.getAddress());
			user.setDob(dto.getDob());
			user.setEmail(dto.getEmail());
			user.setFatherName(dto.getFatherName());
			user.setMotherName(dto.getMotherName());
			user.setStudentClass(dto.getStudentClass());
			User upateSutudent = repository.save(user);
			StudentDto studentDto=new StudentDto();
			studentDto.setId(upateSutudent.getId());
			return studentDto;
		}
		return null;
	}
}
