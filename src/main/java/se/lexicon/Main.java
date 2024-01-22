package se.lexicon;

import se.lexicon.DAO.Collection.PeopleCollection;
import se.lexicon.DAO.Collection.PersonDAOCollection;
import se.lexicon.model.Person;
import se.lexicon.util.Connection;

public class Main {
    public static void main(String[] args) {
        Connection.set_url("jdbc:mysql://localhost:3306/todoit");
        Connection.set_username("root");
        Connection.set_password("Undulat159!");

        Person me = new Person("test", "testson");
        var collection = new PeopleCollection();

        collection.create(me);
        var findAll = collection.findAll();

        findAll.forEach(System.out::println);
    }
}