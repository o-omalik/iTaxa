<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %> 
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %> 
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
       
       <link href="<html:rewrite page="/script/main.css" />" rel="stylesheet" type="text/css"> 
        <title><bean:message key="title.skattekort"/></title>
        <html:base/>
    </head>
    <body>
        <hr>
        <table align="center">
            <tr>
            <td><h2><bean:message key="title.skattekort"/></h2></td>
            </tr>
      </table>
      <hr>
        <html:form action="/skattekort" method="post">
            <table align="center">                 
                <tr> 
                    <td><bean:message key="driver"/></td> 
                    <td>
                        <html:select property="employee.employeeId" >
                            <html:options labelProperty="name" 
                                          collection="employees" 
                                          property="employeeId"/>                    
                        </html:select>
                    </td>
                </tr>
            </table>
            <table align="center">
                <tr>
                    <th><bean:message key="aktivedate"/></th><th><bean:message key="expiredate"/></th>
                    <th><bean:message key="procent"/></th><th><bean:message key="fradrag"/></th>
                </tr>
                <tr>
                    
                    <td><html:text property="aktivedate"/></td>
                    <td><html:text property="expiredate"/></td>
                    <td><html:text property="procent"/></td>
                    <td><html:text property="fradrag"/></td>
                </tr>
            </table>
            <table align="center">
                <tr> 
                    <html:hidden property ="dispatch" value="insertOrUpdate"/> 
                    <td><html:submit/></td>
                    <td><html:button property="clear" value="Clear"/></td>
                </tr>
            </table>
        </html:form>  
        <logic:present name="skattekorts">
            <table width="100%" align="center">
                <thead>
                    <tr>
                        <th><bean:message key="driver"/></th>
                        <th><bean:message key="aktivedate"/></th>
                        <th><bean:message key="expiredate"/></th>
                        <th><bean:message key="procent"/></th>
                        <th><bean:message key="fradrag"/></th>
                        <th><bean:message key="button.edit"/></th>
                        <th><bean:message key="button.delete"/></th>
                    </tr>
                </thead>
                <logic:iterate id="skattekort" name="skattekorts">
                    <tr>
                        <td class="nowrap"><bean:write name="skattekort" property="employee.name"/></td>
                        <td class="nowrap"><bean:write name="skattekort" property="aktivedate"/></td>
                        <td class="nowrap"><bean:write name="skattekort" property="expiredate"/></td>
                        <td class="nowrap"><bean:write name="skattekort" property="procent"/></td>
                        <td class="nowrap"><bean:write name="skattekort" property="fradrag"/></td>
                        <td class="nowrap"><html:link page="/skattekort.do?dispatch=setUpForInsertOrUpdate"  
                                       styleClass="nowrap"   
                                       paramName="skattekort" 
                                       paramId="id" 
                                       paramProperty="id">
                                      <html:button property="edit" value="Edit"/></html:link></td>
                                       <td> <html:link  page="/skattekort.do?dispatch=delete" 
                                             styleClass="nowrap"
                                             paramName="skattekort" 
                                             paramId="id"                                        
                                             paramProperty="id">
                            <html:button property="delete" value="Delete"/></html:link>
                        </td>
                    </tr>
                </logic:iterate>
            </table>                            
        </logic:present>
    </body>
</html>
