package se.lexicon.DAO.Collection;

import se.lexicon.DAO.Interface.IAppUserDAO;
import se.lexicon.model.AppUser;
import se.lexicon.util.StringHelper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

public class AppUserDAOCollection implements IAppUserDAO {

    // variables
    private static AppUserDAOCollection instance;
    private ArrayList<AppUser> items;

    //constructor
    private AppUserDAOCollection(){
        items = new ArrayList<>();
    }

    //singleton method
    public static AppUserDAOCollection getInstance() {
        if(instance == null) instance = new AppUserDAOCollection();
        return instance;
    }

    //overrides
    @Override
    public void remove(String username) {
        if(StringHelper.isNullOrEmpty(username)) return;
        AppUser toRemove = null;
        for (AppUser user: items) {
            if(Objects.equals(user.getUsername(), username))
            {
                toRemove = user;
                break;
            }
        }
        if(toRemove != null) items.remove(toRemove);
    }

    @Override
    public AppUser create(AppUser user) {
        if(user == null) return null;
        if(find(user.getUsername()) != null) return null;
        items.add(user);
        return user;
    }

    @Override
    public Collection<AppUser> findAll() { return new ArrayList<>(items); }

    @Override
    public AppUser find(String username) {
        if(StringHelper.isNullOrEmpty(username)) return null;
        for (AppUser user: items) {
            if(Objects.equals(user.getUsername(), username)) return user;
        }
        return null;
    }
}
