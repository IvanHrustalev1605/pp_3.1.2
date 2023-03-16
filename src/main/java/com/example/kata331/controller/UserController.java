package com.example.kata331.controller;

import com.example.kata331.model.User;
import com.example.kata331.service.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    private final UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String findAll(ModelMap model, User user) {
        model.addAttribute("users", userService.allUsers(user));
        return "users";
    }

    @GetMapping(value = "/user/{id}")
    public String getOneUser(@PathVariable(value = "id") Long id,
                             Model model) {
        model.addAttribute("userById", userService.getUserById(id));
        return "oneUser";
    }

    @GetMapping("/users/addForm")
    public String show(Model model) {
        model.addAttribute("user", new User());
        return "userAddForm";
    }

    @PostMapping("/")
    public String addUser(@ModelAttribute("user") User user) {
        userService.create(user);
        return "redirect:/";
    }

    @GetMapping("/{id}")
    public String deleteUser(@PathVariable ("id") Long id) {
        userService.delete(id);
        return "redirect:/";
    }

    @GetMapping(value = "user/edit/{id}")
    public String edit(ModelMap model, @ModelAttribute(value = "id") Long id) {
        model.addAttribute("user", userService.getUserById(id));
        return "userUpdateForm";
    }

    @PostMapping(value = "user/{id}")
    public String updateUser(@ModelAttribute(value = "user") User user,
                             @PathVariable("id") Long id) {
        userService.update(user, id);
        return "redirect:/";
    }
}
