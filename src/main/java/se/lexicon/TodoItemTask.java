package se.lexicon;

public class TodoItemTask {

    //variables
    static int TasksCreated;
    private int id;
    private boolean assigned;
    private TodoItem todoItem;
    private Person asignee;

    //getters
    public int getId(){return id;}
    public Person getAsignee(){return asignee;}
    public TodoItem getTodoItem(){return todoItem;}
    public boolean isAssigned(){return assigned;}

    //setters
    public void setAssigned(boolean assigned){this.assigned = assigned;}
    public void setTodoItem(TodoItem todoItem) {
        if(todoItem == null) throw new IllegalArgumentException("todo item was null");
        this.todoItem = todoItem;
    }
    public void setAsignee(Person asignee){
        if(asignee == null) throw new IllegalArgumentException("asignee was null");
        this.asignee = asignee;
        setAssigned(true);
    }

    //constructor
    public TodoItemTask(Person asignee, TodoItem todoItem){
        setAsignee(asignee);
        setTodoItem(todoItem);
        setAssigned(true);
        id = createUniqueId();
    }

    //overrides
    @Override
    public String toString() {
        return  "id: " + getId() + "\n" +
                "To do:\n" +
                getTodoItem();
    }
    @Override
    public boolean equals(Object obj) {
        TodoItemTask cast = TodoItemTask.class.cast(obj);

        boolean equals;

        equals = cast.getId() == getId();
        equals = cast.getTodoItem() == getTodoItem();

        return equals;
    }
    @Override
    public int hashCode() { return getTodoItem().hashCode() + getId(); }

    //other
    public static int createUniqueId(){ // helper function to create a unique id
        int uniqueId = TasksCreated;
        TasksCreated++;
        return uniqueId;
    }
}
