package com.example.PP311.service;


import com.example.PP311.model.User;

import java.util.List;

public interface UserService {

    void createUser(User user);

    void deleteUser(long id);

    void updateUser(User user);

    List<User> getAllUsers();

    User getUser(long id);

}
