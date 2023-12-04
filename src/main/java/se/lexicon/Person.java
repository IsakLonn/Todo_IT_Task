package se.lexicon;

public class Person {

    private static int personsCreated;
    private int id;
    private String firstName;
    private String lastName;
    private String email;

    /**
     creates a person with a first name, last name and email
     */
    public Person(String firstName, String lastName, String email){
        this();
        setFirstName(firstName);
        setLastName(lastName);
        setEmail(email);
    }

    /**
     creates an empty/boilerplate person to be filled later
     */
    public Person(){
        id = createUniqueId();
        setFirstName("John");
        setLastName("Doe");
        setEmail("John.Doe@forgotten.com");
    }

    public int getId(){
        return id;
    }

    public String getFirstName(){
        return firstName;
    }

    public void setFirstName(String firstName){
        if(firstName == null) throw new IllegalArgumentException("First name was null");
        this.firstName = firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public void setLastName(String lastName){
        if(lastName == null) throw new IllegalArgumentException("Last name was null");
        this.lastName = lastName;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        if(email == null) throw new IllegalArgumentException("Email was null");
        this.email = email;
    }

    /**
     gets a summary of the person. <br>
     For example: <br>
     id: 4, <br>
     name: Nisse Olsson, <br>
     email: nisse@gmail.com
     */
    public String getSummary(){
        return "id: " + getId() + "\nname: " + getFirstName() + " " + getLastName() + "\n" + "email: " + getEmail();
    }

    public static int createUniqueId(){ // helper function to create a unique id
        int uniqueId = personsCreated;
        personsCreated++;
        return uniqueId;
    }

}
