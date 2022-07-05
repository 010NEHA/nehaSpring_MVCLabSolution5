package com.studentmgmt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentmgmt.dao.StudentDao;
import com.studentmgmt.model.Student;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentDao studentDao;

	@Override
	public List<Student> getAllStudents() {
		return studentDao.getAllStudents();
	}

	@Override
	public Student getStudentById(Integer studentId) {
		return studentDao.getStudentById(studentId);
	}

	@Override
	public void saveOrUpdate(Student student) {
		studentDao.saveStudent(student);
	}

	@Override
	public Student deleteStudentById(Integer studentId) {
		return studentDao.deleteStudentById(studentId);
	}

}
