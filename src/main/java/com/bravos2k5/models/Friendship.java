package com.bravos2k5.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Entity
@Getter
@Setter
public class Friendship {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private User friend;

    private Date dateBeFriend;

    public Friendship() {}

    public Friendship(User friend, Date dateBeFriend) {
        this.setFriend(friend);
        this.dateBeFriend = dateBeFriend;
    }
}
