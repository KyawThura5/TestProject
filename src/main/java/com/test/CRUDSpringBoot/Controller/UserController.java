package com.test.CRUDSpringBoot.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.CRUDSpringBoot.Service.UserService;
import com.test.CRUDSpringBoot.model.User;

@RestController
@RequestMapping("/api/users")
public class UserController {
	@Autowired
	private UserService service;
	@Autowired
	private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody User user){
		Optional<User> userOptional=service.getUserById(user.getId());
		if(userOptional.isPresent()) {
			User existuser=userOptional.get();
			if(passwordEncoder.matches(user.getPassword(), existuser.getPassword())) {
				return ResponseEntity.ok("Login successful");
			}
			else {
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentils");
			}
		}else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentils");
		}	
	}
	
	@GetMapping
	public List<User> getAllUsers(){
	return service.getAllUsers();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<User> getUserById(@PathVariable Long id) {
	 return service.getUserById(id)
			 .map(ResponseEntity::ok)
			 .orElse(ResponseEntity.notFound().build());	
	}
	
	@PostMapping("/register")
	public ResponseEntity<?> createUser(@RequestBody User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		 service.createUser(user);
		 return ResponseEntity.ok("User registered successfully!");
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<User> updateUser(@PathVariable Long id,@RequestBody User user){
		User updateuser=service.updateUser(id,user);
		return ResponseEntity.ok(updateuser);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
		service.deleteUser(id);
		return ResponseEntity.noContent().build();
	}
}
