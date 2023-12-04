package se.lexicon;

public class TodoItemTask {
    static int TasksCreated;
    private int id;
    private boolean assigned;
    private TodoItem todoItem;
    private Person asignee;

    public int getId(){return id;}
    public boolean isAssigned(){return isAssigned();}
    public void setAssigned(boolean assigned){this.assigned = assigned;}
    public TodoItem getTodoItem(){return todoItem;}
    public void setTodoItem(TodoItem todoItem) {this.todoItem = todoItem;}
    public Person getAsignee(){return asignee;}
    public void setAsignee(Person asignee){this.asignee = asignee;}
    /**
     gets a summary of the Task. <br>
     For example: <br>
     id: 4, <br>
     Todo: Clean, <br>
     Assigned person: Isak Lönn, <br>
     */
    public String getSummary(){
        return "id: " + getId() + "\nTodo: " + getTodoItem().getTitle() + "\nAssigned person: " + getAsignee().getFirstName() + " " + getAsignee().getLastName();
    }

    public TodoItemTask(Person asignee, TodoItem todoItem){

    }

    public static int createUniqueId(){ // helper function to create a unique id
        int uniqueId = TasksCreated;
        TasksCreated++;
        return uniqueId;
    }
}
