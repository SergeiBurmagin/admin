package ru.ugd.service.auth;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ugd.dao.auth.UserAuthDao;
import ru.ugd.model.UserAuth;

import java.util.List;

@Service("userAuthService")
@Transactional
public class UserAuthServiceImpl implements  UserAuthService {

    @Autowired
    private UserAuthDao dao;


    @Override
    public List<UserAuth> findAllUserAuth() {
        return dao.findAllUserAuth();
    }

    @Override
    public List<UserAuth> findByUserAuthLogin(String login) {
        return dao.findByUserAuthLogin(login);
    }
}
