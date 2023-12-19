package se.lexicon;

import se.lexicon.util.StrringHelper;

import java.time.LocalDate;

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

    //setters
    public void setTitle(String title){
        if(StrringHelper.isNullOrEmpty(title)) throw new IllegalArgumentException("Title was null or empty");
        else this.title = title;
    }
    public void setTaskDescrition(String description){
        if(StrringHelper.isNullOrEmpty(description)) throw new IllegalArgumentException("Description was null or empty");
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
        setDone(false);
        id = createUniqueId();
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

    //other
    public static int createUniqueId(){ // helper function to create a unique id
        int uniqueId = todosCreated;
        todosCreated++;
        return uniqueId;
    }
}