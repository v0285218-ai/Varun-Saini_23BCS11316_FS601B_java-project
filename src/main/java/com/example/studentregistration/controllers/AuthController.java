package com.example.studentregistration.controllers;

import com.example.studentregistration.models.Student;
import com.example.studentregistration.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthController {

    @Autowired
    private StudentService service;

    // 🟩 This handles GET /login to show the page
    @GetMapping("/login")
    public String showLoginPage() {
        return "login"; // renders login.html
    }

    // 🟩 This handles POST /login when form is submitted
    @PostMapping("/login")
    public String login(@RequestParam String email,
                        @RequestParam String password,
                        Model model) {

        Student student = service.login(email, password);

        if (student != null) {
            // 🧠 if the user is admin, show admin dashboard
            if (student.getEmail().equalsIgnoreCase("admin@example.com")) {
                model.addAttribute("students", service.getAll());
                return "adminDashboard";
            }
            // 🧠 if normal student, show student dashboard
            model.addAttribute("student", student);
            return "studentDashboard";
        } else {
            model.addAttribute("error", "Invalid email or password!");
            return "login";
        }
    }
}
