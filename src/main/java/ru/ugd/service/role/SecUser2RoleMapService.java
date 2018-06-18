package ru.ugd.service.role;

import ru.ugd.model.SecUser2RoleMap;

import java.util.List;

public interface SecUser2RoleMapService {

    List<SecUser2RoleMap> findAllSecUser2RoleMap();

    List<SecUser2RoleMap> findBySecUser2RoleMapId(String roleId);

}
