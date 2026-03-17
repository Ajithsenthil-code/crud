package com.example.StudentCrud.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.StudentCrud.exception.StudentNotFoundException;
import com.example.StudentCrud.exception.ValidationException;

@Service
public class StudentService 
{

    private Map<Integer, Map<String, Object>> studentStore = new HashMap<>();
//    private Map<Integer, Map<String, Object>> studentStore = new HashMap<>();

    public String addStudent(Map<String, Object> student) {
        validateStudent(student);
        int id = (int) student.get("id");
        studentStore.put(id, student);
        return "Student added successfully";
    }

    public Collection<Map<String, Object>> getAllStudents() {
        return studentStore.values();
    }

    public Map<String, Object> getStudentById(int id) {
        Map<String, Object> student = studentStore.get(id);
        if (student == null) {
            throw new StudentNotFoundException("Student not found with id: " + id);
        }
        return student;
    }

    public String updateStudent(int id, Map<String, Object> student) {
        if (!studentStore.containsKey(id)) {
            throw new StudentNotFoundException("Student not found with id: " + id);
        }
        validateStudent(student);
        student.put("id", id);
        studentStore.put(id, student);
        return "Student updated successfully";
    }

    public String deleteStudent(int id) {
        if (studentStore.remove(id) == null) {
            throw new StudentNotFoundException("Student not found with id: " + id);
        }
        return "Student deleted successfully";
    }

    private void validateStudent(Map<String, Object> student) {
        if (!student.containsKey("id") ||
            !student.containsKey("name") ||
            !student.containsKey("age") ||
            !student.containsKey("course")) {
            throw new ValidationException("All fields (id, name, age, course) are required");
        }
    }
}
