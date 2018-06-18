package ru.ugd.service.grant;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ugd.dao.grant.SecGrantSprDao;
import ru.ugd.model.SecGrantSpr;

import java.util.List;

@Service("secGrantSprService")
@Transactional
public class SecGrantSprServiceImpl  implements SecGrantSprService {

    @Autowired
    private SecGrantSprDao dao;

    @Override
    public List<SecGrantSpr> findAllSecGrantSpr() {

        return dao.findAllSecGrantSpr();
    }

    @Override
    public List<SecGrantSpr> findBySEcGrantSprName(String grantName) {

        return dao.findBySEcGrantSprName(grantName);
    }

    @Override
    public List findGrantUserId(String userId) {

        return dao.findGrantUserId(userId);
    }
}
