package com.fastdash.subscribers.dao.hibernate;

import com.fastdash.subscribers.dao.UserDao;
import com.fastdash.subscribers.models.Users;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Prasad on 12/15/19.
 */

@Repository("userDao")
@Transactional
public class UserDaoImpl extends CRUDDaoImpl<Users> implements UserDao {

    private final static Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);

    @Override
    public Users findByUsername(String userName) {
        return (Users) entityManager.createNamedQuery(Users.GET_USER_BY_USER_NAME)
                .setParameter("userName", userName)
                .getSingleResult();
    }

    @Override
    public List<Users> getUserList() {
        return (List<Users>) entityManager.createNamedQuery(Users.GET_ALL_USERS)
                .getResultList();
    }



}
