package com.nwmsu.laurelreview.controller;

import com.nwmsu.laurelreview.model.User;
import com.nwmsu.laurelreview.repo.UserRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Iterator;
import java.util.List;

@CrossOrigin(origins = {"http://localhost:3000","http://localhost:3001"})
@RestController
@RequestMapping("api")
public class UserController {
    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserController(final UserRepo userRepo,
                          final PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping(value = "/")
    public String getPage() {
        return "Welcome";
    }

    @GetMapping(value = "/users")
    public List<User> getUsers() {
        return userRepo.findAll();
    }

    @PostMapping(value = "/save")
    public String saveUser(@RequestBody User user) {
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        userRepo.save(user);
        return "saved..";
    }
    
    @PostMapping(value = "/login")
    public String loginUser(@RequestBody User user) {
//        String encodedPassword = passwordEncoder.encode(user.getPassword());
        List<User> users = userRepo.findAll();
        for(User u:users) {
        	if(u.getEmail().equals(user.getEmail())) {        		
        		if(passwordEncoder.matches(user.getPassword(),u.getPassword())) {
            		return "Login Success";        			
        		}
			}
        }        		        	
        return "Login Failed";
    }

    @GetMapping(value = "/users/{id}")
    public User getUser(@PathVariable long id) {
        return userRepo.findById(id).orElse(null);
    }

    @GetMapping(value = "/users/email/{email}")
    public User getUser(@PathVariable String email) {
        List<User> users = userRepo.findAll();
        return users.stream()
                .filter(
                        user -> user.getEmail().equals(email))
                .findFirst()
                .orElse(null);
    }

    @PutMapping(value = "/update/{id}")
    public String updateUser(@PathVariable long id, @RequestBody User user) {
        User updatedUser = userRepo.findById(id).orElse(null);
        if (updatedUser == null) {
            return "User with ID " + id + " not exist";
        }
        user.setId(id);
        BeanUtils.copyProperties(user, updatedUser);
        this.saveUser(updatedUser);
        return "updated...";
    }

    @DeleteMapping(value = "/delete/{id}")
    public String deleteUser(@PathVariable long id) {
        userRepo.deleteById(id);
        return "Deleted";
    }
    
}
