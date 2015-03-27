<%-- 
    Document   : menu
    Created on : 2008-06-16, 21:52:48
    Author     : adnankaramat
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %> 
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %> 
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %>
        <script language="JavaScript" type="text/JavaScript">
    menu_status = new Array();
   function showHide(theid){
    if (document.getElementById) {
    var switch_id = document.getElementById(theid);

        if(menu_status[theid] != 'show') {
           switch_id.className = 'show';
           menu_status[theid] = 'show';
        }else{
           switch_id.className = 'hide';
           menu_status[theid] = 'hide';
        }
    }
}
</script>
<hr>
<table align="center">
    <tr>
        <td><h2>Menu</h2></td>
    </tr>
</table>
<%String version =System.getProperty("java.version");
  version = version.substring(0, 3);
%>
<hr>
    <%if(session.getAttribute("User")!=null){
    %>
<table><tr>
  <td>
    <a class="menu1" onclick="showHide('mymenu1')">Employees</a>
    <div id="mymenu1" class="hide">
        <html:link  styleClass="submenu" page="/employee.do?dispatch=getEmployees">Show employees</html:link>
    </div>
    <a class="menu1" onclick="showHide('mymenu2')" >Vogn</a>
    <div id="mymenu2" class="hide">
        <html:link styleClass="submenu" page="/vogn.do?dispatch=getVogn">Show Vogns</html:link>
    </div>
     <a class="menu1" onclick="showHide('mymenu3')">Trafikbook</a>
     <div id="mymenu3" class="hide">
        <html:link styleClass="submenu" page="/trafikbook.do?dispatch=getTrafikbook">Register trafikbook</html:link>
        <html:link styleClass="submenu" page="/showTrafikbook.do?dispatch=searchByDriver">Show trafikbook</html:link>
    </div>
     <a class="menu1" onclick="showHide('mymenu4')">Skattekort</a>
     <div id="mymenu4" class="hide">
        <html:link styleClass="submenu" page="/skattekort.do?dispatch=getSkatteKort">Show skattekort</html:link>
    </div>
     <a class="menu1" onclick="showHide('mymenu5')">Paylsip</a>
     <div id="mymenu5" class="hide">
        <html:link styleClass="submenu" page="/payslip.do?dispatch=getLists">New Payslip</html:link>
    </div>
</td>
</tr>
</table>
<%}else{%>
<table><tr>
  <td> <a class="menu1" onclick="showHide('mymenu1')">Check computer </a>
    <div id="mymenu1" class="hide">
        
        <html:link styleClass="submenu" page="">OS: <%=System.getProperty("os.name")%></html:link>
        <html:link styleClass="submenu" page="">JDK: <%=version%></html:link>
        <html:link styleClass="submenu" page="">User: <%=System.getProperty("user.name")%></html:link>
    </div>
   <a class="menu1" onclick="showHide('mymenu2')">About iTaxa </a>
    <div id="mymenu2" class="hide">
        
        <html:link styleClass="submenu" page="">4x35</html:link>
        <html:link styleClass="submenu" page="">Vognmand</html:link>
        <html:link styleClass="submenu" page="">Work</html:link>
    </div>
    <a class="menu1" onclick="showHide('mymenu3')">Help </a>
    <div id="mymenu3" class="hide">
        
        <html:link styleClass="submenu" page="">Q&A</html:link>
    </div>    
   </td>
</tr>
</table>
<%}%>