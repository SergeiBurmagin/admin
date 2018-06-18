package ru.ugd.dao.role;

import org.springframework.stereotype.Repository;
import ru.ugd.dao.AbstractDao;
import ru.ugd.model.SecUser2RoleMap;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository("secUser2RoleMapDao")
public class SecUser2RoleMapDaoImpl  extends AbstractDao implements SecUser2RoleMapDao {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<SecUser2RoleMap> findAllSecUser2RoleMap() {

        String hql = "FROM SecUser2RoleMap as u";

        return (List<SecUser2RoleMap>) entityManager.createQuery(hql);
    }

    @Override
    public List<SecUser2RoleMap> findBySecUser2RoleMapId(String roleId) {

        Query query = entityManager.createQuery("from SecUser2RoleMap u where u.secRoleSpr = :roleId");

        query.setParameter("roleId", roleId);

        List<SecUser2RoleMap> q = query.getResultList();

        return q;
}
}
