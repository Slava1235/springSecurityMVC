package ru.javamentor.service;

import ru.javamentor.model.Role;

import java.util.Set;

public interface RoleService {
    public Role findByRoleId(Long id);

    void saveRole(Role role);

    public Set<Role> getAllRoles();

    public Role findByRoleName(String name);
}
