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
public class Employee implements Serializable {

    private Integer employeeId;
    private String name;
    private String street;
    private String city;
    private String post;
    private String phone;
    private String cprNr;
    private String licNr;
    private String password;
    private String role;

    public Employee(){}
    
    public Employee(String username, String password, String role) {
        this.cprNr=username;
        this.password=password;
        this.role=role;
    }

    public Employee(Integer employeeId, String name, String street, String city, String post, String phone, String cprNr, String licNr, String password, String role) {
        this.employeeId = employeeId;
        this.name = name;
        this.street = street;
        this.city = city;
        this.post = post;
        this.phone = phone;
        this.cprNr = cprNr;
        this.licNr = licNr;
        this.password = password;
        this.role = role;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCprNr() {
        return cprNr;
    }

    public void setCprNr(String cprNr) {
        this.cprNr = cprNr;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getLicNr() {
        return licNr;
    }

    public void setLicNr(String licNr) {
        this.licNr = licNr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

}
