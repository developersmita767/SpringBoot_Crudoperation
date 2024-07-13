package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.entity.Student;
import com.example.service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {
	@Autowired
	StudentService studentService;
	
	@GetMapping("/register")
	public String showRegisterPage(Model model) {
		Student student = new Student();
		model.addAttribute("student",student);
		return "register";
	}
	
	@PostMapping("/create")
	public String registerStudent(@ModelAttribute Student student, Model model) {
		String message = studentService.createStudent(student);
		model.addAttribute("message",message);
		return "redirect:/student/display";
	}
	
	@GetMapping("/display")
	public String showStudents(Model model) {
		List<Student> students = studentService.getStudents();
		model.addAttribute("students", students);
		return "display";
	}
}
