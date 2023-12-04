package se.lexicon;

public class Person {

    private static int personsCreated;
    private int id;
    private String firstName;
    private String lastName;
    private String email;

    public Person(String firstName, String lastName, String email){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        id = createUniqueId();
    }

    public int getId(){
        return id;
    }

    public static int createUniqueId(){ // helper function to create a unique id
        int uniqueId = personsCreated;
        personsCreated++;
        return uniqueId;
    }

}
