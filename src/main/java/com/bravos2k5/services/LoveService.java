package com.bravos2k5.services;

import com.bravos2k5.daos.LoveDAO;
import com.bravos2k5.daos.UserDAO;
import com.bravos2k5.models.Love;
import com.bravos2k5.models.User;

import java.sql.Date;

public class LoveService {

    public static int IN_A_RELATIONSHIP = 1;
    public static int SINGLE = 0;
    public static int SAME_GENDER = 2;

    public static int pairLover(User a, User b) {
        if(!a.getGender().equals(b.getGender())) {
            if (a.getLove() == null && b.getLove() == null) {
                Love love = new Love();
                if(a.getGender().equals(User.FEMALE)) {
                    love.setWife(a);
                    love.setHusband(b);
                }
                else {
                    love.setWife(b);
                    love.setHusband(a);
                }
                love.setDate(new Date(System.currentTimeMillis()));
                a.setLove(love);
                b.setLove(love);
                LoveDAO.getInstance().insert(love);
                UserDAO.getInstance().update(a);
                UserDAO.getInstance().update(b);
                return SINGLE;
            }
            else {
                return IN_A_RELATIONSHIP;
            }
        }
        else {
            return SAME_GENDER;
        }
    }

    public static boolean breakUp(Love love) {
        try {
            love.getWife().setLove(null);
            love.getHusband().setLove(null);
            UserDAO.getInstance().update(love.getHusband());
            UserDAO.getInstance().update(love.getWife());
            LoveDAO.getInstance().delete(love);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
