package ru.ugd.service.role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ugd.dao.role.SecRole2ScopeMapDao;
import ru.ugd.model.SecRole2ScopeMap;

import java.util.List;

@Service("secRole2ScopeMapService")
@Transactional
public class SecRole2ScopeMapServiceImpl implements  SecRole2ScopeMapService {

    @Autowired
    private SecRole2ScopeMapDao dao;

    @Override
    public List<SecRole2ScopeMap> findAllSecRole2ScopeMap() {

        return dao.findAllSecRole2ScopeMap();
    }

    @Override
    public List<SecRole2ScopeMap> findBySecRole2ScopeId(String roleId) {

        return dao.findBySecRole2ScopeId(roleId);
    }
}
