package ru.ugd.dao.scope;


import ru.ugd.model.SecUser2ScopeMap;

import java.util.List;

public interface SecUser2ScopeMapDao {

    List<SecUser2ScopeMap> findAllSecUser2ScopeMap();

    List<SecUser2ScopeMap> findBySecUser2ScopeMaScopeId (String scopeId);
}
