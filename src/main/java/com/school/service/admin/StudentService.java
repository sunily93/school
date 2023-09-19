package com.school.service.admin;

import java.util.List;

import com.school.dto.SingleStudentDto;
import com.school.dto.StudentLeaveDto;

public interface StudentService {

	SingleStudentDto getStudentById(int id);

	StudentLeaveDto applyLeave(StudentLeaveDto leaveDto);

	List<StudentLeaveDto> getAllApplyLeaveStudentById(int userId);

	
}
