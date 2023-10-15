package seminars.third.tdd;

public class User {

    String name;
    String password;
    boolean isAdmin = false;
    boolean isAuthenticate = false;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public User(String name, String password, boolean isAdmin) {
        this.name = name;
        this.password = password;
        this.isAdmin = isAdmin;
    }

    public boolean authenticate(String name, String password) {
        if (this.name.equals(name) && this.password.equals(password)) {
            this.isAuthenticate = true;
            return true;
        } else return false;
    }

}