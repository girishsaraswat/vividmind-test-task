package com.vividmind.db.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @author Girish Sarashwat
 */
@Entity
public class User extends TimeStampableModel {
    private String username;
    private String password;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="role_id", columnDefinition="BIGINT(20)", nullable=false)
    private Role role;


    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
    /**
     * Getter
     * @return : username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Setter
     * @param username : username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Getter
     * @return : password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Setter
     * @param password : password
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
