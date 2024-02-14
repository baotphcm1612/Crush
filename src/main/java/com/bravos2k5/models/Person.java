package com.bravos2k5.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
public class Person {
    public static boolean FEMALE = false;
    public static boolean MALE = true;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private Boolean gender;

    @ManyToOne
    private Account account;

    public Person() {

    }

}
