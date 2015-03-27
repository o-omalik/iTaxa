/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itaxa.beans;

import java.io.Serializable;

/**
 *
 * @author adnankaramat
 */
public class Vogn implements Serializable {

    private Integer vognId;
    private String bevNr;
    private String regNr;
    private String model;
    private String pyear;

    public Vogn() {
    }

    public Vogn(Integer vognId, String bevNr, String regNr, String model, String pyear) {
        this.vognId = vognId;
        this.bevNr = bevNr;
        this.regNr = regNr;
        this.model = model;
        this.pyear = pyear;
    }

    public Integer getVognId() {
        return vognId;
    }

    public void setVognId(Integer vognId) {
        this.vognId = vognId;
    }

    public String getBevNr() {
        return bevNr;
    }

    public void setBevNr(String bevNr) {
        this.bevNr = bevNr;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getRegNr() {
        return regNr;
    }

    public void setRegNr(String regNr) {
        this.regNr = regNr;
    }

    public String getPyear() {
        return pyear;
    }

    public void setPyear(String pyear) {
        this.pyear = pyear;
    }
}
