package com.example.PP311.controller;

import com.example.PP311.model.User;
import com.example.PP311.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/")
public class UserController {

    private UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/allusers")
    public String getAllUsers(Model model) {
        List<User> userList = userService.getAllUsers();
        model.addAttribute("users", userList);
        return "/allusers";
    }
    @GetMapping("/adduser")
    public String addUser(Model model) {
        model.addAttribute("user", new User());
        return "/adduser";
    }
    @PostMapping("/adduser")
    public String add(@ModelAttribute("user") User user){
        userService.createUser(user);
        return "redirect:/allusers";
    }
    @GetMapping("/{id}/updateuser")
    public String updateUser(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userService.getUser(id));
        return "/updateuser";
    }
    @PatchMapping("/updateuser")
    public String update(@ModelAttribute("user") User user) {
        userService.updateUser(user);
        return "redirect:/allusers";
    }
    @DeleteMapping("/{id}/deleteuser")
    public String deleteUser(@PathVariable("id") long id) {
        userService.deleteUser(id);
        return "redirect:/allusers";
    }
}
