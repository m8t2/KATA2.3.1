package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.DAO.UserDAO;
import web.model.User;

import java.util.List;

@Service
public class UserService {

    private UserDAO userDAO;

    @Autowired
    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Transactional
    public void addUser(User user) {
        userDAO.addUser(user);
    }

    @Transactional(readOnly = true)
    public User findUser(Long id) {
        User user = userDAO.findUser(id);
        if (user == null) {
            throw new UserNotFoundException("Пользователь с ID " + id + " не найден");
        }
        return user;
    }

    @Transactional
    public void updateUser(User user) {
        User existingUser = userDAO.findUser(user.getId());
        if (existingUser == null) {
            throw new UserNotFoundException("Пользователь с ID " + user.getId() + " не найден");
        }
        userDAO.updateUser(user);
    }

    @Transactional
    public void deleteUser(Long id) {
        User user = userDAO.findUser(id);
        if (user == null) {
            throw new UserNotFoundException("Такого пользователя для удаления не существует");
        }
        userDAO.deleteUser(id);
    }

    @Transactional(readOnly = true)
    public List<User> findAllUsers() {
        return userDAO.findAllUsers();
    }
}

