package ru.ugd.service.grant;

import ru.ugd.model.SecGrantSpr;

import java.util.List;

public interface SecGrantSprService {

    List<SecGrantSpr> findAllSecGrantSpr();

    List<SecGrantSpr> findBySEcGrantSprName(String grantName);

    List findGrantUserId(String userId);


}
