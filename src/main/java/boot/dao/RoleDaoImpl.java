package boot.dao;

import boot.model.Role;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class RoleDaoImpl implements RoleDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void addRole(Role role) {
        entityManager.persist(role);
    }

    @Override
    @Transactional
    public void updateRole(Role role) {
        entityManager.merge(role);
    }

    @Override
    @Transactional
    public void removeRoleById(long id) {
        entityManager.remove(entityManager.find(Role.class, id));
    }

    @Override
    @Transactional
    @SuppressWarnings("unchecked")
    public List<Role> getAllRoles() {
        return entityManager.createQuery("from Role", Role.class).getResultList();
    }

    @Override
    @Transactional
    public Role getRoleByName(String name) {
        return entityManager.createQuery("select r from Role r where r.name=:role",
                Role.class).setParameter("role", name).getSingleResult();

    }

}
