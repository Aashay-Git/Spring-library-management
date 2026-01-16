package com.example.librarymanagement.model;

import com.example.librarymanagement.enums.Department;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int stdid;

    private String name;

    private int age;

    @Enumerated(EnumType.STRING)
    private Department dept;

    private String mobileNum;

    @JsonIgnore
    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL)
    Card card;

//    public int getStdid() {
//        return stdid;
//    }
//
//    public void setStdid(int stdid) {
//        this.stdid = stdid;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Department getDept() {
        return dept;
    }

    public void setDept(Department dept) {
        this.dept = dept;
    }

    public String getMobileNum() {
        return mobileNum;
    }

    public void setMobileNum(String mobileNum) {
        this.mobileNum = mobileNum;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public Student() {
    }

    public Student(int stdid, String name, int age, Department dept, String mobileNum, Card card) {
        this.stdid = stdid;
        this.name = name;
        this.age = age;
        this.dept = dept;
        this.mobileNum = mobileNum;
        this.card = card;
    }

    @Override
    public String toString() {
        return "Student{" +
                "stdid=" + stdid +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", dept=" + dept +
                ", mobileNum='" + mobileNum + '\'' +
                ", card=" + card +
                '}';
    }
}
