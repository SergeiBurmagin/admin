package ru.ugd.service.role;

import ru.ugd.model.SecRoleSpr;

import java.util.List;

public interface SecRoleSprService {

    List<SecRoleSpr> findAllSecRoleSpr();

    List<SecRoleSpr> findBySecRole2SprName(String roleName);
}
