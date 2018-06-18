package ru.ugd.service.auth;

import ru.ugd.model.UserAuth;

import java.util.List;

public interface UserAuthService {

    List<UserAuth> findAllUserAuth();

    List<UserAuth> findByUserAuthLogin(String login);
}
