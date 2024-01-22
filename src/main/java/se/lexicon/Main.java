package se.lexicon;

import se.lexicon.DAO.Collection.PersonDAOCollection;
import se.lexicon.model.Person;

public class Main {
    public static void main(String[] args) {
        Person isak = new Person("Isak", "Lönn");
        Person test = new Person("Test", "Testson");

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