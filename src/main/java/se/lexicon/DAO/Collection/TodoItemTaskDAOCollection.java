package se.lexicon.DAO.Collection;

import se.lexicon.DAO.Interface.ITodoItemTaskDAO;
import se.lexicon.model.TodoItemTask;
import se.lexicon.sequencer.Sequencer;
import se.lexicon.util.SequencerEnum;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

public class TodoItemTaskDAOCollection implements ITodoItemTaskDAO {

    //variables
    private ArrayList<TodoItemTask> items;
    private static TodoItemTaskDAOCollection instance;

    //constructor
    private TodoItemTaskDAOCollection(){
        items = new ArrayList<>();
    }

    //singleton method
    public static TodoItemTaskDAOCollection getInstance() {
        if(instance == null) instance = new TodoItemTaskDAOCollection();
        return instance;
    }

    //overrides
    @Override
    public Collection<TodoItemTask> findBy(boolean status) {
        ArrayList<TodoItemTask> itemsByAssignedStatus = new ArrayList<>();
        for (TodoItemTask item: items) {
            if(item.isAssigned() == status) itemsByAssignedStatus.add(item);
        }
        return itemsByAssignedStatus;
    }
    @Override
    public Collection<TodoItemTask> findBy(int id) {
        ArrayList<TodoItemTask> itemsByPersonId = new ArrayList<>();
        for (TodoItemTask item: items) {
            if(item.getAsignee().getId() == id) itemsByPersonId.add(item);
        }
        return itemsByPersonId;
    }
    @Override
    public TodoItemTask create(TodoItemTask todoItemTask) {
        if(todoItemTask == null) return null;
        todoItemTask.setId(Sequencer.getNextId(SequencerEnum.TODOITEMTASK));
        items.add(todoItemTask);
        return todoItemTask;
    }
    @Override
    public Collection<TodoItemTask> findAll() {
        return new ArrayList<>(items);
    }
    @Override
    public TodoItemTask find(Integer id) {
        for (TodoItemTask item: items) {
            if(item.getId() == id) return item;
        }
        return null;
    }
    @Override
    public void remove(Integer id) {
        TodoItemTask toRemove = null;
        for (TodoItemTask item: items) {
            if(Objects.equals(item.getId(), id)) toRemove = item;
        }
        if(toRemove != null) items.remove(toRemove);
    }
}
