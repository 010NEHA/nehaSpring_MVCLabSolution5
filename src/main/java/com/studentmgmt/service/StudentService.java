package com.studentmgmt.service;

import java.util.List;

import com.studentmgmt.model.Student;

public interface StudentService {
	
	/**
	 * add, delete, update, get, getall
	 */

	List<Student> getAllStudents();
	Student getStudentById(Integer studentId);
	void saveOrUpdate(Student student);
	Student deleteStudentById(Integer studentId);
	
}
