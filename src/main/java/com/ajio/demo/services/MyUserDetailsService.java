package com.ajio.demo.services;

import com.ajio.demo.model.User;
import com.ajio.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {
  @Autowired
  private UserRepository userRepository;
    @Override
    public User loadUserByUsername(String s) throws UsernameNotFoundException {
         System.out.println("Gaurav");
         User user=userRepository.findById(s).get();
        System.out.println(user);
         return user;
    }
}
