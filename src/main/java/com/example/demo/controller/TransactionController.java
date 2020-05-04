package com.example.demo.controller;

import com.example.demo.exception.NotHavingSufficentBalance;
import com.example.demo.model.Account;
import com.example.demo.model.Transaction_History;
import com.example.demo.repositories.AccountRepository;
import com.example.demo.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private AccountRepository accountRepository;

    @RequestMapping("/home")
    public ModelAndView home(
            @RequestParam String type,
            @RequestParam String amount,
            @RequestParam String comment,
            @RequestParam String user_id
    ) throws NotHavingSufficentBalance {

        Transaction_History th=new Transaction_History(
                     user_id,
                    Double.parseDouble(amount),
                    new Date(),
                    comment,
                    type
        );
        setBalanceOfUser(user_id, type, amount);
        transactionRepository.save(th);
        ModelAndView mv=new ModelAndView();
        mv.setViewName("success");
        return mv;
    }



    @RequestMapping("/history")
    public ModelAndView history(
            @RequestParam String user_id
    ){
        List<Transaction_History> th=transactionRepository.findAllByuserId(user_id);
        ModelAndView mv=new ModelAndView();
        mv.setViewName("Transaction_History");
        mv.addObject("data",th);
        return mv;
    }



    public void setBalanceOfUser(String user_id,String type,String balance) throws NotHavingSufficentBalance {
        double amount=Double.parseDouble(balance);
        Account account_of_user=accountRepository.findByUserId(user_id);
        System.out.println(account_of_user);
        if (type.equals("withdraw")){
            if ( account_of_user.getAmount() < amount){
                throw new NotHavingSufficentBalance("please enter the correct ammount");
            }else{
                account_of_user.setAmount(-amount);
            }
        }else{
            account_of_user.setAmount(amount);
        }
    }
}
