package web.dao;

import web.model.User;

import java.util.List;

public interface UserDAO {

    List<User> getAllUsers();

    void addUser(User user);

    void deleteUser(User user);

    User findUserById(Long id);

    void updateUser(User updateUser);

    boolean ifUserExists(User user);

   User findUserByName(String name);
}
