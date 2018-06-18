package ru.ugd.dao.departments;

import org.springframework.stereotype.Repository;
import ru.ugd.dao.AbstractDao;
import ru.ugd.model.UserDepartments;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;


@Repository("UserDepartmentsDao")
public class UserDepartmentsDaoImpl  extends AbstractDao implements UserDepartmentsDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<UserDepartments> findAllUserDep() {
        String hql = "FROM UserDepartments as u";

        return (List<UserDepartments>) entityManager.createQuery(hql);
    }

    @Override
    public List<UserDepartments> findByUserDepName(String departmentName) {

        Query query = entityManager.createQuery("from UserDepartments u where u.departmentName = :departmentName");

        query.setParameter("departmentName", departmentName);

        List<UserDepartments> q = query.getResultList();

        return q ;
    }
}
