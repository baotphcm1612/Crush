package com.bravos2k5.services;

import com.bravos2k5.daos.TeamDAO;
import com.bravos2k5.daos.UserDAO;
import com.bravos2k5.models.Team;
import com.bravos2k5.models.User;

public class TeamService {
    public static boolean addMember(Team team, User user) {
        if(team.getMemberList().add(user) && user.getTeamList().add(team)) {
            try {
                UserDAO.getInstance().update(user);
                TeamDAO.getInstance().update(team);
                return true;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return false;
    }

    public static boolean kickMember(Team team, User user) {
        if(team.getMemberList().contains(user)) {
            try {
                team.getMemberList().remove(user);
                user.getTeamList().remove(team);
                TeamDAO.getInstance().update(team);
                UserDAO.getInstance().update(user);
                return true;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return false;
    }
}
