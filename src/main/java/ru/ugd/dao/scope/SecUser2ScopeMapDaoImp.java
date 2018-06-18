package ru.ugd.dao.scope;


import org.springframework.stereotype.Repository;
import ru.ugd.dao.AbstractDao;
import ru.ugd.model.SecUser2ScopeMap;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository("secUser2ScopeMapDao")
public class SecUser2ScopeMapDaoImp extends AbstractDao implements SecUser2ScopeMapDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<SecUser2ScopeMap> findAllSecUser2ScopeMap() {

        String hql = "FROM SecGrantSpr as u";

        return (List<SecUser2ScopeMap>) entityManager.createQuery(hql);
    }

    @Override
    public List<SecUser2ScopeMap> findBySecUser2ScopeMaScopeId(String scopeId) {

        Query query = entityManager.createQuery("from SecScopeSpr s where s.scopeId = :scopeId");

        query.setParameter("scopeId", scopeId);

        return (List<SecUser2ScopeMap> )query.getResultList();
    }
}
