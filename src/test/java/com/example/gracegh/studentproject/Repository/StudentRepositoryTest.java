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
                .emailId("AnnabethBryer34@gmail.com")
                .firstName("Annabeth")
                .lastName("Bryer")
                .build();

        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardian(){

        Guardian guardian = Guardian.builder()
                .guardianName("Hatake Kakashi")
                .guardianEmail("HatakeKak88@gmail.com")
                .guardianMobile("0513785503")
                .build();

        Student student = Student.builder()
                .studentId(2L)
                .emailId("SasuSaku@gmail.com")
                .firstName("Sasuke")
                .lastName("Uchiha")
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

    @Test
    public void printGetStudentFirstNameByEmailAddress(){
        String firstName = studentRepository.getStudentsFirstNameByEmailAddress("shabbir@gmail.com");

        System.out.println("firstName = " + firstName);
    }

    @Test
    public void printStudentByEmailAddressNative(){
        Student student = studentRepository.getStudentsByEmailAddressNative("percyja37@gmail.com");

        System.out.println("students = " + student);
    }

    @Test
    public void printGetStudentByEmailAddressNativeNamedParam(){
        Student student = studentRepository.getStudentsByEmailAddressNativeParam("percyja37@gmail.com");

        System.out.println("students = " + student);
    }

    @Test
    public void updateStudentNameByEmailId(){
         studentRepository.updateStudentNameByEmailId("Percius", "percyja37@gmail.com");
    }
}