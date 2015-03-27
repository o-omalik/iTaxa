/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.itaxa.forms;

import com.itaxa.beans.Employee;
import com.itaxa.beans.Vogn;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;


/**
 *
 * @author adnan
 */
public class TrafikbookForm extends ActionForm {
    private String bogId;
    private String date;
    private String hours;
    private String enheder;
    private String tours;
    private String km;
    private String credit;
    private String cash;
    private String diverse;
    private String akonto;
    private String fromDate;
    private String toDate;
    private Employee employee;
    private Vogn vogn;

    public String getBogId() {
        return bogId;
    }

    public void setBogId(String bogId) {
        this.bogId = bogId;
    }

    
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }    
    
    public Vogn getVogn() {
        return vogn;
    }

    public void setVogn(Vogn vogn) {
        this.vogn = vogn;
    }
    
    public String getEnheder() {
        return enheder;
    }

    public void setEnheder(String enheder) {
        this.enheder = enheder;
    }

    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }

    public String getKm() {
        return km;
    }

    public void setKm(String km) {
        this.km = km;
    }

    public String getTours() {
        return tours;
    }
    
    public void setTours(String tours) {
        this.tours = tours;
    }
    public String getAkonto() {
        return akonto;
    }

    public void setAkonto(String akonto) {
        this.akonto = akonto;
    }

    public String getCash() {
        return cash;
    }

    public void setCash(String cash) {
        this.cash = cash;
    }

    public String getCredit() {
        return credit;
    }

    public void setCredit(String credit) {
        this.credit = credit;
    }

    public String getDiverse() {
        return diverse;
    }

    public void setDiverse(String diverse) {
        this.diverse = diverse;
    }

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }


    
       public void reset(ActionMapping actionMapping, HttpServletRequest httpServletRequest) {
           
        employee = new Employee();
        vogn = new Vogn();
        date = null;
        hours = null;
        enheder = null;
        tours = null;
        km = null;
        credit = null;
        cash = null;
        diverse = null;
        akonto = null;
        fromDate=null;
        toDate=null;
    }

}
