package ru.ugd.dao.departments;

import ru.ugd.model.UserDepartments;

import java.util.List;

public interface UserDepartmentsDao {

    List<UserDepartments> findAllUserDep();

    List<UserDepartments> findByUserDepName(String departmentName);
}
