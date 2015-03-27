/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itaxa.actions;

import com.itaxa.beans.Trafikbook;
import com.itaxa.forms.TrafikbookForm;
import com.itaxa.persistense.EmployeeDao;
import com.itaxa.persistense.EmployeeDaoImp;
import com.itaxa.persistense.TrafikbookDao;
import com.itaxa.persistense.TrafikbookDaoImp;
import com.itaxa.persistense.VognDao;
import com.itaxa.persistense.VognDaoImp;
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
 * @author adnan
 */
public class TrafikbookAction extends DispatchAction {

    private static TrafikbookDao tbService = new TrafikbookDaoImp();
    private static EmployeeDao empService = new EmployeeDaoImp();
    private static VognDao vognService = new VognDaoImp();
    
    public ActionForward getTrafikbook(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {        
        populate(request);                    
        return mapping.findForward(Constants.LIST);

    }   

    public ActionForward setUpForInsertOrUpdate(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        TrafikbookForm tbForm = (TrafikbookForm) form; 
        if (isUpdate(request, tbForm)) {
            Integer id = Integer.valueOf(tbForm.getBogId());
            Trafikbook tb = tbService.getTrafikbook(id);
            BeanUtils.copyProperties(tbForm, tb);
        }
        populate(request);
       return mapping.findForward(Constants.LIST);

    }

    public ActionForward insertOrUpdate(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        TrafikbookForm tbForm = (TrafikbookForm) form;
        Trafikbook tb = new Trafikbook();
        BeanUtils.copyProperties(tb, tbForm);
        if (isUpdate(request, tbForm)) {
            System.out.println("Update");
            tbService.update(tb);  
        } else {
            tbService.insert(tb);
            System.out.println("Insert");
        }
         populate(request);
        return mapping.findForward(Constants.LIST);

    }
    
    public ActionForward delete(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        String parm = request.getParameter("bogId");
        Integer id = Integer.valueOf(parm);
        tbService.delete(id);
        populate(request);
        return mapping.findForward(Constants.LIST);

    }
    
    public void populate(HttpServletRequest request) { 
        
        List trafikbooks = tbService.getAllTrafikbook();
        Paging pages = new Paging();
        int page = pages.getPage(); 
         try{
	       page = Integer.parseInt(request.getParameter("page"));
		}catch(NumberFormatException e){} 

        pages.setPage(page);
        pages.setList(trafikbooks);      
        request.setAttribute(Constants.TRAFIKBOOKS, pages);
        request.setAttribute(Constants.EMPLOYEES, empService.getAllEmployee());
        request.setAttribute(Constants.VOGNS, vognService.getAllVogn());
       
    }    
    
     private boolean isUpdate(HttpServletRequest request, TrafikbookForm tbForm) {
        boolean updateFlag = true;           
        String id = tbForm.getBogId();        
        if (id == null || id.trim().length() == 0 || Integer.parseInt(id) == 0) {
            updateFlag = false;
        }
        request.setAttribute("updateFlag", Boolean.valueOf(updateFlag));
        return updateFlag;
    }
}