package ru.ugd.service.role;

import ru.ugd.model.SecRole2ScopeMap;

import java.util.List;

public interface SecRole2ScopeMapService {

    List<SecRole2ScopeMap> findAllSecRole2ScopeMap();

    List<SecRole2ScopeMap> findBySecRole2ScopeId(String roleId);
}
