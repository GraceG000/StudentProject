package com.example.gracegh.studentproject.Repository;

import com.example.gracegh.studentproject.Entity.Guardian;
import com.example.gracegh.studentproject.Entity.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent(){
        Student student = Student.builder()
                .studentId(1L)
                .emailId("shabbir@gmail.com")
                .firstName("Shabbir")
                .lastName("Dawoodi")
                .build();

        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardian(){

        Guardian guardian = Guardian.builder()
                .guardianName("Bernard Tustel")
                .guardianEmail("BernardoTu@gmail.com")
                .guardianMobile("1234567891")
                .build();

        Student student = Student.builder()
                .studentId(2L)
                .emailId("percyja37@gmail.com")
                .firstName("Percy")
                .lastName("Jackson")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }

    @Test
    public void  printAllStudents(){
        List<Student> studentList = studentRepository.findAll();

        System.out.println("studentList = " + studentList);
    }

    @Test
    public void printStudentByFirstName(){
        List<Student> students = studentRepository.findByFirstName("Shivam");

        System.out.println("students = " + students);
    }

    @Test
    public void printStudentByFirstNameContains(){
        List<Student> students = studentRepository.findByFirstNameContains("P");

        System.out.println("students = " + students);
    }

    @Test
    public void printStudentBasedOnGuardianName(){
        List<Student> students = studentRepository.findByGuardianGuardianName("Bernard");

        System.out.println("students = " + students);
    }

    @Test
    public void printGetStudentByEmailAddress(){
        Student student = studentRepository.getStudentsByEmailAddress("shabbir@gmail.com");

        System.out.println("students = " + student);
    }
}