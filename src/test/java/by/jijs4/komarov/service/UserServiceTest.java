package by.jijs4.komarov.service;

import by.jijs4.komarov.bean.User;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserServiceTest {

    @Test
    public void loginTrue() {
        var userService = new UserService();
        User user = new User("igor", "1234", false, 3);
        String password = "1234";

        boolean actual = userService.login(user, password);
        assertTrue(actual);
    }

    @Test
    public void loginFalse() {
        var userService = new UserService();
        User user = new User("igor", "1234", false, 3);
        String password = "12345";

        boolean actual = userService.login(user, password);
        assertFalse(actual);
    }

    @Test
    public void dropAttemptEntry() {
        var user = new User("igor", "1234", false, 3);
        user.setAttemptsEntry(3);
        int expected = 3;
        int actual = user.getAttemptsEntry();

        assertEquals(expected, actual);
    }

    @Test
    public void blockUser() {
    }

    @Test
    public void chekPassword() {
    }

    @Test
    public void ifNoBlockedDropAttempt() {
    }

    @Test
    public void reduceAttempt() {
    }

    @Test
    public void isUserBlock() {
    }
}