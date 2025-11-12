package com.example.studentregistration.service;

import com.example.studentregistration.models.Student;
import com.example.studentregistration.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repo;

    public Student register(Student s) {
        s.setStatus("Pending");
        return repo.save(s);
    }

    public List<Student> getAll() {
        return repo.findAll();
    }

    public void approve(Long id) {
        Student s = repo.findById(id).orElseThrow();
        s.setStatus("Approved");
        repo.save(s);
    }

    public void reject(Long id) {
        Student s = repo.findById(id).orElseThrow();
        s.setStatus("Rejected");
        repo.save(s);
    }

    public Student login(String email, String password) {
        // ✅ simplified — no .filter() needed
        return repo.findByEmailAndPassword(email, password);
    }
}
