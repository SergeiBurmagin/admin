package ru.ugd.dao.scope;


import org.springframework.stereotype.Repository;
import ru.ugd.dao.AbstractDao;
import ru.ugd.model.*;
import ru.ugd.pojo.SecGrantSprVO;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.List;

@Repository("secScopeSprDao")
public class SecScopeSprDaoImpl extends AbstractDao implements SecScopeSprDao{

    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<SecScopeSpr> findAllSecScopeSpr() {

        String hql = "FROM SecScopeSpr as u";

        return (List<SecScopeSpr>) entityManager.createQuery(hql);
    }

    @Override
    public List<SecScopeSpr> findBySecScopeSprScopeId(String scopeId) {

        Query query = entityManager.createQuery("from SecScopeSpr s where s.scopeId = :scopeId");

        query.setParameter("scopeId", scopeId);

        return (List<SecScopeSpr> )query.getResultList();
    }

    @Override
    public List<SecScopeSpr> findScopeGrantId(String userId) {

        CriteriaBuilder criteriaBuilder  = entityManager.getCriteriaBuilder();

        final CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(SecGrantSprVO.class); //POJO

        final Root secGrantSpr = criteriaQuery.from(SecGrantSpr.class);

        final Join<SecGrantSpr,SecGrant2RoleMap> secGrantSprSecGrant2RoleMapJoin = secGrantSpr.join("secGrant2RoleMaps", JoinType.INNER);

        final Join<SecGrant2RoleMap,SecRoleSpr> secGrant2RoleMapSecRoleSprJoin = secGrantSprSecGrant2RoleMapJoin.join("secRoleSpr",JoinType.INNER);

        final Join<SecRoleSpr,SecRole2ScopeMap> secRoleSprSecRole2ScopeMapJoin = secGrant2RoleMapSecRoleSprJoin.join("secRole2ScopeMaps",JoinType.INNER);

        final Join<SecRole2ScopeMap,SecScopeSpr> secRole2ScopeMapSecScopeSprJoin = secRoleSprSecRole2ScopeMapJoin.join("secScopeSpr",JoinType.INNER);

        final Join<SecScopeSpr,SecUser2ScopeMap> secScopeSprSecUser2ScopeMapJoin = secRole2ScopeMapSecScopeSprJoin.join("secUser2ScopeMaps",JoinType.INNER);

        final Join<SecUser2ScopeMap,Users> secUser2ScopeMapUsersJoin = secScopeSprSecUser2ScopeMapJoin.join("users",JoinType.INNER);

        criteriaQuery.select(secGrantSpr.get("grantId")).where(criteriaBuilder.equal(secUser2ScopeMapUsersJoin.get("userId"),userId)).distinct(true);


        final TypedQuery query = entityManager.createQuery(criteriaQuery);

        return query.getResultList();
    }


}
