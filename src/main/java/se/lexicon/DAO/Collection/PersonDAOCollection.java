package se.lexicon.DAO.Collection;

import se.lexicon.DAO.Interface.IPersonDAO;
import se.lexicon.model.Person;
import se.lexicon.sequencer.Sequencer;
import se.lexicon.util.SequencerEnum;
import se.lexicon.util.StringHelper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

public class PersonDAOCollection implements IPersonDAO {

    //variables
    private static PersonDAOCollection instance;
    private ArrayList<Person> items;

    //constructor
    private PersonDAOCollection(){
        items = new ArrayList<>();
    }

    //singleton method
    public static PersonDAOCollection getInstance() {
        if(instance == null) instance = new PersonDAOCollection();
        return instance;
    }

    @Override
    public Person create(Person person) {
        if(person == null) return null;
        person.setId(Sequencer.getNextId(SequencerEnum.PERSON));
        items.add(person);
        return person;
    }
    @Override
    public Collection<Person> findAll() { return new ArrayList<>(items); }
    @Override
    public Person find(Integer id) {
        for (Person person: items) {
            if(person.getId() == id) return person;
        }
        return null;
    }
    @Override
    public void remove(Integer id) {
        Person toRemove = null;
        for (Person person: items) {
            if(Objects.equals(person.getId(), id)) toRemove = person;
        }
        if(toRemove != null) items.remove(toRemove);
    }
}
