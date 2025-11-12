package com.example.studentregistration.repositories;

import com.example.studentregistration.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    Student findByEmail(String email);
    Student findByEmailAndPassword(String email, String password); // ✅ add this
}
