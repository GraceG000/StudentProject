package com.example.gracegh.studentproject.Repository;

import com.example.gracegh.studentproject.Entity.CourseMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseMaterialRepository extends JpaRepository<CourseMaterial, Long> {



}
