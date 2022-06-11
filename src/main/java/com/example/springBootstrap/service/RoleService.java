package com.example.springBootstrap.service;

import com.example.springBootstrap.model.Role;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public interface RoleService {
    List<Role> getAllRoles();

    Role getRole(String userRole);

    Role getRoleById(Long id);

    void addRole(Role role);

    Set<Role> findByIdRoles(HashSet<Long> roles);
}
