package org.example.nghia.controller;

import org.example.nghia.entities.Role;
import org.example.nghia.entities.User;
import org.example.nghia.requesEntities.RequesUpdateUser;
import org.example.nghia.requesEntities.RequesUser;
import org.example.nghia.services.RoleService;
import org.example.nghia.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserControler {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @GetMapping
    public String showAllUser(Model model){
        List<User> users = userService.getAllUser();
        model.addAttribute("users",users);
        return "user/index";
    }

    @GetMapping("/create")
    public String createUser(Model model){
        RequesUser requesUser = new RequesUser();
        List<Role> roles = roleService.getAllRole();
        model.addAttribute("user",requesUser);
        model.addAttribute("roles",roles);
        return "user/create";
    }
    @PostMapping("/save")
    public String saveUser(RequesUser requesUser){
        userService.createUser(requesUser);
        return "redirect:/user";
    }

    @GetMapping("/edit/{id}")
    public String updateUser(Model model,@PathVariable String id){
        User user = userService.getUserById(id);
        model.addAttribute("user",user);
        return "user/edit";
    }
    @PostMapping("/save_edit")
    public String updatedUser(RequesUpdateUser requesUpdateUser){
        userService.updateUser(requesUpdateUser,requesUpdateUser.getId());
        return "redirect:/user";
    }
    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable String id) {
        userService.deleteUser(id);
        return "redirect:/user";
    }
}
