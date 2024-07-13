package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Student;
import com.example.repository.StudentRepository;

@Service
public class StudentService {
	@Autowired
	StudentRepository studentRepository;
	
	public String createStudent(Student student) {
		studentRepository.save(student);
		return "You have been registered successfully";
	}
	public List<Student> getStudents() {
		return studentRepository.findAll();
	}
	
}
