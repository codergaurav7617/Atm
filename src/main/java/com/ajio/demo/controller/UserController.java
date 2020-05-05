package com.ajio.demo.controller;
import com.ajio.demo.config.JwtUtil;
import com.ajio.demo.model.Account;
import com.ajio.demo.model.Response;
import com.ajio.demo.model.User;
import com.ajio.demo.repositories.UserRepository;
import com.ajio.demo.exception.RegistrationFailure;
import com.ajio.demo.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
    private JwtUtil jwtTokenUtil;

    @Autowired
    public AuthenticationManager authenticationManager;


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
    public ResponseEntity<?> login(
            @RequestParam String userId,
            @RequestParam String password
    ) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userId, password));

        }catch (BadCredentialsException e){
            throw new Exception("Incorrect UserName or password",e);
        }
        final User user=userRepository.findById(userId).get();
        final String jwt=jwtTokenUtil.generateToken(user);
        return ResponseEntity.ok(new Response(jwt));
    }
}
