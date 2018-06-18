package ru.ugd.service.auth;

import ru.ugd.model.UserAuthTypeSpr;

import java.util.List;

public interface UserAuthTypeSprService {

    List<UserAuthTypeSpr> findAllUserAuthTypeSpr();

    List<UserAuthTypeSpr> findByUserAuthTypeSprName(String authName);
}
