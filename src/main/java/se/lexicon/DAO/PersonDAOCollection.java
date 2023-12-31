package se.lexicon.DAO;

import se.lexicon.model.Person;
import se.lexicon.util.StringHelper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

public class PersonDAOCollection implements IPersonDAO{

    private static PersonDAOCollection instance;

    public static PersonDAOCollection getInstance() {
        if(instance == null) instance = new PersonDAOCollection();
        return instance;
    }

    private ArrayList<Person> persons = new ArrayList<>();

    @Override
    public Person persist(Person person) {
        if(person == null) return null;
        persons.add(person);
        return person;
    }

    @Override
    public Person findById(int id) {
        for (Person person: persons) {
            if(person.getId() == id) return person;
        }
        return null;
    }

    @Override
    public Person findByEmail(String email) {
        if(StringHelper.isNullOrEmpty(email)) return null;
        for (Person person: persons) {
            if(person.getEmail() == email) return person;
        }
        return null;
    }

    @Override
    public Collection<Person> findAll() {
        return new ArrayList<>(persons);
    }

    @Override
    public void remove(int id) {
        Person toRemove = null;
        for (Person person: persons) {
            if(Objects.equals(person.getId(), id)) toRemove = person;
        }
        if(toRemove != null) persons.remove(toRemove);
    }


}
