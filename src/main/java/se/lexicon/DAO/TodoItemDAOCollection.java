package se.lexicon.DAO;

import se.lexicon.model.TodoItem;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

public class TodoItemDAOCollection implements ITodoItemDAO{

    ArrayList<TodoItem> list = new ArrayList<>();

    private static TodoItemDAOCollection instance;

    public static TodoItemDAOCollection getInstance() {
        if(instance == null) instance = new TodoItemDAOCollection();
        return instance;
    }

    @Override
    public TodoItem persist(TodoItem todoItem) {
        if(todoItem == null) return null;
        list.add(todoItem);
        return todoItem;
    }

    @Override
    public TodoItem findById(int id) {
        for (TodoItem item: list) {
            if(item.getId() == id) return item;
        }
        return null;
    }

    @Override
    public Collection<TodoItem> findAll() {
        return list;
    }

    @Override
    public Collection<TodoItem> findAllByDoneStatus(boolean status) {
        ArrayList<TodoItem> itemsByStatus = new ArrayList<>();
        for (TodoItem item: list) {
            if(item.isDone() == status) itemsByStatus.add(item);
        }
        return itemsByStatus;
    }

    @Override
    public Collection<TodoItem> findByTitleContains(String title) {
        ArrayList<TodoItem> itemsByTitle = new ArrayList<>();
        for (TodoItem item: list) {
            if(item.getTitle().contains(title)) itemsByTitle.add(item);
        }
        return itemsByTitle;
    }

    @Override
    public Collection<TodoItem> findByPersonId(int id) {
        ArrayList<TodoItem> itemsByPersonId = new ArrayList<>();
        for (TodoItem item: list) {
            if(item.getCreator().getId() == id) itemsByPersonId.add(item);
        }
        return itemsByPersonId;
    }

    @Override
    public Collection<TodoItem> findByDeadlineAfter(LocalDate after) {
        ArrayList<TodoItem> itemsByDeadlineAfter = new ArrayList<>();
        for (TodoItem item: list) {
            if(item.getDeadLine().isAfter(after)) itemsByDeadlineAfter.add(item);
        }
        return itemsByDeadlineAfter;
    }

    @Override
    public Collection<TodoItem> findByDeadlineBefore(LocalDate before) {
        ArrayList<TodoItem> itemsByDeadlineBefore = new ArrayList<>();
        for (TodoItem item: list) {
            if(item.getDeadLine().isBefore(before)) itemsByDeadlineBefore.add(item);
        }
        return itemsByDeadlineBefore;
    }

    @Override
    public void remove(int id) {
        TodoItem toRemove = null;
        for (TodoItem item: list) {
            if(Objects.equals(item.getId(), id)) toRemove = item;
        }
        if(toRemove != null) list.remove(toRemove);
    }
}
