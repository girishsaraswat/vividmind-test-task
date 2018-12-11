package com.vividmind.util;

import com.vividmind.config.prop.ApplicationProperties;
import com.vividmind.db.model.Role;
import com.vividmind.db.model.User;
import com.vividmind.db.repositories.UserRepository;
import com.vividmind.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Objects;

/**
 * @author Girish Sarashwat
 */
@Component
public class ApplicationUtil {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private RoleService roleService;
    @Autowired
    private ApplicationProperties applicationProperties;


    @PostConstruct
    void createAdminAndUser() {
        User user = userRepository.findOneBy("username",applicationProperties.getUserName1());
        Role role =roleService.findOneBy("name",applicationProperties.getRoleName1());
        if(Objects.isNull(role)){
            Role newRole = new Role();
            newRole.setName(applicationProperties.getRoleName1());
            role =  roleService.save(newRole);
            if(Objects.isNull(user)){
                User newUser = new User();
                newUser.setUsername(applicationProperties.getUserName1());
                newUser.setPassword(passwordEncoder.encode(applicationProperties.getUserPass1()));
                newUser.setRole(role);
                userRepository.save(newUser);
            }
        }
        user = userRepository.findOneBy("username",applicationProperties.getUserName2());
        role =roleService.findOneBy("name",applicationProperties.getRoleName2());
        if(Objects.isNull(role)){
            Role newRole = new Role();
            newRole.setName(applicationProperties.getRoleName2());
            role =  roleService.save(newRole);
            if(Objects.isNull(user)){
                User newUser = new User();
                newUser.setUsername(applicationProperties.getUserName2());
                newUser.setPassword(passwordEncoder.encode(applicationProperties.getUserPass2()));
                newUser.setRole(role);
                userRepository.save(newUser);
            }
        }
    }
}
