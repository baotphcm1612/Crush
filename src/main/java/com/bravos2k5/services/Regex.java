package com.bravos2k5.services;

public class Regex {
    public static boolean isStrongPassword(String password) {
        String regex = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$";
        return password.matches(regex);
    }
}
