package com.test.CRUDSpringBoot.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.test.CRUDSpringBoot.model.Courses;
import com.test.CRUDSpringBoot.model.Students;
import com.test.CRUDSpringBoot.repository.CourseRepo;
import com.test.CRUDSpringBoot.repository.StudentRepo;

@Service
public class StudentService {
@Autowired
StudentRepo repo;
@Autowired
CourseRepo courserepo;

public List<Students> getAllStudents() {
	// TODO Auto-generated method stub
	return repo.findAll();
}

public Optional<Students> getStudentById(Long id) {
	// TODO Auto-generated method stub
	return repo.findById(id);
}

@Transactional
public Students createStudent(Students student) {
	// TODO Auto-generated method stub
	if(student.getCourses()!=null) {
		for(int i=0;i<student.getCourses().size();i++) {
			Long courseId=student.getCourses().get(i).getId();
			Optional<Courses> studentwithcourse=courserepo.findById(courseId);
			if(studentwithcourse.isPresent()) {
				student.getCourses().set(i, studentwithcourse.get());
			}else {
				throw  new RuntimeException("Couse not Found with ID "+studentwithcourse);
			}
		}
	}
	student.setRegisterAt(new Date());
	return repo.save(student);
}
@Transactional
public Students updateStudentById(Long id,Students students) {
	// TODO Auto-generated method stub
	Students existstudent=repo.findById(id).orElseThrow(()->new RuntimeException("Student Not Found with ID"+id));
	if(existstudent.getId()!=null) {
		existstudent.setName(students.getName());
		existstudent.setPhoneNumber(students.getPhoneNumber());
		existstudent.setRegisterAt(new Date());
		existstudent.setAge(students.getAge());
		existstudent.setEmail(students.getEmail());
		if(students.getCourses()!=null) {
			for(int i=0;i<students.getCourses().size();i++) {
				Long courseId=students.getCourses().get(i).getId();
				Optional<Courses> courses=courserepo.findById(courseId);
				if(courses.isPresent()) {
					existstudent.getCourses().set(i, courses.get());
				}
			}
		}
	}
	return repo.save(existstudent);
}

public void deleteById(Long id) {
	// TODO Auto-generated method stub
	repo.deleteById(id);
}
}
