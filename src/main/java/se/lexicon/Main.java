package se.lexicon;

import se.lexicon.DAO.AppUserDAOCollection;
import se.lexicon.DAO.PersonDAOCollection;
import se.lexicon.model.AppUser;
import se.lexicon.model.Person;
import se.lexicon.model.TodoItem;
import se.lexicon.model.TodoItemTask;
import se.lexicon.sequencer.Sequencer;
import se.lexicon.util.AppRole;
import se.lexicon.util.SequencerEnum;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Person isak = new Person("Isak", "Lönn", "test@hotmail.com");
        Person test = new Person("Test", "Testson", "Test@hotmail.com");

        PersonDAOCollection collection = PersonDAOCollection.getInstance();
        collection.create(isak);
        System.out.println(collection.findAll().size());

        collection = PersonDAOCollection.getInstance();
        collection.create(isak);
        System.out.println(collection.findAll().size());

        collection = PersonDAOCollection.getInstance();
        collection.create(test);
        System.out.println(collection.findAll().size());

        System.out.println(collection.find(0));
        System.out.println(collection.find(1));
        System.out.println(collection.find(2));
    }
}