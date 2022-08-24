package com.student.service;

import java.util.List;
import java.util.Optional;


import com.student.model.Student;



public interface IStudentService {

	Integer saveStudent(Student student);
	public List<Student> getAllStudent();
	public void deleteStudent(Integer sid);
	Student updateStudent(Student student, Integer sid) throws Exception;
	Optional<Student> getStudentById(Integer id);
	public List<Student> getStudentByClass(Integer classNo);
	
}
