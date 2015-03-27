/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.itaxa.actions;



import com.itaxa.beans.SkatteKort;
import com.itaxa.forms.SkatteKortForm;
import com.itaxa.persistense.EmployeeDao;
import com.itaxa.persistense.EmployeeDaoImp;
import com.itaxa.persistense.SkatteKortDao;
import com.itaxa.persistense.SkatteKortDaoImp;
import java.util.List;
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
public class SkatteKortAction extends DispatchAction {
    private static SkatteKortDao skService = new SkatteKortDaoImp();
    private static EmployeeDao empService = new EmployeeDaoImp();
    
    public ActionForward getSkatteKort(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception{
     populate(request);
     return mapping.findForward(Constants.LIST);
       
    }
    
    public ActionForward setUpForInsertOrUpdate(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception{
     SkatteKortForm skForm = (SkatteKortForm) form; 
        if (isUpdate(request, skForm)) {
            Integer id = Integer.valueOf(skForm.getId());
            SkatteKort sk = skService.getById(id);
            BeanUtils.copyProperties(skForm, sk);
        }
        populate(request);
       return mapping.findForward(Constants.LIST);
    }
    public ActionForward insertOrUpdate(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        SkatteKortForm skForm = (SkatteKortForm) form;
        SkatteKort sk = new SkatteKort();
        BeanUtils.copyProperties(sk, skForm);
        if (isUpdate(request, skForm)) {
            System.out.println("Update");
            skService.update(sk);            
        } else {
            skService.insert(sk);
            System.out.println("Insert");
        }
         populate(request);
        return mapping.findForward(Constants.LIST);

    }
    public ActionForward delete(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception{
        String parm = request.getParameter("id");
        Integer id = Integer.valueOf(parm);
        skService.delete(id);
        populate(request);
        return mapping.findForward(Constants.LIST);
    } 
    
    public void populate(HttpServletRequest request){        
        List skattekorts = skService.getAllSkatteKort();
        request.setAttribute(Constants.SKATTEKORTS, skattekorts);
        request.setAttribute(Constants.EMPLOYEES, empService.getAllEmployee());
        
    }
    private boolean isUpdate(HttpServletRequest request, SkatteKortForm skForm){
    boolean updateFlag = true;           
        String id = skForm.getId();        
        if (id == null || id.trim().length() == 0 || Integer.parseInt(id) == 0) {
            updateFlag = false;
        }
        request.setAttribute("updateFlag", Boolean.valueOf(updateFlag));
        return updateFlag;
    }
}
