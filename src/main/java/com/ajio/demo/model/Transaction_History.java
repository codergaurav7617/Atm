package com.ajio.demo.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
@Entity
public class Transaction_History {
   @Id
   @GeneratedValue
   private int txn_id;

   private String userId;

   private double amount;

   private Date time_stamp;

    private String comment;

   private String txn_type;

   public Transaction_History(){}

   public Transaction_History(String user_id,double amount,Date time_stamp,String comment,String txn_type){
       this.userId=user_id;
       this.amount=amount;
       this.time_stamp=time_stamp;
       this.txn_type=txn_type;
       this.comment=comment;
   }

    public int getTxn_id() {
        return txn_id;
    }

    public void setTxn_id(int txn_id) {
        this.txn_id = txn_id;
    }

    public String getUser_id() {
        return userId;
    }

    public void setUser_id(String user_id) {
        this.userId = user_id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
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


    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }


    @Override
    public String toString() {
        return "Transaction_History{" +
                "txn_id=" + txn_id +
                ", user_id='" + userId + '\'' +
                ", amount=" + amount +
                ", time_stamp=" + time_stamp +
                ", txn_type='" + txn_type + '\'' +
                '}';
    }
}
