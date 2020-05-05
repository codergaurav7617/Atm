package com.ajio.demo.controller;
import com.ajio.demo.model.Account;
import com.ajio.demo.model.User;
import com.ajio.demo.repositories.UserRepository;
import com.ajio.demo.exception.RegistrationFailure;
import com.ajio.demo.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Optional;

@RestController
@RequestMapping("/atm")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AccountRepository accountRepository;

    @RequestMapping("/register")
    @ResponseBody
    public boolean register(
            @RequestParam String id,
            @RequestParam String name,
            @RequestParam String password
    ) throws RegistrationFailure {
        System.out.println("A");
       boolean isValid=checkIfValid(id, name,password);
       if (!isValid){
           throw new RegistrationFailure("please Dont enter the empty value");
       }

        Optional<User> u=userRepository.findById(id);
        if (u.isEmpty()){
            User user = new User(id, name, new Date(),password);
            userRepository.save(user);
            Account ac=new Account(id);
            accountRepository.save(ac);
        }else{
            throw new RegistrationFailure("please enter new user id");
        }

        return true;
    }

    public boolean checkIfValid(String id,String name,String password){

        if (name.isEmpty() || id.isEmpty() || password.isEmpty()){
            return false;
        }

        return true;
    }

    @RequestMapping("/login")
    public void login(
            @RequestParam String userId,
            @RequestParam String password
    ) throws Exception {

    }
}
