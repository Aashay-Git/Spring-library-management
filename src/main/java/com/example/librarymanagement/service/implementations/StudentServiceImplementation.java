package com.example.librarymanagement.service.implementations;

import com.example.librarymanagement.dto.StudentDTO;
import com.example.librarymanagement.enums.Status;
import com.example.librarymanagement.model.Card;
import com.example.librarymanagement.model.Student;
import com.example.librarymanagement.repository.StudentRepository;
import com.example.librarymanagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class StudentServiceImplementation implements StudentService {
    @Autowired
    StudentRepository studentRepository;

    @Override
    public String addStudent(StudentDTO studentData) throws ParseException {
        Student student = new Student();
        student.setAge(studentData.getAge());
        student.setName(studentData.getName());
        student.setDept(studentData.getDept());
        student.setMobileNum(studentData.getMobileNum());
        Card card = new Card();
        card.setCardStatus(Status.ACTIVATED);
        SimpleDateFormat format = new SimpleDateFormat("YY-MM-DD");
        Date date = format.parse(String.valueOf(LocalDate.now().plusYears(4)));
        card.setExpiryDate(date);
        card.setStudent(student);
        student.setCard(card);
        studentRepository.save(student);

        return "Student Added Successfully";
    }

    @Override
    public Student findStudent(int id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student updateMobileNum(String mobileNum, int id) {
        Student stu = studentRepository.findById(id).get();
        stu.setMobileNum(mobileNum);
        studentRepository.save(stu);
        return stu;
    }
}
