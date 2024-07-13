package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Student;
import com.example.repository.StudentRepository;

@Service
public class StudentService {
	@Autowired
	StudentRepository studentrepository;
	
	public String createStudent(Student student) {
		studentrepository.save(student);
		return"you have successfully registered";
		
	}

}
