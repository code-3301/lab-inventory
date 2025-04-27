package com.diu.labinventory.repositpry;

import com.diu.labinventory.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}