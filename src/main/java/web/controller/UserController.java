package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import web.DAO.UserDAO;
import web.model.User;

import java.util.List;


@Controller
public class UserController {

    private final UserDAO userDAO;

    @Autowired
    public UserController(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @GetMapping("/")
    public String getIndex(Model model) {
            List<User> users = userDAO.findAllUsers(); // Получаем всех пользователей
            model.addAttribute("users", users);   // Добавляем список в модель
        return "index";
    }

    @Transactional
    @GetMapping("/add")
    public String addUser(@ModelAttribute("user") User user) {
        return "add";
    }

    @PostMapping
    public String createUser(@ModelAttribute("user") User user) {
        userDAO.addUser(user);
        return "redirect:/";
    }
}