package ru.javamentor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ru.javamentor.model.Role;
import ru.javamentor.model.User;
import ru.javamentor.service.RoleService;
import ru.javamentor.service.UserService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping(value = "/admin/")
public class AdminController {

    private UserService userService;
    private RoleService roleService;

    @Autowired
    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping(value = "")
    public String getAllUsers(ModelMap model) {
        List<User> listUsers = userService.getAllUsers();
        Set<Role> listRoles = roleService.getAllRoles();
        model.addAttribute("allUser", listUsers);
        model.addAttribute("allRoles", listRoles);
        return "allUsers";
    }


    @GetMapping(value = "addNewUser")
    public String addNewUser(ModelMap model) {
        model.addAttribute("user", new User());
        Set<Role> listRoles = roleService.getAllRoles();
        model.addAttribute("allRoles", listRoles);
        return "user-info";
    }

    @PostMapping(value = "saveUser")
    public String saveUser(@ModelAttribute("user") User user, @RequestParam("roles") String[] roles) {
        Set<Role> roleSet = new HashSet<>();
        for (String role : roles) {
            roleSet.add(roleService.findByRoleName(role));
        }
        user.setRoles(roleSet);
        userService.saveUser(user);
        return "redirect:/admin/";
    }

    @GetMapping(value = "updateInfo/{id}")
    public String updateInfo(@PathVariable("id") Long id, ModelMap model) {
        User user = userService.getUser(id);
        Set<Role> listRoles = roleService.getAllRoles();
        model.addAttribute("user", user);
        model.addAttribute("allRoles", listRoles);
        return "user-info";
    }

    @GetMapping(value = "deleteUser/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.removeUser(id);
        return "redirect:/admin/";
    }
}
