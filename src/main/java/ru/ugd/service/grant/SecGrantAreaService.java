package ru.ugd.service.grant;

import ru.ugd.model.SecGrantArea;

import java.util.List;

public interface SecGrantAreaService {

    List<SecGrantArea> findAllSecGrantArea();

    List<SecGrantArea> findBySEcGrantAreaName(String grantAreaName);

}
