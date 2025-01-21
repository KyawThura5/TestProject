package com.test.CRUDSpringBoot.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.CRUDSpringBoot.Service.CourseService;
import com.test.CRUDSpringBoot.model.Courses;

@RestController
@RequestMapping("api/courses")
public class CourseController {
@Autowired
CourseService service;
@GetMapping
public List<Courses> getAllCourses(){
	return service.getAllCourses();
}
@GetMapping("/{id}")
public ResponseEntity<Courses> getCourseById(@PathVariable Long id) {
	return service.getCourseById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	
}
@PostMapping
public Courses createCourses(@RequestBody Courses course) {
	return service.createCourse(course);
}
@PutMapping("/{id}")
public ResponseEntity<Courses> updateCoursesById(@PathVariable Long id , @RequestBody Courses course) {
	Courses updatedCourse=service.updateCoursesById(id,course);
	return ResponseEntity.ok(updatedCourse);
}
@DeleteMapping("/{id}")
public ResponseEntity<Void> deleteCourse(@PathVariable Long id){
	service.deleteCourseById(id);
	return ResponseEntity.noContent().build();	
}
}
