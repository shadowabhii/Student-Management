package com.student.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.student.model.Student;
import com.student.service.IStudentService;

@RestController
public class StudentController {

	
	@Autowired
	private IStudentService studentService;
	
	@PostMapping("/student")
	Integer createStudent(@RequestBody Student student)
	{
		Integer id = studentService.saveStudent(student);
		System.out.println(id);
		
		return id;
		
	}
	
	@GetMapping("/student")
	public List<Student> getAllStudent()
	{
		return studentService.getAllStudent();
	}
	
	@DeleteMapping("/student/{sid}")
	public ResponseEntity<Student> deleteStudent(@PathVariable Integer sid)
	{

		
		System.out.println(sid);
		ResponseEntity<Student> responseEntity = new ResponseEntity<>(HttpStatus.OK);
		try 
		{
			studentService.deleteStudent(sid);
		}
		catch (Exception e) {
			e.printStackTrace();
		 responseEntity = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return responseEntity;
		
	
		
	}
	
	@PutMapping("/updateStudentById/{sid}")
	public ResponseEntity<Student> updateStudent(@PathVariable Integer sid , @RequestBody Student student ) throws Exception
	{
		return new ResponseEntity<Student>(studentService.updateStudent(student, sid),HttpStatus.OK);
		
	}
	
	@GetMapping("/getStudentbyid/{id}")
	public Optional<Student> getStudentById(@PathVariable Integer id)
	{
		
		Optional<Student> student = studentService.getStudentById(id);
		return student;
		
	}
	
	@GetMapping("/getStudentbyclass/{classNo}")
	public List<Student> getStudentByClass( @PathVariable Integer classNo )
	{
		
		List<Student> studentByClass = studentService.getStudentByClass(classNo);
		return studentByClass;
		
	}
	
	
}
