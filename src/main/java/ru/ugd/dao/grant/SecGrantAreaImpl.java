package ru.ugd.dao.grant;

import org.springframework.stereotype.Repository;
import ru.ugd.dao.AbstractDao;
import ru.ugd.model.SecGrantArea;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;


@Repository("SecGrantAreaDao")
public class SecGrantAreaImpl extends AbstractDao implements SecGrantAreaDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<SecGrantArea> findAllSecGrantArea() {

        String hql = "FROM SecGrantArea as u";

        return (List<SecGrantArea>) entityManager.createQuery(hql);
    }

    @Override
    public List<SecGrantArea> findBySEcGrantAreaName(String grantAreaName) {


        Query query = entityManager.createQuery("from SecGrantArea u where u.grantAreaName = :grantAreaName");

        query.setParameter("grantAreaName", grantAreaName);

        List<SecGrantArea> q = query.getResultList();

        return q ;
    }
}
