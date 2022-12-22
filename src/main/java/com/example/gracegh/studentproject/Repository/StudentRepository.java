package com.example.gracegh.studentproject.Repository;

import com.example.gracegh.studentproject.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository//making this an actual repository...
public interface StudentRepository extends JpaRepository<Student, Long> {

     List<Student> findByFirstName(String firstName);

     List<Student> findByFirstNameContains(String name);

     List<Student> findByLastNameNotNull();

     List<Student> findByGuardianGuardianName(String guardianName);

     Student findByFirstNameAndLastName(String firstName, String lastName);

     //JPQL
     @Query("select s from Student s where s.emailId = ?1")
     Student getStudentsByEmailAddress(String emailId);

     @Query("select s.firstName from Student s where s.emailId = ?1")
     String getStudentsFirstNameByEmailAddress(String emailId);

}
