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
    /**
     gets a String summary of the To do item task {to do summary and person summary}
     */
    public String getSummary(){
        return  "id: " + getId() + "\n" +
                "To do:\n" +
                getTodoItem().getSummary() + "\n" +
                "Assigned person:\n" +
                getAsignee().getSummary();
    }

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

    //other
    public static int createUniqueId(){ // helper function to create a unique id
        int uniqueId = TasksCreated;
        TasksCreated++;
        return uniqueId;
    }
}
