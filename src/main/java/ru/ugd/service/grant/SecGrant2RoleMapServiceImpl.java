package ru.ugd.service.grant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ugd.dao.grant.SecGrant2RoleMapDao;
import ru.ugd.model.SecGrant2RoleMap;

import java.util.List;


@Service("secGrant2RoleMapService")
@Transactional
public class SecGrant2RoleMapServiceImpl implements SecGrant2RoleMapService {

    @Autowired
    SecGrant2RoleMapDao dao;

    @Override
    public List<SecGrant2RoleMap> findAllSecGrant2RoleMap() {

        return dao.findAllSecGrant2RoleMap();
    }

    @Override
    public List<SecGrant2RoleMap> findBySEcGrant2RoleMapRoleid(String roleId) {

        return dao.findBySEcGrant2RoleMapRoleid(roleId);
    }
}
