package ru.javamentor.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.javamentor.model.Role;
import ru.javamentor.model.User;
import ru.javamentor.service.RoleService;
import ru.javamentor.service.UserService;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

@Component
public class UserAdminInit {

    private  UserService userService;
    private  RoleService roleService;

    @Autowired
    public UserAdminInit(UserService userService, RoleService roleDao) {
        this.userService = userService;
        this.roleService = roleDao;
    }

    @PostConstruct
    void init() {
        Set<Role> setAdmin = new HashSet<>();
        Role roleUser = new Role("USER");
        Role roleAdmin = new Role("ADMIN");
        roleService.saveRole(roleUser);
        roleService.saveRole(roleAdmin);
        setAdmin.add(roleService.findByRoleId(1L));
        setAdmin.add(roleService.findByRoleId(2L));
        User admin = new User("ADMIN", "ADMIN", 0, "ADMIN", setAdmin);
        Set<Role> setUser = new HashSet<>();
        setUser.add(roleService.findByRoleId(1L));
        User normalUser = new User("USER", "USER", 0, "USER", setUser);
        userService.saveUser(admin);
        userService.saveUser(normalUser);
    }
}
