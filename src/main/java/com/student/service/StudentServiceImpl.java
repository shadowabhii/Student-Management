package com.student.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.student.model.Student;
@Service
public class StudentServiceImpl implements IStudentService {
	
	@Autowired
	private IStudentRepository studentRepository;

	@Override
	public Integer saveStudent(Student student) {
		
		Student saveStudent =	studentRepository.save(student);
		
		return saveStudent.getSid();
	}

	@Override
	public List<Student> getAllStudent() {
		
		return studentRepository.findAll();
	}

	@Override
	public void deleteStudent(Integer sid) {
		
		studentRepository.deleteById(sid);
		
	}

	@Override
	public Student updateStudent(Student student, Integer sid) throws Exception {
		
		Student existingStudent = studentRepository.findById(sid).orElseThrow(
				()-> new Exception("Student not found"));
		
		existingStudent.setName(student.getName());
		existingStudent.setDob(student.getDob());
		existingStudent.setClassNo(student.getClassNo());
		
		studentRepository.save(existingStudent);
		
		return existingStudent;
	}

	@Override
	public Optional<Student> getStudentById(Integer id) {
		
		return studentRepository.findById(id);
	}

	@Override
	public List<Student> getStudentByClass( Integer classNo) {

		return studentRepository.findAll().stream().filter(cl -> cl.getClassNo() == classNo)
				.collect(Collectors.toList());// studentRepository.findAll(sort);
	}

	

}
