/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.itaxa.actions;

import com.itaxa.beans.Payslip;
import com.itaxa.forms.PayslipForm;
import com.itaxa.persistense.EmployeeDao;
import com.itaxa.persistense.EmployeeDaoImp;
import com.itaxa.persistense.PayslipDao;
import com.itaxa.persistense.PayslipDaoImp;
import com.itaxa.persistense.SkatteKortDao;
import com.itaxa.persistense.SkatteKortDaoImp;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;


/**
 *
 * @author adnan
 */
public class PayslipAction extends DispatchAction {
    private static SkatteKortDao skService = new SkatteKortDaoImp();
    private static EmployeeDao empService = new EmployeeDaoImp();
    private static PayslipDao psService = new PayslipDaoImp();
    
    public ActionForward getLists(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
         populate(request);           
         return mapping.findForward(Constants.LIST);
    }
    
    public ActionForward getPayslip(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        PayslipForm psform = (PayslipForm) form;
        Payslip slip = new Payslip();
        BeanUtils.copyProperties(slip, psform);
        psService.getTotal(slip);               
        slip.setEmployee(empService.getEmployee(slip.getEmployee().getEmployeeId()));
        slip.setSkattekort(skService.getById(slip.getEmployee().getEmployeeId()));
        BeanUtils.copyProperties(psform, slip);
        populate(request);
        return mapping.findForward(Constants.LIST);
   }     
   public ActionForward insert(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
      PayslipForm psform = (PayslipForm) form;
      Payslip slip = new Payslip();
      BeanUtils.copyProperties(slip, psform);
      psService.insert(slip);
      populate(request); 
      return mapping.findForward(Constants.LIST);
    }    

    public void populate(HttpServletRequest request) {
        request.setAttribute(Constants.EMPLOYEES, empService.getAllEmployee());
    }

}
