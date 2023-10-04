package com.school.service.admin;

import static org.hamcrest.CoreMatchers.any;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.school.entity.User;
import com.school.enums.UserRole;
import com.school.repository.FeeRepository;
import com.school.repository.UserRepository;
@ExtendWith(MockitoExtension.class)
class AdminServiceImplTest {

	@Mock
	private UserRepository userRepo;
	
	@Mock
	private FeeRepository feeRepo;
	
	@InjectMocks
	private AdminServiceImpl adminServiceImpl;

	@BeforeEach
	public void setup()
	{
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	public void testSaveAdmin()
	{
		User user=new User();
		user.setEmail("admin@test.com");
		user.setName("Admin");
		user.setRole(UserRole.ADMIN);
		//when(userRepo.save(any(User.class)))
	}
}
