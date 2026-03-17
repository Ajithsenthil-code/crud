package com.example.StudentCrud.controller;

import java.util.Collection;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.StudentCrud.StudentCrudApplication;
import com.example.StudentCrud.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController 
{

        private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
        
    }

    @PostMapping
    public String addStudent(@RequestBody Map<String, Object> student) {
        return studentService.addStudent(student);
    }

    @GetMapping
    public Collection<Map<String, Object>> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public Map<String, Object> getStudentById(@PathVariable int id) {
        return studentService.getStudentById(id);
    }

    @PutMapping("/{id}")
    public String updateStudent(@PathVariable int id,@RequestBody Map<String, Object> student) {
        return studentService.updateStudent(id, student);
    }

    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable int id) {
        return studentService.deleteStudent(id);
    }
}
