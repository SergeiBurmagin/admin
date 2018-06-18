package ru.ugd.dao.grant;


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



@Repository("secGrantSprDao")
public class SecGrantSprDaoImpl extends AbstractDao implements SecGrantSprDao {


    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<SecGrantSpr> findAllSecGrantSpr() {

        String hql = "FROM SecGrantSpr as u";

        return (List<SecGrantSpr>) entityManager.createQuery(hql);
    }

    @Override
    public List<SecGrantSpr> findBySEcGrantSprName(String grantName) {


        Query query = entityManager.createQuery("from SecGrantSpr u where u.grantName = :grantName");

        query.setParameter("grantName", grantName);

       return (List<SecGrantSpr> )query.getResultList();


    }



    @Override
    public List findGrantUserId(String userId) {

        CriteriaBuilder criteriaBuilder  = entityManager.getCriteriaBuilder();

        final CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(SecGrantSprVO.class); //POJO

        final Root secGrantSpr = criteriaQuery.from(SecGrantSpr.class);

        final  Join<SecGrantSpr,SecGrant2RoleMap> secGrantSprSecGrant2RoleMapJoin = secGrantSpr.join("secGrant2RoleMaps", JoinType.INNER);

        final Join<SecGrant2RoleMap,SecRoleSpr> secGrant2RoleMapSecRoleSprJoin = secGrantSprSecGrant2RoleMapJoin.join("secRoleSpr",JoinType.INNER);

        final Join<SecRoleSpr,SecUser2RoleMap> secRoleSprSecUser2RoleMapJoin = secGrant2RoleMapSecRoleSprJoin.join("secUser2RoleMaps",JoinType.INNER);

        final Join<SecUser2RoleMap,Users> secUser2RoleMapUsersJoin = secRoleSprSecUser2RoleMapJoin.join("users",JoinType.INNER);

        criteriaQuery.select(secGrantSpr.get("grantId")).where(criteriaBuilder.equal(secUser2RoleMapUsersJoin.get("userId"),userId)).distinct(true);



        final TypedQuery query = entityManager.createQuery(criteriaQuery);

        return query.getResultList();
    }



}
