package com.example.gracegh.studentproject.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity//to map this class to the database...
@Data//to invoke the lombok dependency...
@AllArgsConstructor//to create a constructor with all the fields...
@NoArgsConstructor//to create a default constructor with no fields...
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
            strategy = GenerationType.AUTO
           /* generator = "student_sequence"*/
    )
    @Column(name = "id")//defining the column name...
    private Long studentId;

    @Column(name = "first_name")//defining the column name...
    private String firstName;

    @Column(name = "last_name")//defining the column name...
    private String lastName;

    @Column(
            name="email_address",
            nullable = false //making sure that this is never null in the table...
    )
    private String emailId;

    @Embedded
    private Guardian guardian;
}
