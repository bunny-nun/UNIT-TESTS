package seminars.third.tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserTest {
    User user;
    User admin;
    UserRepository repository;

    @BeforeEach
    public void setUp() {
        user = new User("user", "qwerty");
        admin = new User("admin", "qwerty123", true);
        repository = new UserRepository();
    }

    @Test
    public void authenticationCorrect() {
        assertTrue(user.authenticate("user", "qwerty"));
    }

    @Test
    public void loginIsNotCorrectTest() {
        assertFalse(user.authenticate("user1", "qwerty"));
    }

    @Test
    public void passwordIsNotCorrect() {
        assertFalse(user.authenticate("user", "qwerty123"));
    }

    @Test
    public void addAuthenticatedUser() {
        user.authenticate("user", "qwerty");
        repository.addUser(user);
        assertTrue(repository.data.contains(user));
    }

    @Test
    public void addWrongAuthenticatedUser() {
        user.authenticate("user1", "qwerty");
        repository.addUser(user);
        assertFalse(repository.data.contains(user));
    }

    @Test
    public void addNotAuthenticatedUser() {
        repository.addUser(user);
        assertFalse(repository.data.contains(user));
    }

    @Test
    public void NotAdminLogoutTest() {
        user.authenticate("user", "qwerty");
        repository.addUser(user);
        repository.massLogOut();
        assertFalse(user.isAuthenticate);

    }

    @Test
    public void AdminLogoutTest() {
        admin.authenticate("admin", "qwerty123");
        repository.addUser(admin);
        repository.massLogOut();
        assertTrue(admin.isAuthenticate);
    }


}