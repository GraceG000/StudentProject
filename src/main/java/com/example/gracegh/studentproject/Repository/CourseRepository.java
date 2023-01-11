package com.example.gracegh.studentproject.Repository;

import com.example.gracegh.studentproject.Entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {



}
