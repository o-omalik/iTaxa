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
public class User implements Serializable {

    private String username;
    private String password;
    private String role;
    private String name;

    public User(){}

    public User(String name, String username, String password, String role){
        this.name = name;
        this.username = username;
        this.password = password;
        this.role = role;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
