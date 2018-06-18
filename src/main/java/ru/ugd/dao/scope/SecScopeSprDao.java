package ru.ugd.dao.scope;


import ru.ugd.model.SecScopeSpr;

import java.util.List;

public interface SecScopeSprDao {

    List<SecScopeSpr> findAllSecScopeSpr();

    List<SecScopeSpr> findBySecScopeSprScopeId (String scopeId);

    List<SecScopeSpr> findScopeGrantId (String userId);
}
