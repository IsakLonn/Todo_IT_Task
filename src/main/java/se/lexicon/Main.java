package se.lexicon;

import se.lexicon.DAO.Collection.PeopleCollection;
import se.lexicon.DAO.Collection.PersonDAOCollection;
import se.lexicon.DAO.Collection.TodoItemsCollection;
import se.lexicon.model.Person;
import se.lexicon.model.TodoItem;
import se.lexicon.util.Connection;

import java.sql.Date;

public class Main {
    public static void main(String[] args) {
        Connection.set_url("jdbc:mysql://localhost:3306/todoit");
        Connection.set_username("root");
        Connection.set_password("Undulat159!");

        Date deadline = new Date(2024, 01,01);
        var itemsCollection = new TodoItemsCollection();
        var peopleCollection = new PeopleCollection();
        TodoItem item = new TodoItem("testTitle", "testDescription", deadline,true, 4);
        //itemsCollection.create(item);
        //itemsCollection.findAll().forEach(System.out::println);
        //System.out.println(itemsCollection.find(1));
        //itemsCollection.remove(1);
        //itemsCollection.findBy(true).forEach(System.out::println);
        //itemsCollection.findBy(4).forEach(System.out::println);
        //itemsCollection.findBy(peopleCollection.find(4)).forEach(System.out::println);
        //itemsCollection.findUnassignedItems().forEach(System.out::println);
        item = itemsCollection.find(6);
        item.setTitle("update");
        itemsCollection.update(item);

    }
}