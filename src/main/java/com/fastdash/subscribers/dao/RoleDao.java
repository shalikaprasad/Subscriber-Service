package com.fastdash.subscribers.dao;

import com.fastdash.subscribers.models.Roles;
import org.springframework.stereotype.Component;

/**
 * Created by Prasad on 12/15/19.
 */

@Component
public interface RoleDao extends CRUDDao<Roles> {

    Roles findByRoleNme(String name);

}
