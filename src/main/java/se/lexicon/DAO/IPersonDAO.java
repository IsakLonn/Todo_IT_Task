package se.lexicon.DAO;

import se.lexicon.model.Person;

import java.util.Collection;

public interface IPersonDAO extends IDAOBase<Person, Integer>{
    public Person find(String email);
}
