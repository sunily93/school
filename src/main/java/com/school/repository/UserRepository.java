package com.school.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.school.dto.StudentDto;
import com.school.entity.User;
import com.school.enums.UserRole;

public interface UserRepository extends JpaRepository<User, Integer>
{
	User findByRole(UserRole admin);

	Optional<User> findByEmail(String username);

	List<User> findAllByRole(UserRole student);
}
