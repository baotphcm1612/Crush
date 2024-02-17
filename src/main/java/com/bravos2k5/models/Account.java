package com.bravos2k5.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Account {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Getter
    @Setter
    @Column(nullable = false, unique = true, updatable = false)
    private String username;

    @Getter
    @Setter
    @Column(nullable = false)
    private String password;

    @Getter
    @Setter
    @Column(unique = true)
    private String email;

    @Getter
    @Setter
    @Column(unique = true)
    private String phone;

    @Getter
    @Setter
    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL, targetEntity = User.class)
    private List<User> personList = new ArrayList<>();

    private Boolean isBan;

    public void setBan(Boolean isBan) {
        this.isBan = isBan;
    }

    public Boolean isBan() {
        return isBan;
    }

    public Account() {}

    public Account(String username, String password, String email, String phone, Boolean isBan) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.isBan = isBan;
    }

    public Account(String username) {
        this.username = username;
    }

    

}
