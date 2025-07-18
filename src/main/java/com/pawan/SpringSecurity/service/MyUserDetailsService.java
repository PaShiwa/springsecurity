package com.pawan.SpringSecurity.service;

import com.pawan.SpringSecurity.model.UserPrincipal;
import com.pawan.SpringSecurity.model.Users;
import com.pawan.SpringSecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = userRepository.findByUsername(username);

        if(user==null){
            System.out.println("User not found!");
            throw new UsernameNotFoundException("No user found!");
        }
        return new UserPrincipal(user);
    }
}
