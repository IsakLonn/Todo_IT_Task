package se.lexicon.DAO;

import se.lexicon.model.TodoItemTask;

import java.util.Collection;

public interface ITodoItemTaskDAO extends IDAOBase<TodoItemTask, Integer>{
    public Collection<TodoItemTask> findBy(boolean status);
    public Collection<TodoItemTask> findBy(int id);
}
