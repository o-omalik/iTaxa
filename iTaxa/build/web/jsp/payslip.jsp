<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %> 
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %> 
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <link href="<html:rewrite page="/script/main.css" />" rel="stylesheet" type="text/css"> 
        
        <title>Paylsip</title>
    </head>
    <body>
        <h2><bean:message key="title.payslip"/></h2>
        <html:form action="/payslip">
            <table>
                <tr> 
                    <td>Driver: </td> 
                    <td>
                        <html:select property="employee.employeeId" >
                            <html:options labelProperty="name"
                                          collection="employees"
                                          property="employeeId"/>
                        </html:select>
                    </td>
                </tr>
                <tr> 
                    <td>Period:</td> 
                    <td>
                        <html:select property="period">
                            <html:option value="1">January</html:option>
                            <html:option value="2">February</html:option>
                            <html:option value="3">March</html:option>
                            <html:option value="4">April</html:option>
                            <html:option value="5">May</html:option>
                            <html:option value="6">June</html:option>
                            <html:option value="7">July</html:option>
                            <html:option value="8">August</html:option>
                            <html:option value="9">September</html:option>
                            <html:option value="10">Oktober</html:option>
                            <html:option value="11">November</html:option>
                            <html:option value="12">December</html:option>                            
                         </html:select>
                    </td>
                </tr>
                 <html:hidden property ="dispatch" value="getPayslip"/> 
                 <tr><td><html:submit value="Create"/></td></tr>
            </table>
            </html:form>
             <html:form action="/payslip">
            <table>               
                <tr><td><bean:write name="PayslipForm" property="employee.name"/></td></tr>
                <tr><td><bean:write name="PayslipForm" property="employee.street"/></td></tr>
                <tr><td><bean:write name="PayslipForm" property="employee.post"/><td><bean:write name="PayslipForm" property="employee.city"/></td></tr>
                <tr><td><bean:write name="PayslipForm" property="employee.cprNr"/></td></tr>                               
            </table>
            <br>
            <br>
            <table>
                <tr><td>Period:<td><td><bean:write name="PayslipForm" property="period"/></td></tr>
                <tr><td>50% af Indkørt:</td><td></td><td></td><td><bean:write name="PayslipForm" property="indkoert"/></td></tr>
                <tr><td>Atp:</td><td></td><td></td><td>-<bean:write name="PayslipForm" property="atp"/></td></tr>
                <tr><td>AM-Bidrag:</td><td>8%</td><td><bean:write name="PayslipForm" property="brutto"/></td><td>-<bean:write name="PayslipForm" property="amBidrag"/></td></tr>
                <tr><td>A-Inkomst ialt:</td><td></td><td><bean:write name="PayslipForm" property="aincome"/></td><td></td></tr>
                <tr><td>Skatte Fradrag:</td><td><bean:write name="PayslipForm" property="skattekort.fradrag"/></td><td><bean:write name="PayslipForm" property="traek"/></td><td></td></tr>
                <tr><td>A-Skat:</td><td><bean:write name="PayslipForm" property="skattekort.procent"/></td><td><bean:write name="PayslipForm" property="traek"/></td><td>-<bean:write name="PayslipForm" property="askat"/></td></tr>
                <tr><td>Løn til udbetaling</td><td></td><td></td><td><bean:write name="PayslipForm" property="totalPay"/></td></tr>    
                 <br><br>
                 <html:hidden property="employee.employeeId"/>
                 <html:hidden property="skattekort.id"/>
                 <html:hidden property ="dispatch" value="insert"/> 
                 <tr><td><html:submit value="Save"/></td></tr>
            </table>
           
        </html:form>
    </body>
</html>
