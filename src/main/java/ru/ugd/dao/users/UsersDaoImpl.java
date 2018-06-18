package ru.ugd.dao.users;

import org.springframework.stereotype.Repository;
import ru.ugd.dao.AbstractDao;
import ru.ugd.model.UserAuth;
import ru.ugd.model.UserDepartments;
import ru.ugd.model.Users;
import ru.ugd.pojo.UserInfoBean;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.List;

@Repository("UsersDao")
public class UsersDaoImpl extends AbstractDao implements UsersDao {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<Users> findAllUsers() {

        String hql = "FROM Users as u";

        return (List<Users>) entityManager.createQuery(hql).getResultList();
    }

    @Override
    public Users findByUserName(String name) {


        Query query = entityManager.createQuery("from Users  u where u.name = :name");

        query.setParameter("name",name);

     return (Users) query.getSingleResult();

    }

    @Override
    public UserInfoBean getUserAuthInfo(String name) {

        CriteriaBuilder criteriaBuilder  = entityManager.getCriteriaBuilder();

        final CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(UserInfoBean.class); //POJO

        final Root secGrantSpr = criteriaQuery.from(Users.class);

        final Join<Users,UserAuth> userAuthUsersJoin = secGrantSpr.join("userAuths", JoinType.INNER);

        final Join<Users,UserDepartments> usersUserDepartmentsJoin = secGrantSpr.join("depId", JoinType.INNER);

        criteriaQuery.multiselect(secGrantSpr.get("family"),secGrantSpr.get("name"),secGrantSpr.get("patronymic"),usersUserDepartmentsJoin.get("departmentName")).where(criteriaBuilder.equal(userAuthUsersJoin.get("login"),name)).distinct(true);



        final TypedQuery query = entityManager.createQuery(criteriaQuery);

        return (UserInfoBean) query.getSingleResult();
    }
}
