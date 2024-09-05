package com.sakshi.springboot._rest._api.controller;

import com.sakshi.springboot._rest._api.entity.Student;
import com.sakshi.springboot._rest._api.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    StudentRepository studentRepository;

    // get all the students
    @GetMapping("/students")
    public List<Student>getALLStudents() {
        List<Student> students=studentRepository.findAll();
        return students;

    }

    // get students by id
    @GetMapping("/students/{id}")
    public Student getStudent(@PathVariable int id) {
       Student student = studentRepository.findById(id).get();
        return student;
    }

   // add the students
    @PostMapping("/student/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void createStudent(@RequestBody Student student) {
        studentRepository.save(student);

    }

    // update the students
    @PutMapping("/student/update/{id}")
    public Student updateStudents(@PathVariable int id) {
       Student student =  studentRepository.findById(id).get();
        student.setName("Rutuja");
        student.setPercentage(92);
        studentRepository.save(student);
        return student;

    }

    // delete the students
    @DeleteMapping("/students/delete/{id}")
    public void removeStudent(@PathVariable int id) {
       Student student = studentRepository.findById(id).get();
        studentRepository.delete(student);
    }


}
