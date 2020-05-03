package com.example.demo.controller;

import com.example.demo.exception.LoginFailure;
import com.example.demo.exception.RegistrationFailure;
import com.example.demo.model.Account;
import com.example.demo.model.User;
import com.example.demo.repositories.AccountRepository;
import com.example.demo.repositories.UserRepository;
import com.example.demo.response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import java.util.Date;
import java.util.Optional;

@Controller
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
            @RequestParam String name
    ) throws RegistrationFailure {
       boolean isValid=checkIfValid(id, name);
       if (!isValid){
           throw new RegistrationFailure("please Dont enter the empty value");
       }
        Optional<User> u=userRepository.findById(id);
        if (u.isEmpty()){
            User user = new User(id, name, new Date());
            userRepository.save(user);
            Account ac=new Account(id);
            accountRepository.save(ac);
        }else{
            throw new RegistrationFailure("please enter new user id");
        }

        return true;

    }

    public boolean checkIfValid(String id,String name){
        if (name.isEmpty() || id.isEmpty()){
            return false;
        }
        return true;
    }

    @RequestMapping("/login")
    public ModelAndView login(
            @RequestParam String id
    ) throws LoginFailure {

        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()){
            throw new LoginFailure("please enter the correct id");
        }else{
            ModelAndView mv=new ModelAndView();
            Account account_of_user=accountRepository.findByUserId(id);
            mv.setViewName("Transaction_Type");
            mv.addObject("balance",account_of_user.getAmount());
            mv.addObject("user",user);
            return mv;
        }
    }
}
