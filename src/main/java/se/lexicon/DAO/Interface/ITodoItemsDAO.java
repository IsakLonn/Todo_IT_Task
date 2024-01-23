package se.lexicon.DAO.Interface;

import se.lexicon.model.Person;
import se.lexicon.model.TodoItem;

import java.util.Collection;

public interface ITodoItemsDAO extends IDAOBase<TodoItem, Integer>{
    public Collection<TodoItem> findBy(boolean status);
    public Collection<TodoItem> findBy(int assigneeID);
    public Collection<TodoItem> findBy(Person assigneedPerson);
    public Collection<TodoItem> findUnassignedItems();
    public TodoItem update(TodoItem item);
}
