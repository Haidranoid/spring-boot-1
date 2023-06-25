package com.example.demo.controllers;

import com.example.demo.entity.Student;
import com.example.demo.entity.errors.StudentErrorResponse;
import com.example.demo.entity.exceptions.StudentNotFoundException;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    private List<Student> students;

    // define @PostConstruct to load student data ... only once!
    @PostConstruct
    private void loadData() {
        students = new ArrayList<>();

        this.students.add(new Student("Poornima", "Patel"));
        this.students.add(new Student("Mario", "Rossi"));
        this.students.add(new Student("Mary", "Smith"));
    }

    // define endpoint for "/students" - return a list of students
    @GetMapping("/students")
    public List<Student> getStudents() {
        return this.students;
    }

    // define endpoint for "/students" - return a list of students

    @GetMapping("/students/{id}")
    public Student getStudent(@PathVariable int id) {
        //check the studentId again list size
        if ((id >= students.size() || (id < 0))) {
            throw new StudentNotFoundException("Student id not found - " + id);
        }

        // just index into the list .... keep it simple for now
        return this.students.get(id);
    }
}
