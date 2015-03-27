<%-- 
    Document   : vogn.jsp
    Created on : 2008-09-13, 15:56:39
    Author     : adnan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %> 
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %> 
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <title><bean:message key="vogn"/></title>
    </head>
    <body>
        <hr>
        <table align="center">
            <tr>
                <td><h2><bean:message key="title.vogn"/></h2></td>
            </tr>
        </table>
            <hr>
                <br>
         <table align="center">
              <tr>
                <td><html:link styleClass="link" page="/vognForm.do?dispatch=setUpForInsertOrUpdate" scope="page">
                    <bean:message key="label.add.vogn"/>
                    </html:link>
               </td> 
            </tr>
        </table>
    <table width="100%" align="center">
        <tr>
            <th><bean:message key="id"/> </th>
            <th><bean:message key="bevnr"/></th>
            <th><bean:message key="regnr"/></th>
            <th><bean:message key="year"/></th>  
            <th><bean:message key="model"/></th> 
            <th><bean:message key="button.edit"/></th>
            <th><bean:message key="button.delete"/></th>
        </tr>
        <logic:iterate name="vogns" property="listByOffsetAndLength" id="vogn">
        <tr>          
                    <td class="nowrap"><bean:write name="vogn" property="vognId"/></td>
                    <td class="nowrap"><bean:write name="vogn" property="bevNr"/> </td>
                    <td class="nowrap"><bean:write name="vogn" property="regNr"/></td>
                    <td class="nowrap"><bean:write name="vogn" property="pyear"/> </td>
                    <td class="nowrap"><bean:write name="vogn" property="model"/> </td>                    
                    
                    <td>
                        <html:link page="/vognForm.do?dispatch=setUpForInsertOrUpdate"
                                   styleClass="nowrap"
                                   paramName="vogn" 
                                   paramId="vognId" 
                                   paramProperty="vognId"><html:button property="edit" value="Edit"/></html:link> 
                     </td>
                     <td>
                         <html:link page="/vogn.do?dispatch=delete"
                                   styleClass="nowrap"
                                   paramName="vogn" 
                                   paramId="vognId" 
                                   paramProperty="vognId"> <html:button property="delete" value="Delete"/></html:link> 
                    
                </td>                    
                </tr> 
            </logic:iterate>
                <tr>
                <td> 
      <%--   <logic:equal value="true" name="employees" property="prev">     
                    <html:link styleClass="paging" page="/employee.do?dispatch=getEmployees&act=next"><<</html:link>
               </logic:equal>--%>
                       <logic:iterate name="vogns" property="pages" id="varpage">
                           <html:link styleClass="paging" action="/vogn.do?dispatch=getVogn" paramName="varpage" paramId="page">                                                            
                                   <bean:write name="varpage"/>
                           </html:link>                   
                        </logic:iterate>
            <%--      <logic:equal value="true" name="employees" property="next">
                       <html:link styleClass="paging" page="/employee.do?dispatch=getEmployees&act=prev">>></html:link>
                       </logic:equal>--%>
                   </td>
            </tr>
    </table>
    </body>
</html>
