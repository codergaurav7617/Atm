package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Account {
    @Id
    private String account_id;

    private String user_id;

    private float amount;

    public String getAccount_id() {
        return account_id;
    }

    public void setAccount_id(String account_id) {
        this.account_id = account_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }
}
