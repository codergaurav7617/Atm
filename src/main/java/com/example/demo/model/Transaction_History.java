package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;
@Entity
public class Transaction_History {
   @Id
   private int txn_id;

   private String user_id;

   private float amount;

   private Date time_stamp;

   private String txn_type;

    public int getTxn_id() {
        return txn_id;
    }

    public void setTxn_id(int txn_id) {
        this.txn_id = txn_id;
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

    public Date getTime_stamp() {
        return time_stamp;
    }

    public void setTime_stamp(Date time_stamp) {
        this.time_stamp = time_stamp;
    }

    public String getTxn_type() {
        return txn_type;
    }

    public void setTxn_type(String txn_type) {
        this.txn_type = txn_type;
    }
}
