package com.student.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.student.Exception.ResourceNotFound;
import com.student.model.Student;

@Service
public class StudentServiceImpl implements IStudentService {

	@Autowired
	private IStudentRepository studentRepository;
	
	//Method to add new student
	@Override
	public Integer saveStudent(Student student) {

		Student saveStudent = studentRepository.save(student);

		return saveStudent.getSid();
	}

	//Method to get all student
	@Override
	public List<Student> getAllStudent() {

		return studentRepository.findAll();
	}

	//Method to delete student
	@Override
	public void deleteStudent(Integer sid) {

		studentRepository.deleteById(sid);

	}

	//method to update student
	@Override
	public Student updateStudent(Student student, Integer sid) throws Exception {

		Student existingStudent = studentRepository.findById(sid).orElseThrow(() ->
		new ResourceNotFound("student","sid",sid));
		
		


		existingStudent.setName(student.getName());
		existingStudent.setDob(student.getDob());
		existingStudent.setClassNo(student.getClassNo());

		studentRepository.save(existingStudent);

		return existingStudent;
	}

	//method to get student by id
	@Override
	public Optional<Student> getStudentById(Integer id) {

		return studentRepository.findById(id);
	}

	//method to get student by class
	@Override
	public List<Student> getStudentByClass(Integer classNo) {

		return studentRepository.findAll().stream().filter(cl -> cl.getClassNo() == classNo)
				.collect(Collectors.toList());

	}

}
