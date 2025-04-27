package com.diu.labinventory.service;

import com.diu.labinventory.model.Student;
import com.diu.labinventory.repositpry.BorrowRecordRepository;
import com.diu.labinventory.repositpry.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private BorrowRecordRepository borrowRecordRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public void saveStudent(Student student) {
        studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
        if (!borrowRecordRepository.findByStudentId(id).isEmpty()) {
            throw new IllegalStateException("Cannot delete student because they have active borrow records.");
        }
        studentRepository.deleteById(id);
    }
}