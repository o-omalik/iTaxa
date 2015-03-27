/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.itaxa.beans;

import java.io.Serializable;


/**
 *
 * @author adnan
 */
public class SkatteKort implements Serializable {
private Integer id;
private double fradrag;
private double procent;
private String aktivedate;
private String expiredate;
private Employee employee;


public SkatteKort(){}
public SkatteKort(Integer id, double fradrag, double procent, String aktivedate, String expiredate, Employee employee){
    this.id = id;
    this.fradrag = fradrag;
    this.procent = procent; 
    this.aktivedate = aktivedate;
    this.expiredate = expiredate;
    this.employee = employee;
    
}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }



    public String getAktivedate() {
        return aktivedate;
    }

    public void setAktivedate(String aktivedate) {
        this.aktivedate = aktivedate;
    }

    public String getExpiredate() {
        return expiredate;
    }

    public void setExpiredate(String expiredate) {
        this.expiredate = expiredate;
    }

    public double getFradrag() {
        return fradrag;
    }

    public void setFradrag(double fradrag) {
        this.fradrag = fradrag;
    }

    public double getProcent() {
        return procent;
    }

    public void setProcent(double procent) {
        this.procent = procent;
    }
    

}
