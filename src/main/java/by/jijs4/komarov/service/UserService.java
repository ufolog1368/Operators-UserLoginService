package by.jijs4.komarov.service;

import by.jijs4.komarov.bean.User;

public class UserService {
    public boolean login(User user, String password){
        if(chekPassword(user, password)){
            if (blockUser(user)){
                dropAttemptEntry(user);
            }
            return true;
        }else {
            reduceAttempt(user);
            if (ifNoBlockedDropAttempt(user)){
                isUserBlock(user);
            }
            return false;
        }

    }

    public int dropAttemptEntry(User user){
       return user.getAttemptsEntry();

    }

    public  boolean blockUser(User user){
       return user.isBlockUser();

    }

    public boolean chekPassword(User user, String password){
        return user.getPassword().equals(password);

    }

    public boolean ifNoBlockedDropAttempt(User user){
       return user.getAttemptsEntry() == 0;
    }

    public User reduceAttempt(User user){
        int attempt = user.getAttemptsEntry() - 1;
        user.setAttemptsEntry(attempt);
        return user;
    }

    public User isUserBlock(User user){
        user.setBlockUser(true);
        return user;
    }
}
