package ru.ugd.service.role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ugd.dao.role.SecUser2RoleMapDao;
import ru.ugd.model.SecUser2RoleMap;

import java.util.List;

@Service("secUser2RoleMapService")
@Transactional
public class SecUser2RoleMapServiceImpl implements SecUser2RoleMapService{

    @Autowired
    SecUser2RoleMapDao dao;


    @Override
    public List<SecUser2RoleMap> findAllSecUser2RoleMap() {

        return dao.findAllSecUser2RoleMap();
    }

    @Override
    public List<SecUser2RoleMap> findBySecUser2RoleMapId(String roleId) {

        return dao.findBySecUser2RoleMapId(roleId);
    }
}
