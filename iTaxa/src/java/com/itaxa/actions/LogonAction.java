/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itaxa.actions;


import com.itaxa.beans.User;
import com.itaxa.forms.UserForm;
import com.itaxa.persistense.UserDao;
import com.itaxa.persistense.UserDaoImp;
import javax.naming.AuthenticationException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.SimpleLayout;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;
import org.apache.struts.actions.DispatchAction;


/**
 *
 * @author adnankaramat
 */
public class LogonAction extends DispatchAction {

    /* forward name="success" path="" */
    private final static String SUCCESS = "logon";
    private final static String WELCOME="welcome";
    private final static String FAILURE = "error";
    private static Logger log = Logger.getLogger(LogonAction.class);
    private static UserDao userService = new UserDaoImp();
    public ActionForward logon(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

         //Check to see if a session has already been created for this user
         //don't create a new session yet.
         UserForm userform = (UserForm) form;
         String username = userform.getUsername();
         String password = userform.getPassword();
         HttpSession session = request.getSession();
         
         try{
         User user = userService.authenticate(username, password);
         log.info("getting user");
         if(password.equals(user.getPassword()) && username.equals(user.getUsername())){
             session.setAttribute("User", user);
             session.setAttribute("role", user.getRole());
             session.setAttribute("username", user.getName());
             log.info(username + " " + "is logged succesfuly");
             return mapping.findForward(SUCCESS);
         }else{
          log.info("wrong username or password");
         return mapping.findForward(WELCOME);
         }
         }catch(AuthenticationException e ){
         log.error(e);
         return mapping.findForward(FAILURE);
         }                         
    }
    public ActionForward welcome(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response){
            return mapping.findForward(WELCOME);
    }
}