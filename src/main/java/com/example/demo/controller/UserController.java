package com.example.demo.controller;
import com.example.demo.model.User;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

   @RequestMapping(value = "/create-user")
   @ResponseBody
   public String createUser(User user){
       System.out.println(user);
       userRepository.save(user);
       return "Login.html";
   }

   @RequestMapping("/login")
   public void login(
       @RequestParam String id
   ){
       Optional<User> user=userRepository.findById(id);
       System.out.println(user);
   }
}
