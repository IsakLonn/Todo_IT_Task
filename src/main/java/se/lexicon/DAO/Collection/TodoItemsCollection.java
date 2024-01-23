package se.lexicon.DAO.Collection;

import se.lexicon.DAO.Interface.ITodoItemsDAO;
import se.lexicon.model.Person;
import se.lexicon.model.TodoItem;
import se.lexicon.util.StringHelper;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

public class TodoItemsCollection implements ITodoItemsDAO {

    @Override
    public TodoItem create(TodoItem item) {
        if(StringHelper.isNullOrEmpty(item.getTitle()) || StringHelper.isNullOrEmpty(item.getTaskDescription()))
        {
            System.out.println("Title or description was null/empty");
            return null;
        }

        String insertQuery = "INSERT INTO todo_item(title, description, deadline, done, assignee_id) VALUES(?,?,?,?,?)";
        try(
                Connection connection = se.lexicon.util.Connection.getConnection();
                PreparedStatement statement = connection.prepareStatement(insertQuery);

        ) {

            statement.setString(1, item.getTitle());
            statement.setString(2, item.getTaskDescription());
            statement.setDate(3, item.getDeadLine());
            statement.setBoolean(4, item.isDone());
            statement.setInt(5, item.getAsignee_ID());

            int updates = statement.executeUpdate();
            if(updates > 0) System.out.println("Successfully created todo item " + item);
            else System.out.println("Error creating todo item " + item);

        } catch (SQLException e) { System.out.println("Error inserting new todo item"); }

        return item;
    }

    @Override
    public Collection<TodoItem> findAll() {
        Collection<TodoItem> items = new ArrayList<>();

        try(
                Connection connection = se.lexicon.util.Connection.getConnection();
                Statement statement = connection.createStatement();
                ResultSet set = statement.executeQuery("SELECT * FROM todo_item");
        ) {


            while(set.next()) {

                String title = set.getString("title");
                String description = set.getString("description");
                Date deadline = set.getDate("deadline");
                boolean done = set.getBoolean("done");
                int assignee_id = set.getInt("assignee_id");
                int id = set.getInt("todo_id");

                items.add(new TodoItem(title, description, deadline, done, 1, id));
            }
        } catch (SQLException e) { System.out.println("Error getting all items"); }

        return items;
    }

    @Override
    public TodoItem find(Integer item) {
        TodoItem _item = null;
        String insertQuery = "SELECT * FROM todo_item WHERE todo_id = ?";
        try(
                Connection connection = se.lexicon.util.Connection.getConnection();
                PreparedStatement statement = connection.prepareStatement(insertQuery);
        ) {
            statement.setInt(1, item);
            try(ResultSet set = statement.executeQuery()){
                set.next();
                String title = set.getString("title");
                String description = set.getString("description");
                Date deadline = set.getDate("deadline");
                boolean done = set.getBoolean("done");
                int assignee_id = set.getInt("assignee_id");
                int todo_id = set.getInt("todo_id");
                _item = new TodoItem(title,description, deadline, done, assignee_id, todo_id);

            }

        } catch (SQLException e) { System.out.println("Error finding item with id " + item); }

        return _item;
    }

    @Override
    public void remove(Integer item) {
        String insertQuery = "delete from todo_item where todo_id = ?";
        try(
                Connection connection = se.lexicon.util.Connection.getConnection();
                PreparedStatement statement = connection.prepareStatement(insertQuery);

        ) {
            statement.setInt(1, item);
            int updates = statement.executeUpdate();

            if(updates > 0) System.out.println("Successfully removed item with id " + item);
            else System.out.println("Error removing item with id " + item);
        } catch (SQLException e) { System.out.println("Error finding item with id " + item); }
    }

    @Override
    public Collection<TodoItem> findBy(boolean status) {
        Collection<TodoItem> items = new ArrayList<>();
        String insertQuery = "SELECT * FROM todo_item WHERE done = ?";
        try(
                Connection connection = se.lexicon.util.Connection.getConnection();
                PreparedStatement statement = connection.prepareStatement(insertQuery);

        ) {
            statement.setBoolean(1, status);
            try(ResultSet set = statement.executeQuery();) {
                while(set.next()) {
                    String title = set.getString("title");
                    String description = set.getString("description");
                    Date deadline = set.getDate("deadline");
                    boolean done = set.getBoolean("done");
                    int assignee_id = set.getInt("assignee_id");
                    int todo_id = set.getInt("todo_id");
                    items.add(new TodoItem(title,description, deadline, done, assignee_id, todo_id));
                }
            }

        } catch (SQLException e) { System.out.println("Error getting all items with status " + status); }

        return items;
    }

