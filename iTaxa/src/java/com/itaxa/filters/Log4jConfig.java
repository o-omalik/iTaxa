/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.itaxa.filters;

import javax.servlet.http.HttpServlet;
import org.apache.log4j.PropertyConfigurator;
import javax.servlet.ServletException;

/**
 *
 * @author adnan
 */
public class Log4jConfig extends HttpServlet {

public void init() throws ServletException{

      String log4jfile = getInitParameter("log4j-init-file");
      if (log4jfile != null) {
         String propfile = getServletContext().getRealPath(log4jfile);
         PropertyConfigurator.configure(propfile);
      }
   }

}
