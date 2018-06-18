package ru.ugd.dao.grant;

import ru.ugd.model.SecGrantArea;

import java.util.List;

public interface SecGrantAreaDao {

    List<SecGrantArea> findAllSecGrantArea();

    List<SecGrantArea> findBySEcGrantAreaName(String grantAreaName);
}
