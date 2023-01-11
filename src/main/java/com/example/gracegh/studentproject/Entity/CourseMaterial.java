package com.example.gracegh.studentproject.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "CourseMaterial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CourseMaterial {

    @Id
    @SequenceGenerator(
            name = "course_material_sequence",
            sequenceName = "course_material_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.AUTO,
            generator = "course_material_sequence"
    )
    private Long courseMaterialId;
    private String url;

    @OneToOne(

            //implementing cascading...
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name ="course_id",
            referencedColumnName = "courseId"
    )//where the foreign key is...
    private Course course;

}
