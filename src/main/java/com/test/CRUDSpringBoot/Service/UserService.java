package com.test.CRUDSpringBoot.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.CRUDSpringBoot.model.User;
import com.test.CRUDSpringBoot.repository.UserRepo;

@Service
public class UserService {
@Autowired
private UserRepo repo;

public List<User> getAllUsers() {
	// TODO Auto-generated method stub
	return repo.findAll();
}

public Optional<User> getUserById(Long id) {
	// TODO Auto-generated method stub
	return repo.findById(id);
}

public User createUser(User user) {
	// TODO Auto-generated method stub
	return repo.save(user);
}

public User updateUser(Long id, User userDetails) {
	// TODO Auto-generated method stub
	User existingUser=repo.findById(id).orElseThrow(()->new RuntimeException("User Not Found ID"+id));
	existingUser.setName(userDetails.getName());
	existingUser.setEmail(userDetails.getEmail());
	existingUser.setAge(userDetails.getAge());
	return repo.save(existingUser);	
}

public void deleteUser(Long id) {
	// TODO Auto-generated method stub
	repo.deleteById(id);
}
}
