<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %> 
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %> 
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
    
<html>
    <head>
        <link href="<html:rewrite page="/script/main.css" />" rel="stylesheet" type="text/css"> 
        <script language="javascript" type="text/javascript" src="/test.js"></script>
            
        <title><bean:message key="title.trafikbook"/></title>
        <html:base/>
    </head>
    <body>
        <script src="../script/calender.js"></script>
         <hr>
        <table align="center">
            <tr>
                <td> <h2><bean:message key="title.trafikbook"/></h2></td>
        </tr>
        </table>
        <hr>
        <html:form action="/showTrafikbook" method="post">
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
                <tr> 
                    <td><bean:message key="bevilling"/></td> 
                    <td>
                        <html:select property="vogn.vognId">
                            <html:options labelProperty="bevNr"
                                          collection="vogns"
                                          property="vognId"/>
                        </html:select>
                    </td>
                </tr>
                <tr>
                    <td><bean:message key="date"/></td>
                    <td><html:text property="date" styleId="date" /></td>
                    <td><a href="javascript:displayDatePicker('date', false, 'ymd', '-');"><img src="../static/cal.gif" width="16" height="16" border="0" alt="Pick a date"></a></td>
                </tr>
            </table>
                
            <table align="center">           
                <tr>
                    <th><bean:message key="hours"/></th><th><bean:message key="amount"/></th>
                    <th><bean:message key="customers"/></th><th><bean:message key="km"/></th>
                </tr>
                <tr>
                    <td><html:text property="hours"/></td>
                    <td><html:text property="enheder"/></td>
                    <td><html:text property="tours"/></td>
                    <td><html:text property="km"/></td>
                </tr>
                <tr>
                    <th><bean:message key="credit"/></th><th><bean:message key="cash"/></th>
                    <th><bean:message key="aacount"/></th><th><bean:message key="diverse"/></th>
                </tr>
                <tr>
                    <td><html:text property="credit"/></td>
                    <td><html:text property="cash"/></td>
                    <td><html:text property="akonto"/></td>
                    <td><html:text property="diverse"/></td>
                </tr>   
                    
            </table>
            <table align="center">
                <tr> 
                    <html:hidden property ="dispatch" value="searchByDriver"/>
                    <td><html:submit/></td>
                    <td><html:reset/></td>
                </tr>
            </table>
        </html:form>
        <table align="center" width="100%">   
            <thead>
                <tr>
                    <th><bean:message key="driver"/></th>
                    <th><bean:message key="vogn"/></th>
                    <th><bean:message key="date"/></th>
                    <th><bean:message key="amount"/></th>
                    <th><bean:message key="hours"/></th>
                    <th><bean:message key="km"/></th>
                    <th><bean:message key="customers"/></th>
                    <th><bean:message key="cash"/></th>
                    <th><bean:message key="credit"/></th>
                    <th><bean:message key="aacount"/></th>
                    <th><bean:message key="diverse"/></th>
                    <th><bean:message key="button.edit"/></th>
                    <th><bean:message key="button.delete"/></th>
                </tr>
            </thead>
                
            <logic:iterate name="trafikbooks" property="listByOffsetAndLength" id="trafikbook" >               
                <tr>   
                    <td class="nowrap"><bean:write name="trafikbook" property="employee.name"/></td>
                    <td class="nowrap"><bean:write name="trafikbook" property="vogn.bevNr"/></td>
                    <td class="nowrap"><bean:write name="trafikbook" property="date"/></td>
                    <td class="nowrap"><bean:write name="trafikbook" property="enheder"/></td>
                    <td class="nowrap"><bean:write name="trafikbook" property="hours"/></td>
                    <td class="nowrap"><bean:write name="trafikbook" property="km"/></td>
                    <td class="nowrap"><bean:write name="trafikbook" property="tours"/></td>
                    <td class="nowrap"><bean:write name="trafikbook" property="cash"/></td>
                    <td class="nowrap"><bean:write name="trafikbook" property="credit"/></td>
                    <td class="nowrap"><bean:write name="trafikbook" property="akonto"/></td>
                    <td class="nowrap"><bean:write name="trafikbook" property="diverse"/></td>
                    <td class="nowrap"> <html:link  page="/trafikbook.do?dispatch=setUpForInsertOrUpdate" 
                                         styleClass="nowrap"
                                         paramName="trafikbook" 
                                         paramId="bogId"                                        
                                         paramProperty="bogId"> 
                        <html:button property="edit" value="Edit"/></html:link>
                    </td>
                    <td> <html:link  page="/trafikbook.do?dispatch=delete" 
                                         styleClass="nowrap"
                                         paramName="trafikbook" 
                                         paramId="bogId"                                        
                                         paramProperty="bogId">
                        <html:button property="delete" value="Delete"/></html:link>
                    </td>
                </tr>               
            </logic:iterate>                   
            <tr>
                <td> 
                    <logic:iterate name="trafikbooks" property="pages" id="varpage">
                        <html:link styleClass="paging"  action="/trafikbook.do?dispatch=getTrafikbook" paramName="varpage" paramId="page">
                            <bean:write name="varpage" />
                        </html:link>
                </logic:iterate></td>
            </tr>
        </table>
            
    </body>
</html>
