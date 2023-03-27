package org.example.interfaces;

import org.example.model.User;

import java.util.ArrayList;

public interface UserSQL {
    User getUser(User user);

    void regUser(User user);

    void updateUser(User user);

    ArrayList<User> searchUser(User user);

    boolean ifExists(User user);

}
