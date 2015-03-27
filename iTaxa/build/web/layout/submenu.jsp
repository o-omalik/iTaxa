<%-- 
    Document   : submenu
    Created on : Jan 10, 2009, 9:46:16 PM
    Author     : adnan
--%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %> 
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %> 
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %>
<table width="100%" >
    <tr >
 <td align="left" width="70%">
      <%if(session.getAttribute("User")!=null){ %>
     <table>
    <tr>
        <td class="text3"><%=new java.util.Date()%></td>
    </tr>   
</table></td>

      <td align="right" width="30%"> <table>
          <tr><td class="text3">You are logged in as </td><td class="text2"><%= session.getAttribute("username")%></td>
            <td align="right"><html:link styleClass="link" page="/logoff.do?dispatch=logoff">Log off</html:link></td>
        </tr>
</table></td>
       <%}%>
   </tr>
   </table>