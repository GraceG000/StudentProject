package com.example.gracegh.studentproject.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity//to map this class to the database...
@Data//to invoke the lombok dependency...
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(
        name="students" //defining the name of the table...
)

public class Student {

    @Id//to make the studentId a primary key...
    @SequenceGenerator(
            name = "students_sequence",
            sequenceName = "students_sequence",
            allocationSize = 1
    )
    //generating the values for the student ids...
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    @Column(name = "id")
    private Long studentId;

    @Column(name = "first_name")//defining the column name...
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(
            name="email_address",
            nullable = false //making sure that this is never null in the table
    )
    private String emailId;

    @Column(name="guardian_name")
    private String guardianName;

    @Column(name="guardian_email_address")
    private String guardianEmail;

    @Column(name="guardian_mobile_number")
    private String guardianMobile;
}
