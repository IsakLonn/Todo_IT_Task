package se.lexicon.DAO;

import se.lexicon.model.TodoItemTask;

import java.util.Collection;

public interface ITOdoItemTaskDAO {

    public TodoItemTask persist(TodoItemTask todoItemTask);
    public TodoItemTask findById(int id);
    public Collection<TodoItemTask> findAll();
    public Collection<TodoItemTask> findByAssignedStatus(boolean status);
    public Collection<TodoItemTask> findByPersonId(int id);
    public void remove(int id);
}
