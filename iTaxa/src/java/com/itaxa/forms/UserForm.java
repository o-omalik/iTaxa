/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.itaxa.forms;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;


/**
 *
 * @author adnan
 */
public class UserForm extends ActionForm {
    
    private String username;
    private String password;
    private String role;

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


  
}
