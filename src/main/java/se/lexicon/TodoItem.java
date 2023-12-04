package se.lexicon;

import java.time.LocalDate;
import java.time.LocalTime;

public class TodoItem {

    static int todosCreated;
    private int id;
    private String title;
    private String description;
    private LocalDate deadLine;
    private boolean done;
    private Person creator;

    public int getId(){return id;}
    public String getTitle(){return title;}
    public String getTaskDescription(){ return description;}
    public LocalDate getDeadLine(){return deadLine;}
    public Person getCreator(){return creator;}

    public void setTitle(String title){
        if(title == null || title.isEmpty()) throw new IllegalArgumentException("Title was null or empty");
        else this.title = title;
    }
    public void setTaskDescrition(String description){
        if(description == null || description.isEmpty()) throw new IllegalArgumentException("Description was null or empty");
        else this.description = description;
    }
    public void setDeadLine(LocalDate deadLine){
        if(deadLine == null ||deadLine.isAfter(LocalDate.now())) throw new IllegalArgumentException("DeadLine was null or has passed");
        else this.deadLine = deadLine;
    }
    public void setDone(boolean done){ this.done = done;}
    public void setCreator(Person creator){
        if(creator == null) throw new IllegalArgumentException("Creator was null");
        this.creator = creator;
    }

    public boolean isOverdue(){ return deadLine.isAfter(LocalDate.now()); }
    public boolean isDone(){return done;}


    /**
     gets a summary of the Task. <br>
     For example: <br>
     id: 4, <br>
     Title: Clean, <br>
     Description: Clean house, <br>
     Deadline: 2024-01-02, <br>
     Creator: Anders Svensson
     */
    public String getSummary(){
        return  "id: " + getId() + "\n" +
                "Title: " + getTitle() + "\n" +
                "Description: " + getTaskDescription() + "\n" +
                "Deadline: " + getDeadLine() + "\n" +
                "Creator: " + getCreator().getFirstName() + " " + getCreator().getLastName();
    }
    public TodoItem(String title, String description, Person creator, LocalDate deadLine){
        setTitle(title);
        setTaskDescrition(description);
        setDeadLine(deadLine);
        setCreator(creator);
        id = createUniqueId();
    }
    public static int createUniqueId(){ // helper function to create a unique id
        int uniqueId = todosCreated;
        todosCreated++;
        return uniqueId;
    }
}