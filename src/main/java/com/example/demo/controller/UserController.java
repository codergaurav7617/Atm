package com.example.demo.controller;
import com.example.demo.model.User;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Optional;

@RestController
@RequestMapping("/atm")
public class UserController {

    @Autowired
    private UserRepository userRepository;

   @RequestMapping(value = "/register")
   public RedirectView  register(User user){
       Optional<User> u1=userRepository.findById(user.getId());
       RedirectView redirectView = new RedirectView();
       if(u1.isEmpty()){
           userRepository.save(user);
           redirectView.setUrl("http://localhost:8080/Login.html");
           return redirectView;
       }else{
           redirectView.setUrl("http://localhost:8080/SignUp.html");
           return redirectView;
       }
   }

   @RequestMapping("/login")
   public RedirectView login(
       @RequestParam String id
   ){
       RedirectView redirectView = new RedirectView();
       Optional<User> user=userRepository.findById(id);
       if (user.isEmpty()){
           redirectView.setUrl("http://localhost:8080/SignUp.html");
           return redirectView;
       }else{
           redirectView.setUrl("http://localhost:8080/Transaction_Type.html");
           return redirectView;
       }
   }

}
