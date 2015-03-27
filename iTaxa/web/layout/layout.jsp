<%-- 
    Document   : layout
    Created on : 2008-06-16, 21:52:15
    Author     : adnankaramat
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %> 
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %> 
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-tiles" prefix="tiles" %> 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"> 
<html:html locale="true"> 
  <head>
    <html:base /> 
    <link rel="StyleSheet" href="../script/main.css" type="text/css"/>
    <title><tiles:getAsString name="title" /></title> 
  </head> 
  <body> 
  <table align="center" width= "100%" height="100%"> 
  <tbody> 
  <tr><td  height="5%" colspan="2"><tiles:insert attribute="header" /></td></tr>
  <tr><td  height="2%" colspan="2"><tiles:insert attribute="submenu" /></td></tr> 
  <tr> 
  <td  width ="10%" height="90%"><tiles:insert attribute="menu" /></td> 
  <td  height="90%"><tiles:insert attribute="body" /></td> 
  </tr> 
  <tr><td height="10%" colspan="2"><tiles:insert attribute="footer" /></td></tr> 
  </tbody> 
  </table> 
  </body> 
</html:html> 