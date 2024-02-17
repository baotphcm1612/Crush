package com.bravos2k5.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "Team_User",
               joinColumns = {@JoinColumn(name = "Team_id")},
                inverseJoinColumns = {@JoinColumn(name = "User_id")})
    private Set<User> memberList = new HashSet<>();

    public Team() {
    }

    public Team(String name, Set<User> memberList) {
        this.name = name;
        this.memberList = memberList;
    }
}
