package ru.ugd.service.grant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ugd.dao.grant.SecGrantAreaDao;
import ru.ugd.model.SecGrantArea;

import java.util.List;

@Service("secGrantAreaService")
@Transactional
public class SecGrantAreaServiceImpl implements SecGrantAreaService {

    @Autowired
    private SecGrantAreaDao dao;

    @Override
    public List<SecGrantArea> findAllSecGrantArea() {

        return dao.findAllSecGrantArea();
    }

    @Override
    public List<SecGrantArea> findBySEcGrantAreaName(String grantAreaName) {

        return dao.findBySEcGrantAreaName(grantAreaName);
    }
}
