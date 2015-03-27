/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.itaxa.filters;

import com.itaxa.beans.User;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.Globals;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;

/**
 *
 * @author adnan/
 */
public class SecurityFilter implements Filter {

    public void init(FilterConfig filterConfig) throws ServletException {
   
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
       HttpServletRequest req = (HttpServletRequest) request;
       HttpServletResponse res =(HttpServletResponse) response;
       HttpSession session = req.getSession();
       User user = (User) session.getAttribute("User");
       if(user == null){
         req.getRequestDispatcher("/index.jsp").forward(req, res);
      }      
      chain.doFilter(request, response);
    }

    public void destroy() {

    }


}
