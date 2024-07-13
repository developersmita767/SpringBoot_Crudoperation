package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
	public String showStudentPage(Model model) {
		Student student=new Student();
		model.addAttribute("student",student);
		
		return"register";
		
	}
	@PostMapping("/create")
	public String register(@ModelAttribute Student student,Model model) {
		String message=studentService.createStudent(student);
		model.addAttribute("message",message);
		return "redirect:/student/display";
		
		
	}
	@GetMapping("/display")
	public String showStudents(Model model) {
		List<Student> students=studentService.getStudents();
		model.addAttribute("students", students);
		return "display";
	}
	@GetMapping("/delete/{id}")
	public String deleteStudent(@PathVariable Integer id,Model model) {
		studentService.deleteStudent(id);
		return "redirect:/student/display";
	}
	@GetMapping("/edit/{id}")
	public String editStudent(@PathVariable Integer id,Model model) {
		Student student=studentService.getStudentById(id);
	   model.addAttribute("student",student);
		
		return "edit";
	}
	@PostMapping("/update/{id}")
	public String updateStudent(@PathVariable Integer id,@ModelAttribute Student student,Model model) {
		
	student.setId(id);
	String message = studentService.updateStudent(student);
	return "redirect:/student/display";
	}
	

}
