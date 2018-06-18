package ru.ugd.service.users;

import ru.ugd.model.Users;
import ru.ugd.pojo.UserInfoBean;

import java.util.List;
import java.util.Set;

public interface UserService {

    List<Users> findAllUsers();

    Users findByUserName(String name);

    Set findAllGrant(String userId);

    UserInfoBean getUserAuthInfo(String name);

}
