package se.lexicon;

public class Person {

    //variables
    private static int personsCreated;
    private int id;
    private String firstName;
    private String lastName;
    private String email;

    //getters
    public int getId(){
        return id;
    }
    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public String getEmail(){
        return email;
    }
    /**
     gets a String summary of the person {id,name and email}
     */
    public String getSummary(){
        return  "id: " + getId() + "\n" +
                "name: " + getFirstName() + " " + getLastName() + "\n" +
                "email: " + getEmail();
    }

    //setters
    public void setFirstName(String firstName){
        if(firstName == null || firstName.isEmpty()) throw new IllegalArgumentException("First name was null or empty");
        this.firstName = firstName;
    }
    public void setLastName(String lastName){
        if(lastName == null || lastName.isEmpty()) throw new IllegalArgumentException("Last name was null or empty");
        this.lastName = lastName;
    }
    public void setEmail(String email){
        if(email == null || email.isEmpty()) throw new IllegalArgumentException("Email was null or empty");
        this.email = email;
    }

    //constructor
    public Person(String firstName, String lastName, String email){
        setFirstName(firstName);
        setLastName(lastName);
        setEmail(email);
        id = createUniqueId();
    }

    //other
    public static int createUniqueId(){ // helper function to create a unique id
        int uniqueId = personsCreated;
        personsCreated++;
        return uniqueId;
    }

}
