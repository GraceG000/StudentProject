package com.example.gracegh.studentproject.Repository;

import com.example.gracegh.studentproject.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository//making this an actual repository...
public interface StudentRepository extends JpaRepository<Student, Long> {
}
