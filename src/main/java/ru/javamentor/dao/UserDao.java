package ru.javamentor.dao;

import ru.javamentor.model.User;

import java.util.List;

public interface UserDao {
    public List<User> getAllUsers();

    public void saveUser(User user);

    public User getUser(Long id);

    public void removeUser(Long id);

    User findByUserName(String username);
}
