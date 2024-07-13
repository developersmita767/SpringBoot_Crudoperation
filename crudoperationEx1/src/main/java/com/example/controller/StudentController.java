package com.example.controller;

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
	StudentService studentservice;
	
	@GetMapping("/register")
	public String showRegister(Model model) {
		Student student=new Student();
		model.addAttribute("student",student);
		
		return "register";
		
	}
	@PostMapping("/create")
	public String registerStudent(@ModelAttribute Student student,Model model) {
		String message=studentservice.createStudent(student);
		model.addAttribute("message",message);
		
		return"register";
		
	}
	

}
