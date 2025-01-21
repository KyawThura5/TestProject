package com.test.CRUDSpringBoot.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.CRUDSpringBoot.model.Courses;
import com.test.CRUDSpringBoot.repository.CourseRepo;

@Service
public class CourseService {
@Autowired
CourseRepo repo;

public List<Courses> getAllCourses() {
	// TODO Auto-generated method stub
	return repo.findAll();
}

public Optional<Courses> getCourseById(Long id) {
	// TODO Auto-generated method stub
	return repo.findById(id);
}

public Courses createCourse(Courses course) {
	// TODO Auto-generated method stub
	return repo.save(course);
}

public Courses updateCoursesById(Long id, Courses course) {
	Courses existCourse=repo.findById(id).orElseThrow(()->new RuntimeException("Course Not Found with ID "+id));
	existCourse.setCourseName(course.getCourseName());	
	existCourse.setStudents(course.getStudents());
	return repo.save(existCourse);
}

public void deleteCourseById(Long id) {
	// TODO Auto-generated method stub
	repo.deleteById(id);
}
}
