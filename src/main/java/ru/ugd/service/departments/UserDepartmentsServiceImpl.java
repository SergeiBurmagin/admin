package ru.ugd.service.departments;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ugd.dao.departments.UserDepartmentsDao;
import ru.ugd.model.UserDepartments;

import java.util.List;


@Service("userDepartmentsService")
@Transactional
public class UserDepartmentsServiceImpl  implements UserDepartmentsService {

    @Autowired
    private UserDepartmentsDao dao;

    @Override
    public List<UserDepartments> findAllUserDep() {
        return dao.findAllUserDep();
    }

    @Override
    public List<UserDepartments> findByUserDepName(String departmentName) {


        return dao.findByUserDepName(departmentName);
    }
}
