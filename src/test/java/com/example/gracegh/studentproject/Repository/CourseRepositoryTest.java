package com.example.gracegh.studentproject.Repository;

import com.example.gracegh.studentproject.Entity.Course;
import com.example.gracegh.studentproject.Entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void printCourses(){
        List<Course> courses = courseRepository.findAll();

        System.out.println("courses = " + courses);
    }


    @Test
    public void saveCourseWithTeacher(){

        //creating the teacher object...
        Teacher teacher = Teacher.builder()
                .firstName("Wanda")
                .lastName("Maximoff")
                .build();

       //creating the course object...
        Course course = Course.builder()
                .title("Python")
                .credit(9)
                .teacher(teacher)
                .build();

        courseRepository.save(course);
    }
}