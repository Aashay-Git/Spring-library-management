package com.example.librarymanagement.controller;


import com.example.librarymanagement.dto.StudentDTO;
import com.example.librarymanagement.model.Student;
import com.example.librarymanagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @PostMapping("/addStudent")
    public String addStudent(@RequestBody StudentDTO studentDTO){
        try {
            System.out.println("test print");
            System.out.println(studentDTO.toString());
            return studentService.addStudent(studentDTO);
//            return true;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/findStudent/{id}")
    public Student findStudent(@PathVariable int id){
        try {
            return studentService.findStudent(id);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/findAllStudents")
    public List<Student> findStudent(){
        try {
            return studentService.findAll();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @PostMapping("/updateNum/{id}")
    public Student updateNum(@RequestBody String mobileNum, @PathVariable int id){
        try{
            return studentService.updateMobileNum(mobileNum, id);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @DeleteMapping("/deleteStudent/{id}")
    public String deleteStudent(@PathVariable int id){
        try{
            return studentService.deleteStudent(id);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
