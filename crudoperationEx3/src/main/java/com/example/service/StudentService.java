package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Student;
import com.example.repository.StudentRepository;
import com.fasterxml.jackson.annotation.OptBoolean;


@Service
public class StudentService {
	@Autowired
	StudentRepository studentRepository;
	public String createStudent(Student student) {
		studentRepository.save(student);
		return"you have registered successfully";
	}
	public List<Student>  getStudents(){
		return studentRepository.findAll();
	}
	public void deleteStudent(int id) {
		studentRepository.deleteById(id);
	}
	public Student getStudentById(Integer id) {
		Optional<Student> student=studentRepository.findById(id);
		return student.get();
		
	}
	public String updateStudent(Student student) {
		studentRepository.save(student);
		return "record update successfully";
	}

}
