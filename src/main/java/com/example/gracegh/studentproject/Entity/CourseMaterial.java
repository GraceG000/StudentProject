package com.example.gracegh.studentproject.Entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "CourseMaterial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(exclude = "course")
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
//when you want to fetch data, there are two ways to do it...Eager fetching and lazy fetching...
//with eager fetching, when we are fetching courseMaterial data, the course data will also be fetched. Lazy fetching is the opposite of eager fetching...
    @OneToOne(
            //implementing cascading...
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, //here we are implementing lazy fetching...
            optional = false
    )
    @JoinColumn(
            name ="course_id",
            referencedColumnName = "courseId"
    )//where the foreign key is...
    private Course course;

}
