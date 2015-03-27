/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.itaxa.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;
import org.apache.struts.actions.DispatchAction;


/**
 *
 * @author adnan
 */
public class LogoffAction extends DispatchAction {
    
    /* forward name="success" path="" */
     private final static String SUCCESS = "welcome";
     private static Logger log = Logger.getLogger(LogoffAction.class);
    /**
     * This is the action called from the Struts framework.
     * @param mapping The ActionMapping used to select this instance.
     * @param form The optional ActionForm bean for this request.
     * @param request The HTTP Request we are processing.
     * @param response The HTTP Response we are processing.
     * @throws java.lang.Exception
     * @return
     */
    public ActionForward logoff(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        HttpSession session = request.getSession(false);
        String username = (String) session.getAttribute("username");
        session.invalidate();
        log.info(username + " " + "is now logged off");
        return mapping.findForward(SUCCESS);
        
    }
}