    @Override
    public Collection<TodoItem> findBy(int assigneeID) {
        Collection<TodoItem> items = new ArrayList<>();
        String insertQuery = "SELECT * FROM todo_item WHERE assignee_id = ?";
        try(
                Connection connection = se.lexicon.util.Connection.getConnection();
                PreparedStatement statement = connection.prepareStatement(insertQuery);

        ) {
            statement.setInt(1, assigneeID);
            try(ResultSet set = statement.executeQuery();) {
                while(set.next()) {
                    String title = set.getString("title");
                    String description = set.getString("description");
                    Date deadline = set.getDate("deadline");
                    boolean done = set.getBoolean("done");
                    int assignee_id = set.getInt("assignee_id");
                    int todo_id = set.getInt("todo_id");
                    items.add(new TodoItem(title,description, deadline, done, assignee_id, todo_id));
                }
            }

        } catch (SQLException e) { System.out.println("Error getting all items with assignee_id " + assigneeID); }

        return items;
    }

    @Override
    public Collection<TodoItem> findBy(Person assigneedPerson) {
        Collection<TodoItem> items = new ArrayList<>();
        String insertQuery = "SELECT * FROM todo_item WHERE assignee_id = ?";
        try(
                Connection connection = se.lexicon.util.Connection.getConnection();
                PreparedStatement statement = connection.prepareStatement(insertQuery);

        ) {
            statement.setInt(1, assigneedPerson.getId());
            try(ResultSet set = statement.executeQuery();) {
                while(set.next()) {
                    String title = set.getString("title");
                    String description = set.getString("description");
                    Date deadline = set.getDate("deadline");
                    boolean done = set.getBoolean("done");
                    int assignee_id = set.getInt("assignee_id");
                    int todo_id = set.getInt("todo_id");
                    items.add(new TodoItem(title,description, deadline, done, assignee_id, todo_id));
                }
            }

        } catch (SQLException e) { System.out.println("Error getting all items with assignee_id " + assigneedPerson.getId()); }

        return items;
    }

    @Override
    public Collection<TodoItem> findUnassignedItems() {
        Collection<TodoItem> items = new ArrayList<>();
        String insertQuery = "SELECT * FROM todo_item WHERE assignee_id is null";
        try(
                Connection connection = se.lexicon.util.Connection.getConnection();
                PreparedStatement statement = connection.prepareStatement(insertQuery);
                ResultSet set = statement.executeQuery();
        ) {
            while(set.next()) {
                String title = set.getString("title");
                String description = set.getString("description");
                Date deadline = set.getDate("deadline");
                boolean done = set.getBoolean("done");
                int assignee_id = set.getInt("assignee_id");
                int todo_id = set.getInt("todo_id");
                items.add(new TodoItem(title,description, deadline, done, assignee_id, todo_id));

            }

        } catch (SQLException e) { System.out.println("Error getting all unassigned items");}

        return items;
    }

    @Override
    public TodoItem update(TodoItem item) {
        if(StringHelper.isNullOrEmpty(item.getTitle()) || StringHelper.isNullOrEmpty(item.getTaskDescription()))
        {
            System.out.println("Title or description was null/empty");
            return null;
        }

        String updateQuery = "update todo_item set title = ?, description = ?, deadline = ?, done = ?, assignee_id = ? where todo_id = ?";
        try(
                Connection connection = se.lexicon.util.Connection.getConnection();
                PreparedStatement statement = connection.prepareStatement(updateQuery);

        ) {

            statement.setString(1, item.getTitle());
            statement.setString(2, item.getTaskDescription());
            statement.setDate(3, item.getDeadLine());
            statement.setBoolean(4, item.isDone());
            statement.setInt(5, item.getAsignee_ID());
            statement.setInt(6, item.getId());
            int updates = statement.executeUpdate();

            if(updates > 0) System.out.println("Successfully updated item " + item);
            else System.out.println("Error updating item " + item);

        } catch (SQLException e) { System.out.println("Error updating item " + item); }

        return item;
    }
}
