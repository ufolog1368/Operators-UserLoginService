package by.jijs4.komarov.bean;

import java.util.Objects;

public class User {
    private String login = "igor";
    private String password;
    private boolean isBlockUser;
    private int attemptsEntry;

    public User() {
    }

    public User(String login, String password, boolean isBlockUser, int attemptsEntry) {
        this.login = login;
        this.password = password;
        this.isBlockUser = isBlockUser;
        this.attemptsEntry = attemptsEntry;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isBlockUser() {
        return isBlockUser;
    }

    public void setBlockUser(boolean blockUser) {
        isBlockUser = blockUser;
    }

    public int getAttemptsEntry() {
        return attemptsEntry;
    }

    public void setAttemptsEntry(int attemptsEntry) {
        this.attemptsEntry = attemptsEntry;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return isBlockUser == user.isBlockUser &&
                attemptsEntry == user.attemptsEntry &&
                Objects.equals(login, user.login) &&
                Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, password, isBlockUser, attemptsEntry);
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", isBlockUser=" + isBlockUser +
                ", attemptsEntry=" + attemptsEntry +
                '}';
    }
}
