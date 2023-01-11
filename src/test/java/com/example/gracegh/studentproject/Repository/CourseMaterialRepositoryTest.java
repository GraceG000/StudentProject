package com.example.gracegh.studentproject.Repository;

import com.example.gracegh.studentproject.Entity.Course;
import com.example.gracegh.studentproject.Entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest //to make it a test class...
class CourseMaterialRepositoryTest {

    @Autowired
    private CourseMaterialRepository repository;

    //saving the course material with the course...
    @Test
    public void SaveCourseMaterial(){

        Course course = Course.builder()
                .title(".net")
                .credit(2)
                .build();

        CourseMaterial courseMaterial = CourseMaterial.builder()
                .url("www.networking101.com")
                .course(course)// I passed the course object created above as a parameter for this...
                .build();
//cascading: to pass the properties from the parent element to the child element...this is the solution to the problem of binding course to the courseMaterial to save it...
        repository.save(courseMaterial);
    }

    @Test
    public void printAllCourseMaterials(){
        List<CourseMaterial> courseMaterials = repository.findAll();

        System.out.println("courseMaterials = " + courseMaterials);
    }

}