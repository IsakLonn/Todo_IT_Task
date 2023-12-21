package se.lexicon.model;

import se.lexicon.util.StringHelper;

public class Person {

    //variables
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private AppUser credentials;

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
    public AppUser getCredentials(){ return credentials;}

    //setters
    public void setFirstName(String firstName){
        if(StringHelper.isNullOrEmpty(firstName)) throw new IllegalArgumentException("First name was null or empty");
        this.firstName = firstName;
    }
    public void setLastName(String lastName){
        if(StringHelper.isNullOrEmpty(lastName)) throw new IllegalArgumentException("Last name was null or empty");
        this.lastName = lastName;
    }
    public void setEmail(String email){
        if(StringHelper.isNullOrEmpty(email)) throw new IllegalArgumentException("Email was null or empty");
        this.email = email;
    }
    public void setCredentials(AppUser credentials){
        if(credentials == null) throw new IllegalArgumentException("Credentials was null");
        this.credentials = credentials;
    }

    private void setId(int id){this.id = id;}

    //constructor
    public Person(String firstName, String lastName, String email, int id){
        setFirstName(firstName);
        setLastName(lastName);
        setEmail(email);
        setId(id);
    }
    public Person(String firstName, String lastName, String email, int id, AppUser credentials){
        this(firstName, lastName, email, id);
        setCredentials(credentials);
    }

    //overrides
    @Override
    public String toString() {
        return  "id: " + getId() + "\n" +
                "name: " + getFirstName() + " " + getLastName() + "\n" +
                "email: " + getEmail();
    }
    @Override
    public boolean equals(Object obj) {
        Person cast = Person.class.cast(obj);

        boolean equals;

        equals = cast.getFirstName() == getFirstName();
        equals = cast.getLastName() == getLastName();
        equals = cast.getId() == getId();
        equals = cast.getEmail() == getEmail();

        return equals;
    }

    @Override
    public int hashCode() { return getFirstName().hashCode() + getLastName().hashCode() + getEmail().hashCode() + getId(); }
}
