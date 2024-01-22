package se.lexicon.DAO.Collection;

import se.lexicon.DAO.Interface.IPeopleDao;
import se.lexicon.model.Person;
import se.lexicon.util.StringHelper;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

public class PeopleCollection implements IPeopleDao {


    @Override
    public Person create(Person item) {

        if(StringHelper.isNullOrEmpty(item.getFirstName()) || StringHelper.isNullOrEmpty(item.getLastName()))
        {
            System.out.println("First or last name was null/empty");
            return null;
        }

        String insertQuery = "INSERT INTO PERSON(first_name, last_name) VALUES(?,?)";
        try(
                Connection connection = se.lexicon.util.Connection.getConnection();
                PreparedStatement statement = connection.prepareStatement(insertQuery);

        ) {
            statement.setString(1, item.getFirstName());
            statement.setString(2, item.getLastName());
            int updates = statement.executeUpdate();

            System.out.println(updates);

        } catch (SQLException e) { System.out.println("Error inserting new person"); }

        return item;
    }

    @Override
    public Collection<Person> findAll() {
        Collection<Person> people = new ArrayList<>();

        try(
                Connection connection = se.lexicon.util.Connection.getConnection();
                Statement statement = connection.createStatement();
                ResultSet set = statement.executeQuery("SELECT * FROM PERSON");
        ) {
            while(set.next()) {
                String firstName = set.getString("first_name");
                String lastName = set.getString("last_name");
                people.add(new Person(firstName, lastName));
            }
        } catch (SQLException e) { System.out.println("Error getting all people"); }

        return people;
    }

    @Override
    public Person find(Integer item) {
        return null;
    }

    @Override
    public void remove(Integer item) {

    }

    @Override
    public Collection<Person> findBy(String name) {
        return null;
    }

    @Override
    public Person update(Person person) {
        return null;
    }
}
