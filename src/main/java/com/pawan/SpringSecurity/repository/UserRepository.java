package com.pawan.SpringSecurity.repository;

import com.pawan.SpringSecurity.model.Users;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users,Integer> {
    Users findByUsername(String username);
}
