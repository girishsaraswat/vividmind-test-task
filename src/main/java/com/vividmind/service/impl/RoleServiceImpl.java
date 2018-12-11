package com.vividmind.service.impl;

import com.vividmind.db.model.Role;
import com.vividmind.db.repositories.impl.BaseRepository;
import com.vividmind.service.RoleService;
import org.springframework.stereotype.Service;

/**
 * @author  Girish Sarashwat
 */
@Service
public class RoleServiceImpl extends BaseRepository<Role> implements RoleService {

    public RoleServiceImpl() {
        super(Role.class);
    }
}
