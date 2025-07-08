package com.pawan.SpringSecurity.service;

import com.pawan.SpringSecurity.model.Users;
import com.pawan.SpringSecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    AuthenticationManager authenticationManager;

    // strength-> number of hashes
    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

   public Users register (Users user){
       user.setPassword(encoder.encode(user.getPassword()));
      return userRepository.save(user);

   }

    public String verify(Users user) {
        Authentication authentication =
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                        user.getUsername(),user.getPassword()));
        if(authentication.isAuthenticated()) {
            return "Success!";
        }
        return "failure!";
    }
}
