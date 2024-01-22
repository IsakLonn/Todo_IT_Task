package se.lexicon.DAO.Interface;

import se.lexicon.model.Person;

public interface IPersonDAO extends IDAOBase<Person, Integer>{
    public Person find(String email);
}
