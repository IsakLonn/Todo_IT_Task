package se.lexicon;

import java.time.LocalDate;
import java.time.LocalTime;

public class TodoItem {

    //variables
    static int todosCreated;
    private int id;
    private String title;
    private String description;
    private LocalDate deadLine;
    private boolean done;
    private Person creator;

    //getters
    public int getId(){return id;}
    public String getTitle(){return title;}
    public String getTaskDescription(){ return description;}
    public LocalDate getDeadLine(){return deadLine;}
    public Person getCreator(){return creator;}
    public boolean isOverdue(){ return deadLine.isAfter(LocalDate.now()); }
    public boolean isDone(){return done;}
    /**
     gets a String summary of the to do item {id,title, description and deadline with creator summary}
     */
    public String getSummary(){
        return  "id: " + getId() + "\n" +
                "Title: " + getTitle() + "\n" +
                "Description: " + getTaskDescription() + "\n" +
                "Deadline: " + getDeadLine() + "\n" +
                "Creator: \n" +
                getCreator().getSummary();
    }

    //setters
    public void setTitle(String title){
        if(title == null || title.isEmpty()) throw new IllegalArgumentException("Title was null or empty");
        else this.title = title;
    }
    public void setTaskDescrition(String description){
        if(description == null || description.isEmpty()) throw new IllegalArgumentException("Description was null or empty");
        else this.description = description;
    }
    public void setDeadLine(LocalDate deadLine){
        if(deadLine == null ||deadLine.isBefore(LocalDate.now()) || deadLine.equals(LocalDate.now())) throw new IllegalArgumentException("DeadLine was null or before " + LocalDate.now());
        else this.deadLine = deadLine;
    }
    public void setDone(boolean done){ this.done = done;}
    public void setCreator(Person creator){
        if(creator == null) throw new IllegalArgumentException("Creator was null");
        this.creator = creator;
    }

    //constructor
    public TodoItem(String title, String description, Person creator, LocalDate deadLine){
        setTitle(title);
        setTaskDescrition(description);
        setDeadLine(deadLine);
        setCreator(creator);
        id = createUniqueId();
    }

    //other
    public static int createUniqueId(){ // helper function to create a unique id
        int uniqueId = todosCreated;
        todosCreated++;
        return uniqueId;
    }
}