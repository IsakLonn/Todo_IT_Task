package se.lexicon.DAO.Collection;

import se.lexicon.DAO.Interface.ITodoItemDAO;
import se.lexicon.model.TodoItem;
import se.lexicon.sequencer.Sequencer;
import se.lexicon.util.DateCheck;
import se.lexicon.util.SequencerEnum;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

public class TodoItemDAOCollection implements ITodoItemDAO {

    //variables
    ArrayList<TodoItem> items;
    private static TodoItemDAOCollection instance;

    //constructor
    private TodoItemDAOCollection(){
        items = new ArrayList<>();
    }

    //singleton method
    public static TodoItemDAOCollection getInstance() {
        if(instance == null) instance = new TodoItemDAOCollection();
        return instance;
    }

    //overrides
    @Override
    public Collection<TodoItem> findBy(boolean status) {
        ArrayList<TodoItem> itemsByStatus = new ArrayList<>();
        for (TodoItem item: items) {
            if(item.isDone() == status) itemsByStatus.add(item);
        }
        return itemsByStatus;
    }
    @Override
    public Collection<TodoItem> findBy(String title) {
        ArrayList<TodoItem> itemsByTitle = new ArrayList<>();
        for (TodoItem item: items) {
            if(item.getTitle().contains(title)) itemsByTitle.add(item);
        }
        return itemsByTitle;
    }
    @Override
    public Collection<TodoItem> findBy(int id) {
        ArrayList<TodoItem> itemsByPersonId = new ArrayList<>();
        for (TodoItem item: items) {
            if(item.getCreator().getId() == id) itemsByPersonId.add(item);
        }
        return itemsByPersonId;
    }
    @Override
    public Collection<TodoItem> findBy(LocalDate date, DateCheck check) {
        ArrayList<TodoItem> itemsByDeadline = new ArrayList<>();

        for (TodoItem item: items) {
            switch (check){
                case AFTER:
                    if(item.getDeadLine().isAfter(date)) itemsByDeadline.add(item);
                    break;

                case BEFORE:
                    if(item.getDeadLine().isBefore(date)) itemsByDeadline.add(item);
                    break;
            }

        }

        return itemsByDeadline;

    }
    @Override
    public TodoItem create(TodoItem todoItem) {
        if(todoItem == null) return null;
        todoItem.setId(Sequencer.getNextId(SequencerEnum.TODOITEM));
        items.add(todoItem);
        return todoItem;
    }
    @Override
    public Collection<TodoItem> findAll() { return new ArrayList<>(items); }
    @Override
    public TodoItem find(Integer id) {
        for (TodoItem item: items) {
            if(item.getId() == id) return item;
        }
        return null;
    }
    @Override
    public void remove(Integer id) {
        TodoItem toRemove = null;
        for (TodoItem item: items) {
            if(Objects.equals(item.getId(), id)) toRemove = item;
        }
        if(toRemove != null) items.remove(toRemove);
    }
}
