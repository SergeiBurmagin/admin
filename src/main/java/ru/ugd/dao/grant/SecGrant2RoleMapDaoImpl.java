package ru.ugd.dao.grant;

import org.springframework.stereotype.Repository;
import ru.ugd.dao.AbstractDao;
import ru.ugd.model.SecGrant2RoleMap;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;


@Repository("SecGrant2RoleMapDao")
public class SecGrant2RoleMapDaoImpl extends AbstractDao implements SecGrant2RoleMapDao {


    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<SecGrant2RoleMap> findAllSecGrant2RoleMap() {
        String hql = "FROM SecGrant2RoleMap as u";

        return (List<SecGrant2RoleMap>) entityManager.createQuery(hql);
    }

    @Override
    public List<SecGrant2RoleMap> findBySEcGrant2RoleMapRoleid(String roleId) {

        Query query = entityManager.createQuery("from SecGrant2RoleMap u where u.secRoleSpr = :roleId");

        query.setParameter("roleId", roleId);

        List<SecGrant2RoleMap> q = query.getResultList();

        return q ;
    }
}
