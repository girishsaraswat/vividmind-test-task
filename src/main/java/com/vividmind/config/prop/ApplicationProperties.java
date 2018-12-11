package com.vividmind.config.prop;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author Girish Sarashwat
 */
@Component
public class ApplicationProperties {
    @Value("${api.url}")
    private String apiURL;

    @Value("${role1.name}")
    private String roleName1;
    @Value("${role2.name}")
    private String roleName2;

    @Value("${user1.name}")
    private String userName1;
    @Value("${user1.pass}")
    private String userPass1;
    @Value("${user2.name}")
    private String userName2;
    @Value("${user2.pass}")
    private String userPass2;
    public String getApiURL() {
        return apiURL;
    }

    public String getRoleName1() {
        return roleName1;
    }


    public String getRoleName2() {
        return roleName2;
    }


    public String getUserName1() {
        return userName1;
    }


    public String getUserPass1() {
        return userPass1;
    }


    public String getUserName2() {
        return userName2;
    }


    public String getUserPass2() {
        return userPass2;
    }


}
