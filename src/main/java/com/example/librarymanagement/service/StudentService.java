package com.example.librarymanagement.service;

import com.example.librarymanagement.dto.StudentDTO;
import com.example.librarymanagement.model.Student;

import java.text.ParseException;
import java.util.List;

public interface StudentService {
    public String addStudent(StudentDTO studentDTO) throws ParseException;
    Student findStudent(int id);
    List<Student> findAll();
    Student updateMobileNum(String mobileNum, int id);
}
