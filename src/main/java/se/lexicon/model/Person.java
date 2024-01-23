package se.lexicon.model;

import se.lexicon.util.StringHelper;

public class Person extends Identifiable {

    //variables
    private String firstName;
    private String lastName;

    //getters
    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }

    //setters
    public void setFirstName(String firstName){
        if(StringHelper.isNullOrEmpty(firstName)) throw new IllegalArgumentException("First name was null or empty");
        this.firstName = firstName;
    }
    public void setLastName(String lastName){
        if(StringHelper.isNullOrEmpty(lastName)) throw new IllegalArgumentException("Last name was null or empty");
        this.lastName = lastName;
    }

    //constructor
    public Person(String firstName, String lastName){
        setFirstName(firstName);
        setLastName(lastName);
    }
    public Person(String firstName, String lastName, int id){
        setFirstName(firstName);
        setLastName(lastName);
        setId(id);
    }

    //overrides
    @Override
    public String toString() {
        return  "id: " + getId() + "\n" +
                "name: " + getFirstName() + " " + getLastName();
    }
    @Override
    public boolean equals(Object obj) {
        Person cast = Person.class.cast(obj);

        boolean equals;

        equals = cast.getFirstName() == getFirstName();
        equals = cast.getLastName() == getLastName();
        equals = cast.getId() == getId();

        return equals;
    }

    @Override
    public int hashCode() { return getFirstName().hashCode() + getLastName().hashCode() + getId(); }
}
