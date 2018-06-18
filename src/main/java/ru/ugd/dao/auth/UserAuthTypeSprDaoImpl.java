package ru.ugd.dao.auth;


import org.springframework.stereotype.Repository;
import ru.ugd.dao.AbstractDao;
import ru.ugd.model.UserAuthTypeSpr;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository("UserAuthTypeSprDao")
public class UserAuthTypeSprDaoImpl extends AbstractDao  implements UserAuthTypeSprDao {


    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<UserAuthTypeSpr> findAllUserAuthTypeSpr() {
        String hql = "FROM UserAuthTypeSpr as u";

        return (List<UserAuthTypeSpr>) entityManager.createQuery(hql);
    }

    @Override
    public List<UserAuthTypeSpr> findByUserAuthTypeSprName(String authName) {

        Query query = entityManager.createQuery("from UserAuthTypeSpr u where u.auth_name = :auth_name");

        query.setParameter("auth_name", authName);

        List<UserAuthTypeSpr> q = query.getResultList();

        return q ;
    }
}
