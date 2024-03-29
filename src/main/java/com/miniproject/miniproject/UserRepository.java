package com.miniproject.miniproject;

import org.springframework.data.jpa.repository.*;
// import org.springframework.data.repository.CrudRepository;
// import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u WHERE u.email = ?1")
    public User findByEmail(String email);

    // @Query("SELECT u FROM User u WHERE u.email = :email")
    // public User getUserByEmail(@Param("email") String email);

}