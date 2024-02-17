package com.bravos2k5.models;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
    private Account account;

    @OneToOne(cascade = CascadeType.ALL)
    private Love love;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "friend", targetEntity = Friendship.class)
    List<Friendship> friendList = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "memberList",targetEntity = Team.class)
    Set<Team> teamList = new HashSet<>();

    public User() {}

    public User(String name, Boolean gender, Account account) {

    }

}
