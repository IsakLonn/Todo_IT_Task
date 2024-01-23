package se.lexicon.DAO.Collection;

import se.lexicon.DAO.Interface.IPeopleDao;
import se.lexicon.model.Person;
import se.lexicon.util.StringHelper;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

/**
 Collection that talks with the database
 */
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
                int id = set.getInt("person_id");
                people.add(new Person(firstName, lastName, id));
            }
        } catch (SQLException e) { System.out.println("Error getting all people"); }

        return people;
    }

    @Override
    public Person find(Integer item) {
        Person person = null;
        String insertQuery = "SELECT * FROM PERSON WHERE person_id = ?";
        try(
                Connection connection = se.lexicon.util.Connection.getConnection();
                PreparedStatement statement = connection.prepareStatement(insertQuery);
        ) {
            statement.setInt(1, item);
            try(ResultSet set = statement.executeQuery()){
                set.next();
                String firstName = set.getString("first_name");
                String lastName = set.getString("last_name");
                int id = set.getInt("person_id");
                person = new Person(firstName, lastName, id);

            }

        } catch (SQLException e) { System.out.println("Error finding person with id " + item); }

        return person;
    }

    @Override
    public void remove(Integer item) {
        String insertQuery = "delete from person where person_id = ?";
        try(
                Connection connection = se.lexicon.util.Connection.getConnection();
                PreparedStatement statement = connection.prepareStatement(insertQuery);

        ) {
            statement.setInt(1, item);
            int updates = statement.executeUpdate();

            if(updates > 0) System.out.println("Successfully removed person with id " + item);
            else System.out.println("Error removing person with id " + item);
        } catch (SQLException e) { System.out.println("Error finding person with id " + item); }
    }

    @Override
    public Collection<Person> findBy(String firstName) {
        Collection<Person> people = new ArrayList<>();
        String insertQuery = "SELECT * FROM PERSON WHERE first_name = ?";
        try(
                Connection connection = se.lexicon.util.Connection.getConnection();
                PreparedStatement statement = connection.prepareStatement(insertQuery);

        ) {
            statement.setString(1, firstName);
            try(ResultSet set = statement.executeQuery();) {
                while(set.next()) {
                    String _firstName = set.getString("first_name");
                    String lastName = set.getString("last_name");
                    int id = set.getInt("person_id");
                    people.add(new Person(_firstName, lastName, id));
                }
            }

        } catch (SQLException e) { System.out.println("Error getting all people with first names " + firstName); }

        return people;
    }

    @Override
    public Person update(Person person) {
        if(StringHelper.isNullOrEmpty(person.getFirstName()) || StringHelper.isNullOrEmpty(person.getLastName()))
        {
            System.out.println("First or last name was null/empty");
            return null;
        }

        String updateQuery = "update person set first_name = ?, last_name = ? where person_id = ?";
        try(
                Connection connection = se.lexicon.util.Connection.getConnection();
                PreparedStatement statement = connection.prepareStatement(updateQuery);

        ) {
            statement.setString(1, person.getFirstName());
            statement.setString(2, person.getLastName());
            statement.setInt(3, person.getId());
            int updates = statement.executeUpdate();

            if(updates > 0) System.out.println("Successfully updated person with id " + person.getId());
            else System.out.println("Error updating person with id " + person.getId());

        } catch (SQLException e) { System.out.println("Error updating person with id " + person.getId()); }

        return person;
    }
}
