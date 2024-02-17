package com.bravos2k5.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
@Entity
@Getter
@Setter
public class Love {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    @Column(name = "husband_id")
    private User husband;

    @OneToOne
    @Column(name = "wife_id")
    private User wife;

    private Date date;

    public Love() {}

    public Love(User husband, User wife, Date date) {
        this.husband = husband;
        this.wife = wife;
        this.date = date;
    }
}
