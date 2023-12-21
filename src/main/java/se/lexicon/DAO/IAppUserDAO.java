package se.lexicon.DAO;

import se.lexicon.model.AppUser;

import java.util.Collection;

public interface IAppUserDAO{

    public AppUser persist(AppUser user);
    public AppUser findByUserName(String username);
    public Collection<AppUser> FindAll();

    public void remove(String username);
}
