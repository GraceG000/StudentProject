package com.example.gracegh.studentproject.Repository;

import com.example.gracegh.studentproject.Entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}
