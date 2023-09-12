package com.samkingworld.librarySystem.service;

import com.samkingworld.librarySystem.utils.UpdateReqest;
import com.samkingworld.librarySystem.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    public List<User> getAllUsers();

    public Optional<User> getUserById(Long id);
    public String createUser(User user);
    public String deleteUserById(Long id);
    public String deleteUserByUserId(String id);
    public User getUserByEmail(String email);
    public User updateUser( String user_id, UpdateReqest updateReqest);
    String deleteUserByEmail(String email);

    User getUserByUserId(String userId);
}
