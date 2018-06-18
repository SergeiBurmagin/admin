package ru.ugd.service.grant;

import ru.ugd.model.SecGrant2RoleMap;

import java.util.List;

public interface SecGrant2RoleMapService {

    List<SecGrant2RoleMap> findAllSecGrant2RoleMap();

    List<SecGrant2RoleMap> findBySEcGrant2RoleMapRoleid(String roleId);
}
