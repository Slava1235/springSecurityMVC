package ru.javamentor.dao;

import org.springframework.stereotype.Repository;
import ru.javamentor.model.Role;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.HashSet;
import java.util.Set;

@Repository
public class RoleDaoImp implements RoleDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Set<Role> getAllRoles() {
        return new HashSet<>(entityManager.createQuery("SELECT u FROM Role u", Role.class).getResultList());
    }

    @Override
    public Role findByRoleName(String name) {
        return entityManager.createQuery("SELECT r FROM Role r WHERE r.role = :name", Role.class).setParameter("name", name).getSingleResult();
    }

    @Override
    public Role findByRoleId(Long id) {
        return entityManager.find(Role.class, id);
    }

    @Override
    public void saveRole(Role role) {
        entityManager.merge(role);
    }
}
