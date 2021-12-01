package com.nwmsu.laurelreview.controller;

import java.util.List;
import com.nwmsu.laurelreview.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nwmsu.laurelreview.repo.UserRepo;

@CrossOrigin(origins = {"http://localhost:3000","http://localhost:3001"})
@RestController
public class ApiControllers {
	@Autowired
	private UserRepo userRepo;
	
	@GetMapping(value = "/")
	public String getPage() {
		return "Welcome";
	}
	@GetMapping(value="/users")
	public List<User> getUsers() {
		return userRepo.findAll();
	}
	@PostMapping(value="/save")
	public String saveUser(@RequestBody User user) {
		userRepo.save(user);
		return "saved..";
	}
	
	@GetMapping(value = "/users/{id}")
	public User getUser(@PathVariable long id) {
//		System.out.print("user get");
		return userRepo.findById(id).get();
	}
	
	@GetMapping(value="/users/email/{email}")
	public User getUser(@PathVariable String email) {
		List<User> users = userRepo.findAll();
		User user = null;
		for (User userVar : users) {
			if (userVar.getEmail().equals(email)) {
				return userVar;
			}
		}
		return user;
	}
	
	@PutMapping(value="/update/{id}")
	public String updateUser(@PathVariable long id, @RequestBody User user) {
		User updatedUser = userRepo.findById(id).get();
		updatedUser.setFirstName(user.getFirstName());
		updatedUser.setLastName(user.getLastName());
		updatedUser.setActive(user.isActive());
		updatedUser.setAddress(user.getAddress());
		updatedUser.setEmail(user.getEmail());
		updatedUser.setGender(user.getGender());
		updatedUser.setPassword(user.getPassword());
		updatedUser.setPhoneNo(user.getPhoneNo());
		updatedUser.setRole(user.getRole());
		userRepo.save(updatedUser);
		return "updated...";
	}
	
	@DeleteMapping(value="/delete/{id}")
	public String deleteUser(@PathVariable long id) {
		userRepo.deleteById(id);
		return "Deleted";
	}
	
}
