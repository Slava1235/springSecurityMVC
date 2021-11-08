package ru.javamentor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.javamentor.dao.RoleDao;
import ru.javamentor.model.Role;

import java.util.Set;

@Service
public class RoleServiceImp implements RoleService {
    private RoleDao roleDao;

    @Autowired
    public RoleServiceImp(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    @Transactional
    public Role findByRoleId(Long id) {
        return roleDao.findByRoleId(id);
    }

    @Override
    @Transactional
    public void saveRole(Role role) {
         roleDao.saveRole(role);
    }

    @Override
    @Transactional
    public Set<Role> getAllRoles() {
        return roleDao.getAllRoles();
    }

    @Override
    @Transactional
    public Role findByRoleName(String name) {
        return roleDao.findByRoleName(name);
    }
}
