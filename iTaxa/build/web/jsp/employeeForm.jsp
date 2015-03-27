<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %> 
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %> 
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="<html:rewrite page="/struts/main.css" />" rel="stylesheet" type="text/css">
    <html:javascript formName="EmployeeForm"/>
    <title><bean:message key="title.employees"/></title>
</head>
<body>
<table align="center" >
    <tr>
<td><h2><bean:message key="label.add.employee"/></h2></td>
</tr>
</table>
<html:form action="/employeeForm" method="post" onsubmit="return validateEmployeeForm(this);">
    <table align="center" class="text">
        <tr>
            <td><bean:message key="name"/></td> 
            <td><html:text property="name"/></td>
        </tr>
       <tr>
            <td><bean:message key="cpr"/></td> 
            <td><html:text property="cprNr" maxlength="10"/></td>
        </tr>
        <tr>
            <td><bean:message key="street"/></td> 
            <td><html:text property="street"/></td>
        </tr>
        <tr>
            <td><bean:message key="city"/></td> 
            <td><html:text property="city"/></td>
        </tr>
        <tr>
            <td><bean:message key="post"/></td> 
            <td><html:text property="post" maxlength="4"/></td>
        </tr>
        <tr>
            <td><bean:message key="phone"/></td> 
            <td><html:text property="phone" maxlength="8"/></td>
        </tr>
        <tr>
            <td><bean:message key="license"/></td> 
            <td><html:text property="licNr" maxlength="5"/></td>
        </tr>
        <tr>
            <td><bean:message key="password"/></td>
            <td><html:text property="password" maxlength="12"/></td>
        </tr>
        <tr>
            <td><bean:message key="role"/></td>
            <td><html:select property="role">
                <html:option value="admin">ADMIN</html:option>
                <html:option value="vognmand">VOGNMAND</html:option>
                <html:option value="revisor">REVISOR</html:option>
                <html:option value="driver">DRIVER</html:option>
            </html:select></td>
        </tr>
        <tr>
              <html:hidden property="employeeId"/>
             <input type="hidden" name="dispatch" value="insertOrUpdate"/>
            <td><html:submit/></td>  
            <td><html:cancel property="/employee.do"/></td>
        </tr>
    </table>
</html:form>
</body>
</html>