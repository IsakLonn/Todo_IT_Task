package se.lexicon.DAO;

import se.lexicon.model.AppUser;
import se.lexicon.util.StringHelper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;
import java.util.Optional;

public class AppUserDAOCollection implements IAppUserDAO{

    private static AppUserDAOCollection instance;

    public static AppUserDAOCollection getInstance() {
        if(instance == null) instance = new AppUserDAOCollection();
        return instance;
    }

    private ArrayList<AppUser> users = new ArrayList<AppUser>();
    @Override
    public AppUser persist(AppUser user) {
        if(user == null) return null;
        users.add(user);
        return user;
    }

    @Override
    public AppUser findByUserName(String username) {
        if(StringHelper.isNullOrEmpty(username)) return null;
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
    public void remove(String username) {
        if(StringHelper.isNullOrEmpty(username)) return;
        AppUser toRemove = null;
        for (AppUser user: users) {
            if(Objects.equals(user.getUsername(), username)) toRemove = user;
        }
        if(toRemove != null) users.remove(toRemove);
    }
}
