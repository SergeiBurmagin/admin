package ru.ugd.dao.auth;

import ru.ugd.model.UserAuth;

import java.util.List;

public interface UserAuthDao {

    List<UserAuth> findAllUserAuth();

    List<UserAuth> findByUserAuthLogin(String login);
}
