package ru.ugd.dao.auth;


import org.springframework.stereotype.Repository;
import ru.ugd.dao.AbstractDao;
import ru.ugd.model.UserAuth;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository("userAuthDao")
public class UserAuthDaoImpl  extends AbstractDao implements UserAuthDao {


    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<UserAuth> findAllUserAuth() {
        String hql = "FROM UserAuth as u";

        return (List<UserAuth>) entityManager.createQuery(hql);
    }

    @Override
    public List<UserAuth> findByUserAuthLogin(String login) {

        Query query = entityManager.createQuery("from UserAuth u where u.login = :login");

        query.setParameter("login",login);

        List<UserAuth> q = query.getResultList();

        return q;
    }
}
