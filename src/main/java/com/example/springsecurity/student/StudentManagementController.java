package com.example.springsecurity.student;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("management/api/v1/students")
public class StudentManagementController {

    private static final List<Student> STUDENTS= Arrays.asList(
            new Student(1,"Lakisha"),
            new Student(2,"Zorz"),
            new Student(3,"Ana Smith")
    );

    // hasRole("ROLE_") hasAnyRole("ROLE_") hasAuthority("permision") hasAnyAuthority("permision")
    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_ADMINTRAINEE')")
    public List<Student> getAllStudents() {
        return STUDENTS;
    }

    @PostMapping
    @PreAuthorize("hasAuthority('student:write')")
    public void registerNewStudent(@RequestBody Student student){
        System.out.println(student);
    }

    @PreAuthorize("hasAuthority('student:write')")
    @DeleteMapping("{studentId}")
    public void deleteStudent(@PathVariable Integer studentId){
        System.out.println(studentId);
    }

    @PutMapping("{id}")
    @PreAuthorize("hasAuthority('student:write')")
    public void updateStudent(@PathVariable Integer id,@RequestBody Student student){
        System.out.println(id+" "+student);
    }
}