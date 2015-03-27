<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %> 
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %> 
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="<html:rewrite page="/struts/main.css" />" rel="stylesheet" type="text/css">
    <title><bean:message key="title.vogn"/></title>
</head>
<body>

<h2><bean:message key="label.add.vogn"/></h2>
<html:form action="/vognForm" method="post">
    <table>
        <tr>
            <td><bean:message key="bevnr"/></td> 
            <td><html:text property="bevNr"/></td>
           
        </tr>
       <tr>
            <td><bean:message key="regnr"/></td> 
            <td><html:text property="regNr"/></td>
           
        </tr>
        <tr>
            <td><bean:message key="year"/></td> 
            <td><html:text property="pyear"/></td>
            
        </tr>
        <tr>
            <td><bean:message key="model"/></td> 
            <td><html:text property="model"/></td>
           
        </tr>
          <tr>
              <html:hidden property="vognId"/>
             <input type="hidden" name="dispatch" value="insertOrUpdate"/>
             <td><html:submit /></td>           
                <td>
                    <html:cancel property="/vogn.do"/>
            </td>
        </tr>
    </table>
</html:form>
</body>
</html>
