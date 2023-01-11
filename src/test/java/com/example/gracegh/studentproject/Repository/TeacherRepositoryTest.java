package com.example.gracegh.studentproject.Repository;

import com.example.gracegh.studentproject.Entity.Course;
import com.example.gracegh.studentproject.Entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacher(){

        //this teacher teaches two courses...

        Course courseDBA = Course.builder()
                .title("DBA")
                .credit(5)
                .build();

        Course courseJava = Course.builder()
                .title("Java")
                .credit(6)
                .build();

        //List.of(courseDBA...): this is because one teacher is teaching more than one course...
        Teacher teacher =
                Teacher.builder()
                        .firstName("Khotal")
                        .lastName("Khan")
                      //  .courses(List.of(courseDBA, courseJava))
                        .build();

                        teacherRepository.save(teacher);
    }
}