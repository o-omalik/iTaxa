/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.itaxa.forms;

import com.itaxa.beans.Employee;
import com.itaxa.beans.SkatteKort;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author adnan
 */
public class PayslipForm extends ActionForm{
    private String id;    
    private String period;
    private String indkoert;
    private String brutto;
    private String atp;
    private String amBidrag;
    private String aincome;
    private String traek;
    private String askat;
    private String totalPay;
    private Employee employee;
    private SkatteKort skattekort;

    public String getAskat() {
        return askat;
    }

    public void setAskat(String askat) {
        this.askat = askat;
    }

   
    public String getAincome() {
        return aincome;
    }

    public void setAincome(String aincome) {
        this.aincome = aincome;
    }

    public String getAmBidrag() {
        return amBidrag;
    }

    public void setAmBidrag(String amBidrag) {
        this.amBidrag = amBidrag;
    }

    public String getAtp() {
        return atp;
    }

    public void setAtp(String atp) {
        this.atp = atp;
    }

    public String getBrutto() {
        return brutto;
    }

    public void setBrutto(String brutto) {
        this.brutto = brutto;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIndkoert() {
        return indkoert;
    }

    public void setIndkoert(String indkoert) {
        this.indkoert = indkoert;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public SkatteKort getSkattekort() {
        return skattekort;
    }

    public void setSkattekort(SkatteKort skattekort) {
        this.skattekort = skattekort;
    }

    public String getTotalPay() {
        return totalPay;
    }

    public void setTotalPay(String totalPay) {
        this.totalPay = totalPay;
    }

    public String getTraek() {
        return traek;
    }

    public void setTraek(String traek) {
        this.traek = traek;
    }
    public void reset(ActionMapping actionMapping, HttpServletRequest httpServletRequest) {
        employee = new Employee();
        skattekort = new SkatteKort();
    }
}
