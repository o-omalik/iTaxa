<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <link href="<html:rewrite page="/script/main.css" />" rel="stylesheet" type="text/css"> 
        <title>JSP Page</title>
    </head>
    <body>
        <script src="../script/calender.js"></script>
         <hr>
        <table align="center">
            <tr>
                <td> <h2><bean:message key="title.showtrafikbook"/></h2></td>
            </tr>
        </table>
        <hr>
            <html:form action="/showTrafikbook" method="post">
        <table>
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
                    <td><bean:message key="fromdate"/></td>
                    <td><html:text property="fromDate" styleId="date" /></td>
                    <td><a href="javascript:displayDatePicker('fromDate', false, 'ymd', '-');"><img src="../static/cal.gif" width="16" height="16" border="0" alt="Pick a date"></a></td>
                    <td><bean:message key="todate"/></td>
                    <td><html:text property="toDate" styleId="date" /></td>
                    <td><a href="javascript:displayDatePicker('toDate', false, 'ymd', '-');"><img src="../static/cal.gif" width="16" height="16" border="0" alt="Pick a date"></a></td>
                </tr>
                <tr><td>
                    <html:hidden property="dispatch" value="searchByDriver"/>
                    <html:hidden property="employee.employeeId"/>
                    <html:hidden property="fromDate"/>
                    <html:hidden property="toDate"/>
                    <html:submit value="Search"/></td></tr>
        </table>

        <table align="center" width="100%">
             <thead>
                <tr>

                    <th><bean:message key="date"/></th>
                    <th><bean:message key="amount"/></th>
                    <th><bean:message key="hours"/></th>
                    <th><bean:message key="km"/></th>
                    <th><bean:message key="customers"/></th>
                    <th><bean:message key="cash"/></th>
                    <th><bean:message key="credit"/></th>
                    <th><bean:message key="aacount"/></th>
                    <th><bean:message key="diverse"/></th>
                </tr>
            </thead>

            <logic:iterate name="trafikbooks" property="listByOffsetAndLength" id="trafikbook" >
                <tr>

                    <td class="nowrap"><bean:write name="trafikbook" property="date"/></td>
                    <td class="nowrap"><bean:write name="trafikbook" property="enheder"/></td>
                    <td class="nowrap"><bean:write name="trafikbook" property="hours"/></td>
                    <td class="nowrap"><bean:write name="trafikbook" property="km"/></td>
                    <td class="nowrap"><bean:write name="trafikbook" property="tours"/></td>
                    <td class="nowrap"><bean:write name="trafikbook" property="cash"/></td>
                    <td class="nowrap"><bean:write name="trafikbook" property="credit"/></td>
                    <td class="nowrap"><bean:write name="trafikbook" property="akonto"/></td>
                    <td class="nowrap"><bean:write name="trafikbook" property="diverse"/></td>
                </tr>
            </logic:iterate>
            <tr><th></th>
                <th><bean:write name="TrafikbookForm" property="enheder"/></th>
                <th><bean:write name="TrafikbookForm" property="hours"/></th>
                <th><bean:write name="TrafikbookForm" property="km"/></th>
                <th><bean:write name="TrafikbookForm" property="tours"/></th>
                <th><bean:write name="TrafikbookForm" property="cash"/></th>
                <th><bean:write name="TrafikbookForm" property="credit"/></th>
                <th><bean:write name="TrafikbookForm" property="akonto"/></th>
                <th><bean:write name="TrafikbookForm" property="diverse"/></th>


            </tr>
            <tr>

                <td>
                    <logic:iterate name="trafikbooks" property="pages" id="varpage">
                        <html:link styleClass="paging"  action="/showTrafikbook.do?dispatch=searchByDriver" paramName="varpage" paramId="page">
                            <bean:write name="varpage" />
                        </html:link>
                </logic:iterate></td></tr>
        </table>
    </html:form>
    </body>
</html>
