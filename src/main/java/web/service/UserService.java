package web.service;

import web.model.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    boolean addUser(User user);

    void deleteUser(User user);

    User findUserById(Long id);

    void updateUser(User user);

    User findUserByName(String name);
}
