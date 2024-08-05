package com.scm2.services;

import java.util.List;
import java.util.Optional;

import com.scm2.models.User;

public interface UserService {

    User saveUser(User user);

    Optional<User> getUserByIdNumber(String id);

    Optional<User> updatUser(User user);

    void deleteUser(String id);

    boolean isUserExist(String id);

    boolean isUserExistByEmail(String id);

    List<User> getAllUsers();
}
