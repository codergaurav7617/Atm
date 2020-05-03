package com.example.demo.repositories;

import com.example.demo.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,Integer> {
    Account findByUserId(String userId);
}
