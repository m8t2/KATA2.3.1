package web.DAO;

import web.model.User;

import java.util.List;

public interface UserDAO {

    void addUser(User user);

    List<User> findAllUsers();

    void deleteUser(Long id);

    void updateUser(User user);

    User findUser(Long id);
}
