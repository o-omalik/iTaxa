<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %> 
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %> 
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title><bean:message key="employees"/></title>
        <html:base/>
    </head>
    <body>
         <hr>
        <table align="center">
            <tr>
                <td><h2><bean:message key="employees"/></h2></td>
            </tr>
          </table> 
          <hr>
              <br>
          <table align="center">
            <tr>
                 <td><html:link styleClass="link"  page="/employeeForm.do?dispatch=setUpForInsertOrUpdate" scope="page">
                                  <bean:message key="label.add.employee"/>
                                  </html:link>
                 </td>
            </tr>
        </table>
        <table width="100%" align="center">

            <tr>
                <th><bean:message key="name"/></th>
                <th><bean:message key="cpr"/></th>
                <th><bean:message key="street"/></th>
                <th><bean:message key="city"/></th>
                <th><bean:message key="post"/></th>
                <th><bean:message key="phone"/></th>
                <th><bean:message key="license"/></th>
                <th><bean:message key="button.edit"/></th>
                <th><bean:message key="button.delete"/></th>
            </tr>
            <logic:iterate name="employees" property="listByOffsetAndLength" id="emp">
                <tr>
                    <td class="nowrap"><bean:write name="emp" property="name"/></td>
                    <td class="nowrap"><bean:write name="emp" property="cprNr"/></td>
                    <td class="nowrap"><bean:write name="emp" property="street"/></td>
                    <td class="nowrap"><bean:write name="emp" property="city"/></td>
                    <td class="nowrap"><bean:write name="emp" property="post"/></td>
                    <td class="nowrap"><bean:write name="emp" property="phone"/></td>
                    <td class="nowrap"><bean:write name="emp" property="licNr"/></td>        
                    <td> <html:link styleClass="nowrap"  page="/employeeForm.do?dispatch=setUpForInsertOrUpdate" 
                                         paramName="emp" 
                                         paramId="employeeId"                                        
                                         paramProperty="employeeId" useLocalEncoding="true"> 
                        <html:button property="edit" value="Edit"/></html:link>
                    </td>
                    <td> <html:link styleClass="nowrap"  page="/employee.do?dispatch=delete" 
                                         paramName="emp" 
                                         paramId="employeeId"                                        
                                         paramProperty="employeeId" useLocalEncoding="true">
                        <html:button property="delete" value="Delete"/></html:link>
                    </td>
                </tr>                                 
            </logic:iterate>
            <tr>
                <td> 
      <%--   <logic:equal value="true" name="employees" property="prev">     
                    <html:link styleClass="paging" page="/employee.do?dispatch=getEmployees&act=next"><<</html:link>
               </logic:equal>--%>
                       <logic:iterate name="employees" property="pages" id="varpage">
                           <html:link styleClass="paging" action="/employee.do?dispatch=getEmployees" paramName="varpage" paramId="page">                                                            
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