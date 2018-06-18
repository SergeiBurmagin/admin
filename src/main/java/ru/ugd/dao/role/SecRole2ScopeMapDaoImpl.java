package ru.ugd.dao.role;

import org.springframework.stereotype.Repository;
import ru.ugd.dao.AbstractDao;
import ru.ugd.model.SecRole2ScopeMap;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository("secRole2ScopeMapDao")
public class SecRole2ScopeMapDaoImpl  extends AbstractDao  implements SecRole2ScopeMapDao {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<SecRole2ScopeMap> findAllSecRole2ScopeMap() {

        String hql = "FROM SecRole2ScopeMap as u";

        return (List<SecRole2ScopeMap>) entityManager.createQuery(hql);
    }

    @Override
    public List<SecRole2ScopeMap> findBySecRole2ScopeId(String roleId) {

        Query query = entityManager.createQuery("from SecRole2ScopeMap u where u.secRoleSpr = :roleId");

        query.setParameter("roleId", roleId);

        return (List<SecRole2ScopeMap> )query.getResultList();

    }
}
