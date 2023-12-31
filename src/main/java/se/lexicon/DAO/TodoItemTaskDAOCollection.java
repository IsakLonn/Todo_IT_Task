package se.lexicon.DAO;

import se.lexicon.model.TodoItemTask;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

public class TodoItemTaskDAOCollection implements ITOdoItemTaskDAO{

    private ArrayList<TodoItemTask> list = new ArrayList<>();

    private static TodoItemTaskDAOCollection instance;

    public static TodoItemTaskDAOCollection getInstance() {
        if(instance == null) instance = new TodoItemTaskDAOCollection();
        return instance;
    }

    @Override
    public TodoItemTask persist(TodoItemTask todoItemTask) {
        if(todoItemTask == null) return null;
        list.add(todoItemTask);
        return todoItemTask;
    }

    @Override
    public TodoItemTask findById(int id) {
        for (TodoItemTask item: list) {
            if(item.getId() == id) return item;
        }
        return null;
    }

    @Override
    public Collection<TodoItemTask> findAll() {
        return list;
    }

    @Override
    public Collection<TodoItemTask> findByAssignedStatus(boolean status) {
        ArrayList<TodoItemTask> itemsByAssignedStatus = new ArrayList<>();
        for (TodoItemTask item: list) {
            if(item.isAssigned() == status) itemsByAssignedStatus.add(item);
        }
        return itemsByAssignedStatus;
    }

    @Override
    public Collection<TodoItemTask> findByPersonId(int id) {
        ArrayList<TodoItemTask> itemsByPersonId = new ArrayList<>();
        for (TodoItemTask item: list) {
            if(item.getAsignee().getId() == id) itemsByPersonId.add(item);
        }
        return itemsByPersonId;
    }

    @Override
    public void remove(int id) {
        TodoItemTask toRemove = null;
        for (TodoItemTask item: list) {
            if(Objects.equals(item.getId(), id)) toRemove = item;
        }
        if(toRemove != null) list.remove(toRemove);
    }
}
