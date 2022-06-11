package com.example.springBootstrap.util;

import com.example.springBootstrap.model.Role;
import com.example.springBootstrap.model.User;
import com.example.springBootstrap.service.RoleService;
import com.example.springBootstrap.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

@Component
public class DefoultInit {
    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public DefoultInit(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @PostConstruct
    private void dataBaseInit() {
        roleService.addRole(new Role(1L,"USER"));
        roleService.addRole(new Role(2L,"ADMIN"));
        Set<Role> role= new HashSet<>();
        role.add(roleService.getRoleById(1L));
        role.add(roleService.getRoleById(2L));
        User user = new User("admin", "adminov", (byte) 20, "admin@mail", "admin", "admin", role);
        userService.saveUser(user);






       /* Role roleAdmin = new Role("ADMIN");
        Role roleUser = new Role("USER");
        Set<Role> adminSet = new HashSet<>();
        Set<Role> userSet = new HashSet<>();

        roleService.addRole(roleAdmin);
        roleService.addRole(roleUser);

        adminSet.add(roleAdmin);
        adminSet.add(roleUser);
        userSet.add(roleUser);

        User newUser = new User("Ivan", "Ivanov", 23, "ivan@mail.com", "User",
                "user", userSet);
        User admin = new User("Garry", "Potter", 30, "garry@gmail.com", "admin",
                "admin", adminSet);

        userService.saveUser(newUser);
        userService.saveUser(admin);*/
    }
}
