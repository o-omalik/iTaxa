/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.itaxa.forms;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;


/**
 *
 * @author adnan
 */
public class VognForm extends org.apache.struts.action.ActionForm {
    
    private String vognId;
    private String bevNr;
    private String regNr;
    private String model;
    private String pyear;

    public String getBevNr() {
        return bevNr;
    }

    public void setBevNr(String bevNr) {
        this.bevNr = bevNr;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getRegNr() {
        return regNr;
    }

    public void setRegNr(String regNr) {
        this.regNr = regNr;
    }

    public String getVognId() {
        return vognId;
    }

    public void setVognId(String vognId) {
        this.vognId = vognId;
    }

    public String getPyear() {
        return pyear;
    }

    public void setPyear(String pyear) {
        this.pyear = pyear;
    }

/**
    public void reset(ActionMapping mapping, HttpServletRequest request) {
       vognId="";
       bevNr="";
       regNr="";
       model="";
       pyear="";
    }
/**
    
    @Override
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        ActionErrors errors = new ActionErrors();
        if((bevNr == null) || (bevNr.length() < 1))
            errors.add("bevNr", new ActionError("error.vogn.bevNr"));
        if((regNr == null) || (regNr.length() < 1))
            errors.add("regNr", new ActionError("error.vogn.regNr"));
        if((model == null) || (model.length() < 1))
            errors.add("model", new ActionError("error.vogn.model"));
        if((pyear == null) || (pyear.length() < 1))
            errors.add("pyear", new ActionError("error.vogn.year"));     
        
        return errors;
    }
**/
    
}
