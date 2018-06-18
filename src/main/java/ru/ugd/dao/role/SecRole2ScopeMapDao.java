package ru.ugd.dao.role;

import ru.ugd.model.SecRole2ScopeMap;

import java.util.List;

public interface SecRole2ScopeMapDao {

    List<SecRole2ScopeMap> findAllSecRole2ScopeMap();

    List<SecRole2ScopeMap> findBySecRole2ScopeId(String roleId);
}
