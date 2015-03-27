<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %> 
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %> 
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %>

<html:html locale="true">
<head>

<link href="<html:rewrite page="/script/main.css" />" rel="stylesheet" type="text/css">
<html:javascript formName="UserForm"/>
<title><bean:message key="welcome.title"/></title>
<html:base/>
</head>

<body bgcolor="white">
    <hr>
    <table align="center">
        <tr>
            <td>
             <h2>Logon</h2>   
            </td>
        </tr>
    </table>
    <hr>
<html:form action="/logon.do?dispatch=logon" method="post" onsubmit="return validateUserForm(this);" >
<table>
<tr align="left">
<td align="left"><bean:message key="itaxa.username"/></td> 
<td><html:text property="username" size="15" maxlength="15"/></td>
</tr> 
<tr align="left">
<td><bean:message key="itaxa.password"/></td> 
<td><html:password property="password" size="15" maxlength="15"/></td>
</tr> 
<tr align="center">
<td><html:submit>Login Now!</html:submit></td>
</tr> 
</table>
</html:form>
<body>
</html:html>