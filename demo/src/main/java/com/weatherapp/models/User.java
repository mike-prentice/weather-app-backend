package com.weatherapp.models;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.mapping.PropertyGeneration;
import org.springframework.lang.NonNull;

import com.fasterxml.jackson.databind.annotation.JsonAppend.Prop;

import lombok.Data;

@Entity
@Table(name = "users")
@Data
public class User {
    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    
    
    @Column(name="username", unique = true)
    private String userName;

    
    @Column(name="email")
    private String email;

    
    @Column(name="password")
    private String password;

    

    

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

   

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    
}
