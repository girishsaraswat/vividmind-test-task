package com.vividmind.db.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Girish Sarashwat
 */
@Entity
public class Role extends TimeStampableModel {
    private String name;
    @OneToMany(fetch= FetchType.EAGER, cascade= {CascadeType.REMOVE}, orphanRemoval=true, mappedBy="role")
    private List<User> users = new ArrayList<User>();

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    /**
     * Getter
     * @return : name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name : name
     */
    public void setName(String name) {
        this.name = name;
    }
}
