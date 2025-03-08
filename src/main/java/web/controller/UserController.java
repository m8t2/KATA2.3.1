package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
        List<User> users = userDAO.findAllUsers();
        model.addAttribute("users", users);
        model.addAttribute("user", new User());
        return "index";
    }

    @PostMapping("/add")
    public String createUser(@ModelAttribute("user") User user) {
        userDAO.addUser(user);
        return "redirect:/";
    }

    @GetMapping("/delete")
    public String deleteUser(@RequestParam("id") int id) {
        userDAO.deleteUser(id);
        return "redirect:/";
    }

    @GetMapping("/update")
    public String editUserForm(@RequestParam("id") int id, Model model) {
        User user = userDAO.findUser(id);
        if (user == null) {
            return "redirect:/";
        }
        model.addAttribute("user", user);
        return "update";
    }

    @PostMapping("/edit")
    public String updateUser(@ModelAttribute("user") User user) {
        userDAO.updateUser(user);
        return "redirect:/";
    }
}
