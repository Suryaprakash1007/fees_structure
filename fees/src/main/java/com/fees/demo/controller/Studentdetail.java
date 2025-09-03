package com.fees.demo.controller;

import com.fees.demo.model.Studentdetailmodel;
import com.fees.demo.service.Studentdetservice;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
@CrossOrigin(origins = "*")
public class Studentdetail {

    private final Studentdetservice studentService;

    public Studentdetail(Studentdetservice studentService) {
        this.studentService = studentService;
    }
    
    @PutMapping("/{id}/status")
    public ResponseEntity<Studentdetailmodel> updateStatus(@PathVariable Long id, @RequestParam String status) {
        Studentdetailmodel student = studentService.getStudentById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        student.setStatus(status.toUpperCase());
        Studentdetailmodel updated = studentService.saveStudent(student);

        return ResponseEntity.ok(updated);
    }

    // ✅ Insert student
    @PostMapping("/ins")
    public ResponseEntity<Studentdetailmodel> createStudent(@RequestBody Studentdetailmodel student) {
        Studentdetailmodel saved = studentService.saveStudent(student);
        return ResponseEntity.ok(saved);
    }

    // ✅ Get all students
    @GetMapping("/pending")
    public List<Studentdetailmodel> getPendingStudents() {
        return studentService.getPendingStudents();
    }
    @GetMapping("/approved")
    public List<Studentdetailmodel> getApprovedStudents() {
        return studentService.getApprovedStudents();
    }
    @GetMapping("/rejected")
    public List<Studentdetailmodel> getRejectedStudents() {
        return studentService.getRejectedStudents();
    }

    // ✅ Get student by ID
    @GetMapping("/{id}")
    public ResponseEntity<Studentdetailmodel> getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    
}
