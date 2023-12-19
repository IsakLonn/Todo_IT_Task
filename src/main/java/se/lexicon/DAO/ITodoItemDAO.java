package se.lexicon.DAO;

import se.lexicon.TodoItem;

import java.time.LocalDate;
import java.util.Collection;

public interface ITodoItemDAO {

    public TodoItem persist(TodoItem todoItem);
    public TodoItem findById(int id);
    public Collection<TodoItem> findAll();
    public Collection<TodoItem> findAllByDoneStatus(boolean status);
    public Collection<TodoItem> findByTitleContains(String title);
    public Collection<TodoItem> findByPersonId(int id);
    public Collection<TodoItem> findByDeadlineAfter(LocalDate after);
    public Collection<TodoItem> findByDeadlineBefore(LocalDate before);
    public void remove(int id);
}
