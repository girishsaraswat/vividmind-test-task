package com.vividmind.db.model;

import javax.persistence.*;

/**
 * @author Girish Sarashwat
 */
@Entity
public class Tour extends TimeStampableModel{
    private String name;
    @Column(columnDefinition="TEXT")
    private String longDesc;

    private int tourId;

    /**
     * Getter
     * @return : name
     */
    public String getName() {
        return name;
    }

    /**
     * Setter
     * @param name : name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter
     * @return : longDec
     */
    public String getLongDesc() {
        return longDesc;
    }

    /**
     * Setter
     * @param longDesc : longDesc
     */
    public void setLongDesc(String longDesc) {
        this.longDesc = longDesc;
    }

    /**
     * Getter
     * @return : tourId
     */
    public int getTourId() {
        return tourId;
    }

    /**
     * Setter
     * @param tourId : tourId
     */
    public void setTourId(int tourId) {
        this.tourId = tourId;
    }
}
