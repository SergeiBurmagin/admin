package ru.ugd.service.role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ugd.dao.role.SecRoleSprDao;
import ru.ugd.model.SecRoleSpr;

import java.util.List;

@Service("secRoleSprService")
@Transactional
public class SecRoleSprServiceImpl  implements SecRoleSprService {

    @Autowired
    SecRoleSprDao dao;


    @Override
    public List<SecRoleSpr> findAllSecRoleSpr() {


        return dao.findAllSecRoleSpr();
    }

    @Override
    public List<SecRoleSpr> findBySecRole2SprName(String roleName) {

        return dao.findBySecRole2SprName(roleName);
    }
}
