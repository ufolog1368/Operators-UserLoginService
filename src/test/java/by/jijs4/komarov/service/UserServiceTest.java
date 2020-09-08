package by.jijs4.komarov.service;

import by.jijs4.komarov.bean.User;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserServiceTest {

    @Test
    public void loginTrue() {
        var userService = new UserService();
        User user = new User("igor", "1234", false, 3);

        boolean actual = userService.login(user, "1234");
        assertTrue(actual);
    }

    @Test
    public void loginFalse() {
        var userService = new UserService();
        User user = new User("igor", "1234", false, 3);

        boolean actual = userService.login(user, "3456");
        assertFalse(actual);
    }

    @Test
    public void dropAttemptEntry() {
        var user = new User("igor", "1234", false, 3);
        var userService = new UserService();
        int expected = 3;
        int actual = userService.dropAttemptEntry(user);

        assertEquals(expected, actual);
    }

    @Test
    public void blockUser() {
        var user = new User("igor", "1234", false, 3);
        var userService = new UserService();

        boolean actual = userService.blockUser(user);
        assertFalse(actual);
    }

    @Test
    public void chekPasswordTrue() {
        var user = new User("igor", "1234", false, 3);
        var userService = new UserService();

        boolean actual = userService.chekPassword(user, "1234");
        assertTrue(actual);
    }

    @Test
    public void chekPasswordFalse() {
        var user = new User("igor", "1234", false, 3);
        var userService = new UserService();

        boolean actual = userService.chekPassword(user, "123454");
        assertFalse(actual);
    }


    @Test
    public void ifNoBlockedDropAttempt() {
        var user = new User("igor", "1234", false, 3);
        var userService = new UserService();

       boolean expected = user.isBlockUser();
       boolean actual = userService.ifNoBlockedDropAttempt(user);
       assertEquals(expected, actual);
    }


    @Test
    public void reduceAttempt() {
        var user = new User("igor", "1234", false, 3);
        var userService = new UserService();
        userService.login(user, "234");
        userService.login(user, "23456");

        int expected = 1;
        int actual = user.getAttemptsEntry();
        assertEquals(expected,actual);
    }

    @Test
    public void isUserBlock() {
        var user = new User("igor", "1234", false, 3);
        var userService = new UserService();
        userService.blockUser(user);

        boolean actual = user.isBlockUser();
        assertFalse(actual);
    }

    @Test
    public void testLoginBlockUserAfterAllAttempts() {
        var user = new User("igor", "1234", false, 3);
        var userService = new UserService();
        userService.login(user, "84746");
        userService.login(user, "68736");
        userService.login(user, "94846");

        boolean expected = true;
        boolean actual = user.isBlockUser();
        assertEquals(expected, actual);

    }

    @Test
    public void testLoginFirstAttempts() {
        var user = new User("igor", "1234", false, 3);
        var userService = new UserService();
        userService.login(user, "84746");

        boolean expected = false;
        boolean actual = user.isBlockUser();
        assertEquals(expected, actual);

    }
}