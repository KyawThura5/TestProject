package com.test.CRUDSpringBoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.CRUDSpringBoot.model.Courses;

public interface CourseRepo extends JpaRepository<Courses,Long>{

}
