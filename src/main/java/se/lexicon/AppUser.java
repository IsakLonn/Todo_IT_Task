package se.lexicon;

public class AppUser {

    //variables
    private String username;
    private String password;
    private AppRole role;

    //getters
    public String getUsername(){return username;}
    public String getPassword(){return password;}
    public AppRole getRole(){return role;}

    //setters
    public void setUsername(String username){
        if(StrringHelper.isNullOrEmoty(username)) throw new IllegalArgumentException("Username was null or empty");
        else this.username = username;
    }
    public void setPassword(String password){
        if(StrringHelper.isNullOrEmoty(password)) throw new IllegalArgumentException("Password was null or empty");
        else this.password = password;
    }
    public void setRole(AppRole role){
        if(role == null) throw new IllegalArgumentException("Role was null");
        this.role = role;
    }

    //constructor
    public AppUser(String username, String password, AppRole role){
        setUsername(username);
        setPassword(password);
        setRole(role);
    }

    //overrides

    @Override
    public String toString() {
        return  "Username: " + getUsername() + "\n" +
                "Role: " + getRole();
    }
    @Override
    public int hashCode() { return username.hashCode() + role.hashCode(); }
    @Override
    public boolean equals(Object obj) {
        AppUser cast = AppUser.class.cast(obj);
        return cast.getUsername() == getUsername() && cast.getRole() == getRole();
    }
}
