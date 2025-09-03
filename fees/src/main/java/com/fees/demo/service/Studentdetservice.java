package com.fees.demo.service;

import com.fees.demo.model.Studentdetailmodel;
import com.fees.demo.repository.Studentdetailrepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Studentdetservice {

    private final Studentdetailrepo studentRepo;

    public Studentdetservice(Studentdetailrepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    // Insert or update student
    public Studentdetailmodel saveStudent(Studentdetailmodel student) {
        // Only set status to PENDING if it’s a new student (status is null)
        if (student.getStatus() == null || student.getStatus().isEmpty()) {
            student.setStatus("PENDING");
        }
        return studentRepo.save(student);
    }

    // Get all students with PENDING status
    public List<Studentdetailmodel> getPendingStudents() {
        return studentRepo.findByStatus("PENDING");
    }
    public List<Studentdetailmodel> getApprovedStudents() {
        return studentRepo.findByStatus("APPROVED");
    }
    public List<Studentdetailmodel> getRejectedStudents() {
        return studentRepo.findByStatus("REJECTED");
    }

    // Get student by id
    public Optional<Studentdetailmodel> getStudentById(Long id) {
        return studentRepo.findById(id);
    }

    // Delete student
    

	

	
}
