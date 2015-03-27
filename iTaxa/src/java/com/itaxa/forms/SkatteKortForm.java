/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.itaxa.forms;

import com.itaxa.beans.Employee;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author adnan
 */
public class SkatteKortForm extends ActionForm {
private String id;
private String fradrag;
private String procent;
private String aktivedate;
private String expiredate;
private Employee employee;

    public String getAktivedate() {
        return aktivedate;
    }

    public void setAktivedate(String aktivedate) {
        this.aktivedate = aktivedate;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getExpiredate() {
        return expiredate;
    }

    public void setExpiredate(String expiredate) {
        this.expiredate = expiredate;
    }

    public String getFradrag() {
        return fradrag;
    }

    public void setFradrag(String fradrag) {
        this.fradrag = fradrag;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProcent() {
        return procent;
    }

    public void setProcent(String procent) {
        this.procent = procent;
    }

     public void reset(ActionMapping actionMapping, HttpServletRequest httpServletRequest) {
        employee = new Employee();
       
    }
}
