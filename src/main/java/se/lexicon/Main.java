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


        var collection = new PeopleCollection();
        Person me = collection.find(30);
        me.setLastName("updateson");
        collection.update(me);

    }
}