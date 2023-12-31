package se.lexicon.DAO;

import se.lexicon.model.TodoItem;
import se.lexicon.util.DateCheck;

import java.time.LocalDate;
import java.util.Collection;

public interface ITodoItemDAO extends IDAOBase<TodoItem, Integer>{
    public Collection<TodoItem> findBy(boolean status);
    public Collection<TodoItem> findBy(String title);
    public Collection<TodoItem> findBy(int id);
    public Collection<TodoItem> findBy(LocalDate date, DateCheck check);
}
