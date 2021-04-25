package com.asish.springsecurity.controller;

import com.asish.springsecurity.data.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("student")
public class StudentController {
    private static final List<Student> STUDENTS = Arrays.asList(new Student("1", "test1"),
            new Student("2","test2"),
            new Student("3", "test3"));

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable("id") String id) {
        return STUDENTS.stream()
                .filter(student -> id.equals(student.getId()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("no id not exists"+id));

    }
}
