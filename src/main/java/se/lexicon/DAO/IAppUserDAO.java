package se.lexicon.DAO;

import se.lexicon.AppUser;

import java.util.Collection;
import java.util.Collections;

public interface IAppUserDAO {

    public AppUser persist(AppUser user);
    public AppUser findByUserName(String username);
    public Collection<AppUser> FindAll();

    public void remove(String username);
}
