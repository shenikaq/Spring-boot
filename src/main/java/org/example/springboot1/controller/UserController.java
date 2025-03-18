package org.example.springboot1.controller;

import org.example.springboot1.model.User;
import org.example.springboot1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String getUser(Model model) {
        //todo
        model.addAttribute("users", userService.userList());
        return "user";
    }

    @GetMapping("/add")
    public String create(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String email) {
        User user = new User(firstName, lastName, email);
        userService.save(user);
        return "redirect:/user";
    }
////    http://localhost:8080/user/add?firstName=fn1&lastName=ln1&email=e1
////    http://localhost:8080/user/add?firstName=fn2&lastName=ln2&email=e2
////    http://localhost:8080/user/add?firstName=fn3&lastName=ln3&email=e3

    @GetMapping("/delete")
    public String delete(@RequestParam long id) {
        userService.delete(id);
        return "redirect:/user";
    }
////    http://localhost:8080/user/delete?id=3

    @GetMapping("/update")
    public String updateUser(@RequestParam Long id, @RequestParam String firstName, @RequestParam String lastName, @RequestParam String email) {
        User user = userService.getById(id);
        if (user != null) {
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setEmail(email);
            userService.save(user);
        }
        return "redirect:/user";
    }
////    http://localhost:8080/user/update?id=2&firstName=fn1&lastName=ln1&email=e1
}
