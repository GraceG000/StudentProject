package com.example.gracegh.studentproject.Entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "Course")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Course {

    @Id
    @SequenceGenerator(
            name = "course_sequence",
            sequenceName = "course_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.AUTO,
            generator = "course_sequence"
    )// to make this an id...
    private Long courseId;
    private String title;
    private Integer credit;

    @OneToOne(
            mappedBy = "course" //you need a reference of courseMaterial in your course class to define a bidirectional one-to-one relationship...
    )
    private CourseMaterial courseMaterial;

    //depicting a many-to-one relationship...It's good to stick to many-to-one relationships...
    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "teacher_id",
            referencedColumnName = "teacherId"
    )
    private Teacher teacher;
}
