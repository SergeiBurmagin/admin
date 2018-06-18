package ru.ugd.dao.auth;

import ru.ugd.model.UserAuthTypeSpr;

import java.util.List;

public interface UserAuthTypeSprDao {

    List<UserAuthTypeSpr> findAllUserAuthTypeSpr();

    List<UserAuthTypeSpr> findByUserAuthTypeSprName(String authName);
}
