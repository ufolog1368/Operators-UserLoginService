package by.jijs4.komarov.bean;

import org.junit.Test;

import static org.junit.Assert.*;

public class UserTest {

    @Test
    public void getLogin() {
        var user = new User();
        user.setLogin("igor");

        String expected = "igor";
        String actual = user.getLogin();
        assertEquals(expected, actual);
    }

    @Test
    public void getPassword() {
        var user = new User();
        user.setPassword("1234");

        String expected = "1234";
        String actual = user.getPassword();
        assertEquals(expected, actual);
    }

    @Test
    public void isBlockUser() {
        var user = new User();
        user.setBlockUser(true);

        boolean expected = true;
        boolean actual = user.isBlockUser();
        assertEquals(expected, actual);
    }

    @Test
    public void getAttemptsEntry() {
        var user = new User();
        user.setAttemptsEntry(3);

        int expected = 3;
        int actual = user.getAttemptsEntry();
        assertEquals(expected, actual);
    }

    @Test
    public void testEquals() {
        var user1 = new User("igor", "234", true, 3);
        var user2 = new User("igor", "234", true, 3);

        boolean expected = true;
        boolean actual = user1.equals(user2);
        assertEquals(expected, actual);
    }

    @Test
    public void testHashCode() {
        var user = new User("igor", "234", true, 3);

        long expected = 1802022599;
        long actual = user.hashCode();
        assertEquals(expected,actual);
    }

    @Test
    public void testToString() {
        var user = new User("igor", "234", true, 3);


        String expected = "User{login='igor', password='234', isBlockUser=true, attemptsEntry=3}";
        String actual = user.toString();
        assertEquals(expected,actual);
    }
}