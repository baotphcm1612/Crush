package com.bravos2k5.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
public class User {
    public static boolean FEMALE = false;
    public static boolean MALE = true;
    public static byte SINGLE = 0;
    public static byte DATING = 1;
    public static byte MARRIAGE = 2;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private Boolean gender;

    private byte status;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    @ManyToMany(cascade = CascadeType.ALL, targetEntity = User.class)
    @JoinTable(name = "friendship", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "friend_id"))
    Set<User> friend = new HashSet<>();

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "memberList",targetEntity = Team.class)
    Set<Team> teamList = new HashSet<>();

    @OneToOne(cascade = CascadeType.ALL, targetEntity = User.class)
    @JoinColumn(name = "lover_id")
    private User lover;

    public User() {}

    public User(int id) {
        this.id = id;
    }

    public User(String name, Boolean gender) {
        this.name = name;
        this.gender = gender;
    }

    public User(String name, Boolean gender, Account account) {
        this.name = name;
        this.gender = gender;
        this.account = account;
    }
}
