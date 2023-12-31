package se.lexicon.model;

/**
 base class for identifiable objects
 */
public abstract class Identifiable {

    //variables
    private int id;

    //setter
    public void setId(int id){this.id = id;}

    //getter
    public int getId(){return id;}
}
