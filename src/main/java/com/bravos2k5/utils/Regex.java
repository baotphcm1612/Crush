package com.bravos2k5.utils;

public class Regex {
    public static boolean isStrongPassword(String password) {
        String regex = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$";
        return password.matches(regex);
    }

    private static boolean isEmail(String email) {
        String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        return email.matches(regex);
    }

    private static boolean isPhone(String phone) {
        String regex = "^(?:\\+\\d{1,14}|\\d{1,14})$";
        return phone.matches(regex);
    }
}
