package ru.ugd.service.scope;

import ru.ugd.model.SecScopeSpr;

import java.util.List;

public interface SecScopeSprService {

    List<SecScopeSpr> findAllSecScopeSpr();

    List<SecScopeSpr> findBySecScopeSprScopeId (String scopeId);

    List<SecScopeSpr> findScopeGrantId (String userId);
}
