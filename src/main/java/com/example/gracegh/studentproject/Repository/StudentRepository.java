package com.example.gracegh.studentproject.Repository;

import com.example.gracegh.studentproject.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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

     //JPQL
     @Query("select s.firstName from Student s where s.emailId = ?1")
     String getStudentsFirstNameByEmailAddress(String emailId);

     //defining native queries...
     @Query(
             value = "select * from students s where s.email_address = ?1",
             nativeQuery = true
     )
     Student getStudentsByEmailAddressNative(String emailId);

     @Query(
             value = "select * from students s where s.email_address = :emailId",
             nativeQuery = true
     )
     Student getStudentsByEmailAddressNativeParam(@Param("emailId") String emailId);

     @Modifying//to make it a modifying query...
     @Transactional
     @Query(
             value = "update students set first_name = ?1 where email_address =?2",
             nativeQuery = true
     )
     int updateStudentNameByEmailId(String firstName, String emailId);
}
