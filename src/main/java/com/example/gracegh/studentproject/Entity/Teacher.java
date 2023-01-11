package com.example.gracegh.studentproject.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity//to map this class to a database...
@Data//to automate the process of creating getters and setters...
@AllArgsConstructor//to create a constructor with all the fields set...
@NoArgsConstructor//to create a constructor with no fields...
@Builder
public class Teacher {

    @Id
    @SequenceGenerator(
            name = "teacher_sequence",
            sequenceName = "teacher_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "teacher_sequence"
    )
    private Long teacherId;
    private String firstName;
    private String lastName;

/*    @OneToMany(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name ="teacher_id",
            referencedColumnName = "teacherId"
    )
    private List<Course> courses;*/
}
