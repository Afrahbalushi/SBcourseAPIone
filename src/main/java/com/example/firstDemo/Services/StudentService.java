package com.example.firstDemo.Services;


import com.example.firstDemo.Models.School;
import com.example.firstDemo.Models.Student;
import com.example.firstDemo.Repository.SchoolRepository;
import com.example.firstDemo.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    SchoolRepository schoolRepository;

    public void addStudent() {
        Student student = new Student();
        student.setName("Ali");
        student.setRollNumber("1");
        studentRepository.save(student);

    }

    public void deleteStudentById(Integer id){
        Student studentToDelete = (Student) studentRepository.findById(id).get(0);
        studentRepository.delete(studentToDelete);
    }

    public List<Student> getStudentsBySchoolName(String schoolName){
        School school = schoolRepository.getBySchoolName(schoolName);
        Integer schoolId = school.getId();
        List<Student> studentList = studentRepository.getStudentsBySchoolId(schoolId);
        return studentList;
    }

    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

}
