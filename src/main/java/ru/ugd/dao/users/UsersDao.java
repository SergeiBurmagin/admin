package ru.ugd.dao.users;

import ru.ugd.model.Users;
import ru.ugd.pojo.UserInfoBean;

import java.util.List;
import java.util.Set;

public interface UsersDao {

       List<Users> findAllUsers();

       Users findByUserName(String name);

       UserInfoBean getUserAuthInfo(String name);
}
