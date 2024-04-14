package com.example.preproject.task231.controller;

import com.example.preproject.task231.model.User;
import com.example.preproject.task231.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("users", userService.findAllUsers());
        return "index";
    }

    @PostMapping("/createUser")
    public String createUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/";
    }

    @GetMapping(path = {"/edit", "/edit/{id}"})
    public String editUser(@PathVariable("id") Optional<Long> id, Model model) {
        model.addAttribute("user", userService.updateUser(id));
        return "new";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@ModelAttribute("user") User user,
                             @PathVariable("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/";
    }
}
