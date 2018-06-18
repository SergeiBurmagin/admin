package ru.ugd.dao.role;

import ru.ugd.model.SecUser2RoleMap;

import java.util.List;

public interface SecUser2RoleMapDao {

    List<SecUser2RoleMap> findAllSecUser2RoleMap();

    List<SecUser2RoleMap> findBySecUser2RoleMapId(String roleId);
}
