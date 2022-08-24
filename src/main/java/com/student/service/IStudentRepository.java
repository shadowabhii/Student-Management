package com.student.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.student.model.Student;

public interface IStudentRepository extends JpaRepository<Student, Integer> {

}
