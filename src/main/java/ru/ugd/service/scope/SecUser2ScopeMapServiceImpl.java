package ru.ugd.service.scope;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ugd.dao.scope.SecUser2ScopeMapDao;
import ru.ugd.model.SecUser2ScopeMap;


import java.util.List;


@Service("secUser2ScopeMapService")
@Transactional
public class SecUser2ScopeMapServiceImpl  implements SecUser2ScopeMapService {

    @Autowired
    SecUser2ScopeMapDao dao;


    @Override
    public List<SecUser2ScopeMap> findAllSecUser2ScopeMap() {


        return dao.findAllSecUser2ScopeMap();
    }

    @Override
    public List<SecUser2ScopeMap> findBySecUser2ScopeMaScopeId(String scopeId) {


        return dao.findBySecUser2ScopeMaScopeId(scopeId);
    }
}
