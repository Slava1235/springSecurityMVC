package ru.javamentor.dao;

import ru.javamentor.model.Role;

import java.util.Set;

public interface RoleDao {
    public Set<Role> getAllRoles();

    public Role findByRoleName(String name);

    public Role findByRoleId(Long id);

    void saveRole(Role role);
}