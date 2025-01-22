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

import com.test.CRUDSpringBoot.Service.StudentService;
import com.test.CRUDSpringBoot.model.Students;

@RestController
@RequestMapping("api/students")
public class StudentController {
@Autowired
StudentService service;
@GetMapping
public List<Students> getAllStudent(){
	return service.getAllStudents();
}
@GetMapping("/{id}")
public ResponseEntity<Students> getStudentById(@PathVariable Long id){
	return service.getStudentById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());	
}
@PostMapping
public Students createStudent(@RequestBody Students student){
	return service.createStudent(student);
}
@PutMapping("/{id}")
public ResponseEntity<Students> updateStudentById(@PathVariable Long id,@RequestBody Students student){
	Students updatedstudent=service.updateStudentById(id,student);
	return ResponseEntity.ok(updatedstudent);
	
}
@DeleteMapping("/{id}")
public ResponseEntity<Void> deleteStudentById(@PathVariable Long id){
	service.deleteById(id);
	return ResponseEntity.noContent().build();
}

/*@DeleteMapping("/{id}")
public ResponseEntity<Void> deleteStudentById(@PathVariable Long id){
	service.deleteById(id);
	return ResponseEntity.noContent().build();
}*/

}

