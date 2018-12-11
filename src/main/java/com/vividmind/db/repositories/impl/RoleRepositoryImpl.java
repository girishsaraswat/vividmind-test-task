package com.vividmind.db.repositories.impl;

import com.vividmind.db.model.Role;
import com.vividmind.db.repositories.RoleRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Girish Sarashwat
 */
@Repository
public class RoleRepositoryImpl extends BaseRepository<Role> implements RoleRepository {

    public RoleRepositoryImpl() {
        super(Role.class);
    }
}
