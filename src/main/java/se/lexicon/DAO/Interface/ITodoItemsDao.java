package se.lexicon.DAO.Interface;

import se.lexicon.model.Person;
import se.lexicon.model.TodoItem;

import java.util.Collection;

public interface ITodoItemsDao extends IDAOBase<TodoItem, Integer>{
    public Collection<TodoItem> FindBy(boolean status);
    public Collection<TodoItem> FindBy(int assigneeID);
    public Collection<TodoItem> FindBy(Person assigneedPerson);
    public Collection<TodoItem> FindUnassignedItems();
    public TodoItem update(TodoItem item);
}
