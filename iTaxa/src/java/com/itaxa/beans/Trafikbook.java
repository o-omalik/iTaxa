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
public class Trafikbook implements Serializable {
   
    private Integer bogId;
    private String date = null;
    private double hours = 0;
    private double enheder = 0;
    private double tours = 0;
    private double km = 0;
    private double credit = 0;
    private double cash = 0;
    private double diverse = 0;
    private double akonto = 0;
    private String fromDate="";
    private String toDate="";
    private Employee employee = null;
    private Vogn vogn = null;
    
    
    
    public Trafikbook(){
    }

    public Trafikbook(Integer bogId, String date, double hours, double enheder, double tours, double km, double credit, 
                        double cash, double diverse, double akonto, Employee employee, Vogn vogn){
        this.bogId = bogId;
        this.date = date;
        this.hours = hours;
        this.enheder = enheder;
        this.tours = tours;
        this.km = km;
        this.credit = credit;
        this.cash = cash;
        this.diverse = diverse;
        this.akonto = akonto;
        this.employee = employee;
        this.vogn = vogn;
        
    }
    public Integer getBogId() {
        return bogId;
    }

    public void setBogId(Integer bogId) {
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
    
    public double getEnheder() {
        return enheder;
    }

    public void setEnheder(double enheder) {
        this.enheder = enheder;
    }

    public double getHours() {
        return hours;
    }

    public void setHours(double hours) {
        this.hours = hours;
    }

    public double getKm() {
        return km;
    }

    public void setKm(double km) {
        this.km = km;
    }

    public double getTours() {
        return tours;
    }

    public void setTours(double tours) {
        this.tours = tours;
    }

    public double getAkonto() {
        return akonto;
    }

    public void setAkonto(double akonto) {
        this.akonto = akonto;
    }

    public double getCash() {
        return cash;
    }

    public void setCash(double cash) {
        this.cash = cash;
    }

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    public double getDiverse() {
        return diverse;
    }

    public void setDiverse(double diverse) {
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
        
    

        
}
