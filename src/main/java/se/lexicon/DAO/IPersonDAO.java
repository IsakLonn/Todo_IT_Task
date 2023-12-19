package se.lexicon.DAO;

import se.lexicon.Person;

import java.util.Collection;

public interface IPersonDAO {
    public Person persist(Person person);
    public Person findById(int id);
    public Person findByEmail(String email);
    public Collection<Person> findAll();
    public void remove(int id);
}
