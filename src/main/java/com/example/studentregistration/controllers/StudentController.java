package com.example.studentregistration.controllers;

import com.example.studentregistration.models.Student;
import com.example.studentregistration.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    // Show register page (GET)
    @GetMapping("/register")
    public String showRegisterPage() {
        return "Register";
    }

    // Handle form submission (POST)
    @PostMapping("/register")
    public String registerStudent(@ModelAttribute Student student) {
        studentRepository.save(student);
        return "redirect:/login"; // after registration, go back to login page
    }
}
