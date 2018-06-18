package ru.ugd.service.scope;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ugd.dao.scope.SecScopeSprDao;
import ru.ugd.model.SecScopeSpr;

import java.util.List;

@Service("secScopeSprService")
@Transactional
public class SecScopeSprServiceImpl  implements SecScopeSprService {

    @Autowired
    private SecScopeSprDao dao;

    @Override
    public List<SecScopeSpr> findAllSecScopeSpr() {

        return dao.findAllSecScopeSpr();
    }

    @Override
    public List<SecScopeSpr> findBySecScopeSprScopeId(String scopeId) {

        return dao.findBySecScopeSprScopeId(scopeId);
    }

    @Override
    public List<SecScopeSpr> findScopeGrantId(String userId) {

        return dao.findScopeGrantId(userId);
    }
}
