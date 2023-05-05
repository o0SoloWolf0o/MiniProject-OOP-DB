package com.miniproject.miniproject;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
// import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserRepositoryTest {

	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private RoleRepository roleRepo;
	
	// @Autowired
	// private TestEntityManager entityManager;

	// @Test
	// public void testCreateUser() {
	// 	User user = new User();
	// 	user.setEmail("porpumipat@gmail.com");
	// 	user.setPassword("asdasd");
	// 	user.setFirstname("Pumipat");
	// 	user.setLastname("Korncharornpisuit");
		
	// 	User savedUser = userRepo.save(user);
		
	// 	User existUser = entityManager.find(User.class, savedUser.getId());
		
	// 	assertThat(user.getEmail()).isEqualTo(existUser.getEmail());

	// }

	// @Test
	// public void testAddRoleToNewUser() {
	// 	User user = new User();
	// 	user.setEmail("p.kornpisuit@gmail.com");
	// 	user.setPassword("asdasd");
	// 	user.setFirstname("Pumipat");
	// 	user.setLastname("Korncharornpisuit");
	// 	user.setTelphone("012-345-6789");

	// 	BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	// 	String plainPassword = "asdasd";
	// 	String encodedPassword = passwordEncoder.encode(plainPassword);
	// 	user.setPassword(encodedPassword);
		
	// 	Role roleuser = roleRepo.findByName("User");
	// 	user.addRole(roleuser);

	// 	Role roleadmin = roleRepo.findByName("Admin");
	// 	user.addRole(roleadmin);

	// 	User savedUser = userRepo.save(user);

	// 	user.setEnabled(true);
		
	// 	assertThat(savedUser.getRoles().size()).isEqualTo(2);

	// }

	// @Test
	// public void testFindByEmail() {
	// 	String email = "p.kornpisuit@gmail.com";
	// 	User user = userRepo.findByEmail(email);
		
	// 	assertThat(user.getEmail()).isEqualTo(email);
	// }
}
