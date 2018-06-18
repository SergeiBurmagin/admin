package ru.ugd.dao.grant;

import ru.ugd.model.SecGrantSpr;

import java.util.List;

public interface SecGrantSprDao {

    List<SecGrantSpr> findAllSecGrantSpr();

    List<SecGrantSpr> findBySEcGrantSprName(String grantName);

    List findGrantUserId(String userId);
}
