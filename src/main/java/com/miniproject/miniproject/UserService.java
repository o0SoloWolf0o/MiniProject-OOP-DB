package com.miniproject.miniproject;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;
	
	@Autowired RoleRepository roleRepo;
	
	@Autowired PasswordEncoder passwordEncoder;
	
	
	public List<User> listAll() {
		return userRepo.findAll();
	}

	public User get(Long id) {
		return userRepo.findById(id).get();
	}
	
	public List<Role> listRoles() {
		return roleRepo.findAll();
	}
	
	public void save(User user) {
		encodePassword(user);
		user.setEnabled(true);		
		userRepo.save(user);
	}
	
	private void encodePassword(User user) {
		String encodedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);		
	}

    public void registerDefaultUser(User user) {
        encodePassword(user);
        Role roleUser = roleRepo.findByName("User");
        user.addRole(roleUser);
        user.setEnabled(true);
        userRepo.save(user);
    }
}
