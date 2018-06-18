package ru.ugd.service.departments;

import ru.ugd.model.UserDepartments;

import java.util.List;

public interface UserDepartmentsService {

    List<UserDepartments> findAllUserDep();

    List<UserDepartments> findByUserDepName(String departmentName);
}
