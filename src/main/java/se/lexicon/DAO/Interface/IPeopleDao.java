package se.lexicon.DAO.Interface;

import se.lexicon.model.Person;

import java.util.Collection;

public interface IPeopleDao extends IDAOBase<Person, Integer>{
    public Collection<Person> findBy(String name);
    public Person update(Person person);
}
