package com.vividmind.db.repositories.impl;

import com.vividmind.db.model.User;
import com.vividmind.db.repositories.UserRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Girish Sarashwat
 */
@Repository
public class UserRepositoryImpl extends BaseRepository<User> implements UserRepository {

    public UserRepositoryImpl() {
        super(User.class);
    }
}
