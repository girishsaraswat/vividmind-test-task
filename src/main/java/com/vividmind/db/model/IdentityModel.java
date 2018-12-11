package com.vividmind.db.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

/**
 * @author Girish Sarashwat
 */
@MappedSuperclass
public class IdentityModel implements Serializable {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Integer id;

    /**
     * Getter
     * @return : id
     */
    public Integer getId() {
        return id;
    }

    /**
     * Setter
     * @param id : id
     */
    public void setId(Integer id) {
        this.id = id;
    }
}
