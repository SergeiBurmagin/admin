package ru.ugd.service.auth;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ugd.dao.auth.UserAuthTypeSprDao;
import ru.ugd.model.UserAuthTypeSpr;

import java.util.List;

@Service("userAuthTypeSprService")
@Transactional
public class UserAuthTypeSprServiceImpl  implements UserAuthTypeSprService {

    @Autowired
    private UserAuthTypeSprDao dao;


    @Override
    public List<UserAuthTypeSpr> findAllUserAuthTypeSpr() {

        return dao.findAllUserAuthTypeSpr();
    }

    @Override
    public List<UserAuthTypeSpr> findByUserAuthTypeSprName(String authName) {

        return dao.findByUserAuthTypeSprName(authName);
    }
}
