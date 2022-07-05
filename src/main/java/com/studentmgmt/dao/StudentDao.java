package com.studentmgmt.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.studentmgmt.model.Student;

@Repository
public class StudentDao {
	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Transactional
	public void saveStudent(Student student) {
		hibernateTemplate.saveOrUpdate(student);
	}
	
	public Student getStudentById(Integer studentId) {
		return hibernateTemplate.get(Student.class, studentId);
	}
	
	public List<Student> getAllStudents() {
		return hibernateTemplate.loadAll(Student.class);
	}
	
	@Transactional
	public Student deleteStudentById(Integer studentId) {
		Student student = hibernateTemplate.get(Student.class, studentId);
		hibernateTemplate.delete(student);
		return student;
	}

}
