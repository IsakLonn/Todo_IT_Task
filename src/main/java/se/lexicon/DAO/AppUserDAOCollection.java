package se.lexicon.DAO;

import se.lexicon.AppUser;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

public class AppUserDAOCollection implements IAppUserDAO{

    private ArrayList<AppUser> users = new ArrayList<AppUser>();
    @Override
    public AppUser persist(AppUser user) {
        users.add(user);
        return user;
    }

    @Override
    public AppUser findByUserName(String username) {
        for (AppUser user: users) {
            if(Objects.equals(user.getUsername(), username)) return user;
        }
        return null;
    }

    @Override
    public Collection<AppUser> FindAll() {
        return users;
    }

    @Override
    public void remove(int username) {
        AppUser toRemove = null;
        for (AppUser user: users) {
            if(Objects.equals(user.getUsername(), username)) toRemove = user;
        }
        if(toRemove != null) users.remove(toRemove);
    }
}
