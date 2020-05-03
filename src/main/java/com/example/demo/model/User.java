package com.example.demo.model;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Entity
public class User {
    @Id
     private String id;
     @NotEmpty
    private String name;

    private Date created_date;

    public User(){}

    public User(String id,String name,Date created_date){
        this.id=id;
        this.name=name;
        this.created_date=created_date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreated_date() {
        return created_date;
    }

    public void setCreated_date(Date created_date) {
        this.created_date = created_date;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", created_date=" + created_date +
                '}';
    }
}
