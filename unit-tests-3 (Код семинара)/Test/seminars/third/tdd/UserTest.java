package seminars.third.tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserTest {
    User user;
    User admin;

    @BeforeEach
    public void setUp() {
        user = new User("user", "qwerty");
        admin = new User("admin", "qwerty123", true);
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
        UserRepository repository = new UserRepository();
        user.authenticate("user", "qwerty");
        repository.addUser(user);
        assertTrue(repository.data.contains(user));
    }

    @Test
    public void addWrongAuthenticatedUser() {
        UserRepository repository = new UserRepository();
        user.authenticate("user1", "qwerty");
        repository.addUser(user);
        assertFalse(repository.data.contains(user));
    }

    @Test
    public void addNotAuthenticatedUser() {
        UserRepository repository = new UserRepository();
        repository.addUser(user);
        assertFalse(repository.data.contains(user));
    }
}