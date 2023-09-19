package com.school.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.school.entity.StudentLeave;

public interface StudentLeaveRepository extends JpaRepository<StudentLeave, Integer>{

	List<StudentLeave> findAllByUserId(int studentId);

}
