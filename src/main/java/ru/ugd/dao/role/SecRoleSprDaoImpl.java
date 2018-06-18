package ru.ugd.dao.role;

import org.springframework.stereotype.Repository;
import ru.ugd.dao.AbstractDao;
import ru.ugd.model.SecRoleSpr;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository("secRoleSprDao")
public class SecRoleSprDaoImpl extends AbstractDao implements SecRoleSprDao {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<SecRoleSpr> findAllSecRoleSpr() {

        String hql = "FROM SecRoleSpr as u";

        return (List<SecRoleSpr>) entityManager.createQuery(hql);

    }

    @Override
    public List<SecRoleSpr> findBySecRole2SprName(String roleName) {


        Query query = entityManager.createQuery("from SecRoleSpr u where u.roleName = :roleName");

        query.setParameter("roleName", roleName);

        List<SecRoleSpr> q = query.getResultList();

        return q;
    }
}
