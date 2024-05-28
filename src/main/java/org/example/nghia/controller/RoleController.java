package org.example.nghia.controller;

import org.example.nghia.entities.Role;
import org.example.nghia.entities.User;
import org.example.nghia.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @GetMapping("")
    public String ShowAllRole(Model model){
        List<Role> roles = roleService.getAllRole();
        model.addAttribute("roles", roles);
        return "roles/index";
    }
    @GetMapping("/create")
    public String createForm(Model model){
        Role role = new Role();
        model.addAttribute("role",role);
        return "roles/create";
    }
    @PostMapping("/save")
    public String saveRole(Role role){
        roleService.createRole(role);
        return "redirect:/role";
    }

    @GetMapping("/edit/{id}")
    public String ShowRoleForm(@PathVariable String id, Model model){
        Role role = roleService.getRoleById(id);
        model.addAttribute("role", role);
        return "roles/edit";
    }
    @PostMapping("/saveedit")
    public String SaveEditRole(Role role){
        roleService.updateRole(role,role.getId());
        return "redirect:/role";
    }
}
