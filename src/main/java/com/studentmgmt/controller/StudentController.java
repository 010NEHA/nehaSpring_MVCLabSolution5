package com.studentmgmt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.studentmgmt.model.Student;
import com.studentmgmt.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@GetMapping("/")
	public String getAllStudent(Model model) {
		List<Student> allStudents = studentService.getAllStudents();
		model.addAttribute("studentModel", allStudents);
		return "studentlist";
	}
	
	@GetMapping("/add")
	public String addStudent(Model model) {
		Student student = new Student();
		model.addAttribute("student", student);
		return "savestudent";
	}
	
	@GetMapping("/update")
	public String updateStudent(
			@RequestParam Integer id,
			Model model) {
		Student studentById = studentService.getStudentById(id);
		model.addAttribute("student", studentById);
		return "savestudent";
	}
	
	@PostMapping("/save")
	public String saveStudent(@ModelAttribute Student student) {
		studentService.saveOrUpdate(student);
		return "redirect:/";
	}
	
	@GetMapping("/delete")
	public String deleteStudent(@RequestParam Integer id) {
		studentService.deleteStudentById(id);
		return "redirect:/";
	}
	
	@GetMapping("/home")
	public String gotoHome() {
		return "redirect/";
	}
	
}
