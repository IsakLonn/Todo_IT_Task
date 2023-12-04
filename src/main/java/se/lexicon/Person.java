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
        setFirstName(firstName);
        setLastName(lastName);
        setEmail(email);
        id = createUniqueId();
    }

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
     gets a summary of the person. <br>
     For example: <br>
     id: 4, <br>
     name: Nisse Olsson, <br>
     email: nisse@gmail.com
     */
    public String getSummary(){
        return  "id: " + getId() + "\n" +
                "name: " + getFirstName() + " " + getLastName() + "\n" +
                "email: " + getEmail();
    }

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

    public static int createUniqueId(){ // helper function to create a unique id
        int uniqueId = personsCreated;
        personsCreated++;
        return uniqueId;
    }

}
