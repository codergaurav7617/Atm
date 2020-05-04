package com.ajio.demo.controller;
import com.ajio.demo.config.JwtTokenUtil;
import com.ajio.demo.exception.LoginFailure;
import com.ajio.demo.model.Account;
import com.ajio.demo.model.User;
import com.ajio.demo.repositories.UserRepository;
import com.ajio.demo.exception.RegistrationFailure;
import com.ajio.demo.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
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

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    public AuthenticationManager manager;


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
    public ResponseEntity<?> login(
            @RequestBody User user
    ) throws LoginFailure {
        try {

        }
    }
}
