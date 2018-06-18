package ru.ugd.service.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ugd.dao.grant.SecGrantSprDao;
import ru.ugd.dao.scope.SecScopeSprDao;
import ru.ugd.dao.users.UsersDao;
import ru.ugd.model.Users;
import ru.ugd.pojo.UserInfoBean;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service("userService")
@Transactional
public class UserServiceImpl  implements UserService {

    @Autowired
    private UsersDao dao;

    @Autowired
    private SecGrantSprDao secGrantSprDao;

    @Autowired
    private SecScopeSprDao secScopeSprDao;

    @Override
    public List<Users> findAllUsers() {
       return dao.findAllUsers();
    }

    @Override
    public Users findByUserName(String name) {

        return dao.findByUserName(name);
    }

    @Override
    public Set findAllGrant(String userId) {

        List list = secGrantSprDao.findGrantUserId(userId);

        List list1 = secScopeSprDao.findScopeGrantId(userId);

        Set<String> newList = (Set<String>) Stream.of(list, list1)
                .flatMap(x -> x.stream())
                .collect(Collectors.toSet());

        return newList;
    }

    @Override
    public UserInfoBean getUserAuthInfo(String name) {
        return dao.getUserAuthInfo(name);
    }
}
