/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itaxa.forms;

import org.apache.struts.action.ActionForm;


/**
 *
 * @author adnankaramat
 */
public class EmployeeForm extends ActionForm {

    private String employeeId;
    private String cprNr;
    private String name;
    private String street;
    private String city;
    private String post;
    private String phone;
    private String licNr;
    private String password;
    private String role;

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

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
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
