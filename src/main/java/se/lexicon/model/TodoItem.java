package se.lexicon.model;

import se.lexicon.util.StringHelper;

import java.time.LocalDate;

public class TodoItem extends Identifiable{

    //variables
    private String title;
    private String description;
    private LocalDate deadLine;
    private boolean done;
    private int asignee_ID;

    //getters
    public String getTitle(){return title;}
    public String getTaskDescription(){ return description;}
    public LocalDate getDeadLine(){return deadLine;}
    public int getAsignee_ID(){return asignee_ID;}
    public boolean isOverdue(){ return deadLine.isAfter(LocalDate.now()); }
    public boolean isDone(){return done;}

    //setters
    public void setTitle(String title){
        if(StringHelper.isNullOrEmpty(title)) throw new IllegalArgumentException("Title was null or empty");
        else this.title = title;
    }
    public void setTaskDescrition(String description){
        if(StringHelper.isNullOrEmpty(description)) throw new IllegalArgumentException("Description was null or empty");
        else this.description = description;
    }
    public void setDeadLine(LocalDate deadLine){
        if(deadLine == null ||deadLine.isBefore(LocalDate.now()) || deadLine.equals(LocalDate.now())) throw new IllegalArgumentException("DeadLine was null or before " + LocalDate.now());
        else this.deadLine = deadLine;
    }
    public void setDone(boolean done){ this.done = done;}
    public void setAsignee_ID(int ID){ asignee_ID = ID; }

    //constructor
    public TodoItem(String title, String description, LocalDate deadLine){
        setTitle(title);
        setTaskDescrition(description);
        setDeadLine(deadLine);
        setDone(false);
    }

    //override
    @Override
    public String toString() {
        return  "id: " + getId() + "\n" +
                "Title: " + getTitle() + "\n" +
                "Description: " + getTaskDescription() + "\n" +
                "Deadline: " + getDeadLine();
    }
    @Override
    public boolean equals(Object obj) {
        TodoItem cast = TodoItem.class.cast(obj);

        boolean equals;

        equals = cast.getId() == getId();
        equals = cast.getTitle() == getTitle();
        equals = cast.getTaskDescription() == getTaskDescription();
        equals = cast.getDeadLine() == getDeadLine();

        return equals;
    }
    @Override
    public int hashCode() { return getTitle().hashCode() + getTaskDescription().hashCode() + getDeadLine().hashCode() + getId(); }
}