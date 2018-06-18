package ru.ugd.dao.role;

import ru.ugd.model.SecRoleSpr;

import java.util.List;

public interface SecRoleSprDao {

    List<SecRoleSpr> findAllSecRoleSpr();

    List<SecRoleSpr> findBySecRole2SprName(String roleName);
}
