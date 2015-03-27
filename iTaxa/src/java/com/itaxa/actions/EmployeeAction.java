/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itaxa.actions;

import com.itaxa.beans.Employee;
import com.itaxa.forms.EmployeeForm;
import com.itaxa.persistense.EmployeeDao;
import com.itaxa.persistense.EmployeeDaoImp;
import com.itaxa.services.Paging;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;
import org.apache.struts.actions.DispatchAction;

/**
 *
 * @author adnankaramat
 */
public class EmployeeAction extends DispatchAction {

    private static EmployeeDao empService = new EmployeeDaoImp();

    public ActionForward getEmployees(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {        
        populate(request);
        return mapping.findForward(Constants.LIST);
        
    }

    public ActionForward setUpForInsertOrUpdate(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

        EmployeeForm employeeForm = (EmployeeForm) form;
        
        if (isUpdate(request, employeeForm)) {
            Integer id = Integer.valueOf(employeeForm.getEmployeeId());
            Employee employee = empService.getEmployee(id);
            BeanUtils.copyProperties(employeeForm, employee);
        }
        return mapping.findForward(Constants.FORM);
    }

    public ActionForward delete(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

        String parm = request.getParameter("employeeId");
        Integer id = Integer.valueOf(parm);
        empService.delete(id);
        populate(request);
        return mapping.findForward(Constants.LIST);
    }

    public ActionForward insertOrUpdate(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

            EmployeeForm employeeForm = (EmployeeForm) form;
            Employee employee = new Employee();
            BeanUtils.copyProperties(employee, employeeForm);
            if (isUpdate(request, employeeForm)) {
                empService.updateEmployee(employee);
            } else {
                empService.insertEmployee(employee);
            }
            populate(request);
            return mapping.findForward(Constants.LIST);
        
    }
    
    public void populate(HttpServletRequest request) throws NullPointerException {
        List employees = empService.getAllEmployee();
        Paging pages = new Paging();
        int page = pages.getPage(); 
         try{
	       page = Integer.parseInt(request.getParameter("page"));
		}catch(NumberFormatException e){} 

        pages.setPage(page);
        pages.setList(employees);
        request.setAttribute(Constants.EMPLOYEES, pages);
    }
   
    

    public boolean isUpdate(HttpServletRequest request, EmployeeForm empForm) {
        
        boolean updateFlag = true;           
        String id = empForm.getEmployeeId();       
        if (id == null || id.trim().length() == 0 || Integer.parseInt(id) == 0) {
            updateFlag = false;
        }
        return updateFlag;
    }
    
}