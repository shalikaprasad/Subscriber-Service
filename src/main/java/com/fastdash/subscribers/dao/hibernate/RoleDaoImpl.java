package com.fastdash.subscribers.dao.hibernate;

import com.fastdash.subscribers.dao.RoleDao;
import com.fastdash.subscribers.models.Roles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Prasad on 12/15/19.
 */

@Repository("roleDao")
@Transactional
public class RoleDaoImpl extends CRUDDaoImpl<Roles> implements RoleDao {

    private final static Logger logger = LoggerFactory.getLogger(RoleDaoImpl.class);

    @Override
    public Roles findByRoleNme(String name) {
        return (Roles) entityManager.createNamedQuery(Roles.GET_ROLE_BY_ROLE_NAME)
                .setParameter("name", name)
                .getSingleResult();
    }




}
