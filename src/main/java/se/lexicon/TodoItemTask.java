package se.lexicon;

public class TodoItemTask {
    static int TasksCreated;
    private int id;
    private boolean assigned;
    private TodoItem todoItem;
    private Person asignee;

    public int getId(){return id;}
    public Person getAsignee(){return asignee;}
    public TodoItem getTodoItem(){return todoItem;}
    /**
     gets a summary of the Task. <br>
     For example: <br>
     id: 4, <br>
     To do: clean <br>
     Assigned person: Isak Lönn, <br>
     */
    public String getSummary(){
        return  "id: " + getId() + "\n" +
                "To do: " + getTodoItem().getTitle() + "\n" +
                "Assigned person: " + getAsignee().getFirstName() + " " + getAsignee().getLastName();
    }

    public void setAssigned(boolean assigned){this.assigned = assigned;}
    public void setTodoItem(TodoItem todoItem) {
        if(todoItem == null) throw new IllegalArgumentException("todo item was null");
        this.todoItem = todoItem;
    }

    public void setAsignee(Person asignee){
        if(asignee == null) throw new IllegalArgumentException("asignee was null");
        this.asignee = asignee;
    }

    public boolean isAssigned(){return isAssigned();}


    public TodoItemTask(Person asignee, TodoItem todoItem){
        setAsignee(asignee);
        setTodoItem(todoItem);
        setAssigned(true);
        id = createUniqueId();
    }

    public static int createUniqueId(){ // helper function to create a unique id
        int uniqueId = TasksCreated;
        TasksCreated++;
        return uniqueId;
    }
}
