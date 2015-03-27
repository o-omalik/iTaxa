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
public class Payslip implements Serializable {
    private Integer id;    
    private Integer period;
    private double indkoert = 0.0;
    private double brutto = 0.0;
    private double atp = 81.50;
    private int amBidrag = 0;
    private int aincome = 0;
    private int traek = 0;
    private int askat = 0;
    private int totalPay = 0;
    private Employee employee;
    private SkatteKort skattekort;
    
    public Payslip(){}
    public Payslip(Integer id, Integer period, double indkoert, double brutto, double atp, int amBidrag,
                     int aincome, int traek, int askat, int totalPay, Employee employee, SkatteKort skattekort){
        this.id = id;
        this.period = period;
        this.indkoert = indkoert;
        this.brutto = brutto;
        this.atp = atp;
        this.amBidrag = amBidrag;
        this.aincome = aincome;
        this.traek = traek;
        this.askat = askat;
        this.totalPay = totalPay;
        this.employee = employee;
        this.skattekort = skattekort;  
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
     public double getIndkoert() {        
        return indkoert/2;
    }

    public void setIndkoert(double indkoert) {
        this.indkoert = indkoert;
    }
    
    public double getBrutto() {
        brutto =  getIndkoert() - getAtp();
        return brutto;
    }

    public void setBrutto(int brutto) {
        this.brutto = brutto;
    }
     public double getAincome() {
         aincome = (int) (getBrutto() - getAmBidrag());
        return aincome;
    }

    public void setAincome(int aincome) {
        this.aincome = aincome;
    }

    public int getTraek() {
        if(getAincome() <= getSkattekort().getFradrag()){
        traek = 0;
        }else{
        traek = (int) (getAincome() - getSkattekort().getFradrag());
        }
        return traek;
    }

    public void setTraek(int traek) {
        this.traek = traek;
    }
    
    public int getAmBidrag() {
        amBidrag = (int) ((8.0 * getBrutto()) / 100);
        return amBidrag;
    }

    public void setAmBidrag(int amBidrag) {
        this.amBidrag = amBidrag;
    }

    public double getAtp() {
        return atp = 81.50;
    }

    public void setAtp(double atp) {
        this.atp = atp;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

   

    public Integer getPeriod() {
        return period;
    }

    public void setPeriod(Integer period) {
        this.period = period;
    }


    public SkatteKort getSkattekort() {
        return skattekort;
    }

    public void setSkattekort(SkatteKort skattekort) {
        this.skattekort = skattekort;
    }

    public int getTotalPay() {
        totalPay = (int) getAincome() - getAskat();
        return totalPay;
    }

    public void setTotalPay(int totalPay) {
        this.totalPay = totalPay;
    }


    public int getAskat() {
        askat =  (int) ((getSkattekort().getProcent() * getTraek()) / 100);
        return askat;
    }

    public void setAskat(int askat) {
        this.askat = askat;
    }
       
}
