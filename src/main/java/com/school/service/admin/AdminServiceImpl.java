package com.school.service.admin;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.school.dto.FeeDto;
import com.school.dto.SingleStudentDto;
import com.school.dto.StudentDto;
import com.school.entity.Fee;
import com.school.entity.User;
import com.school.enums.UserRole;
import com.school.repository.FeeRepository;
import com.school.repository.UserRepository;

@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	private UserRepository repository;
	
	@Autowired
	private FeeRepository feeRepository;
	
	@PostConstruct
	public void createAdmin()
	{
		User role=repository.findByRole(UserRole.ADMIN);
		if(role==null)
		{
			User admin=new User();
			admin.setEmail("admin@test.com");
			admin.setName("Admin");
			admin.setRole(UserRole.ADMIN);
			admin.setPassword(new BCryptPasswordEncoder().encode("admin"));
			repository.save(admin);			
		}
	}
	
//	@PostConstruct
//	public void createStudent()
//	{
//		User role=repository.findByRole(UserRole.STUDENT);
//		if(role==null)
//		{
//			User student=new User();
//			student.setEmail("student@test.com");
//			student.setName("Student");
//			student.setRole(UserRole.STUDENT);
//			student.setPassword(new BCryptPasswordEncoder().encode("student"));
//			repository.save(student);			
//		}
//	}

	@Override
	public StudentDto postStudent(StudentDto dto) {

		Optional<User> findByEmail = repository.findByEmail(dto.getEmail());
		System.out.println(dto.getName());
		//System.out.println(findByEmail.get().getName()+" new ");
		if(findByEmail!=null)
		{System.out.println("HEllooo");
			User user = new User();
			BeanUtils.copyProperties(dto, user);
			user.setPassword(new BCryptPasswordEncoder().encode(dto.getPassword()));
			user.setRole(UserRole.STUDENT);
			User save = repository.save(user);
			StudentDto studentDto = new StudentDto();
			System.out.println(save.getName()+" User");
			studentDto.setId(save.getId());
			studentDto.setEmail(save.getEmail());
			return studentDto;
		}
		return null;
	}

	@Override
	public List<StudentDto> getAllStudents() {
		return repository.findAllByRole(UserRole.STUDENT).stream().map(User::getStudentDto).collect(Collectors.toList());
	}

	@Override
	public void deleteStudent(int id) {
		System.out.println(id);
		repository.deleteById(id);
	}

	@Override
	public SingleStudentDto getStudentById(int id) {
		Optional<User> findById = repository.findById(id);
			SingleStudentDto singleStudentDto = new SingleStudentDto();
			//singleStudentDto.setStudentDto(findById.get().getStudentDto());
			findById.ifPresent(user->singleStudentDto.setStudentDto(findById.get().getStudentDto()));
			return singleStudentDto;
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

	@Override
	public FeeDto payFee(int studentId, FeeDto dto) {
		Optional<User> findById = repository.findById(studentId);
		if(findById.isPresent())
		{
			Fee fee=new Fee();
			fee.setAmount(dto.getAmount());
			fee.setMonth(dto.getMonth());
			fee.setDisc(dto.getDisc());
			fee.setCreatedDate(new Date());
			fee.setGivenBy(dto.getGivenBy());
			fee.setUser(findById.get());
			Fee paidFee = feeRepository.save(fee);
			FeeDto feeDto = new FeeDto();
			feeDto.setId(paidFee.getId());
			return feeDto;
		}
		return null;
	}
}
