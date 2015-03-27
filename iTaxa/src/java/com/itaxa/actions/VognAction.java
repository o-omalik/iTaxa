/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itaxa.actions;

import com.itaxa.beans.Vogn;
import com.itaxa.forms.VognForm;
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
public class VognAction extends DispatchAction {

    private static VognDao vognService = new VognDaoImp();

    public ActionForward getVogn(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        populate(request);
        return mapping.findForward(Constants.LIST);

    }
    
    public ActionForward setUpForInsertOrUpdate(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        VognForm vognForm = (VognForm) form;
        if (isUpdate(request, vognForm)) {
            Integer id = Integer.valueOf(vognForm.getVognId());
            Vogn vogn = vognService.getVogn(id);
            BeanUtils.copyProperties(vognForm, vogn);
        }
        return mapping.findForward(Constants.FORM);
    }
    
     public ActionForward insertOrUpdate(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        VognForm vognForm = (VognForm) form;       
        Vogn vogn = new Vogn();
        BeanUtils.copyProperties(vogn, vognForm);

        if (isUpdate(request, vognForm)) {
            vognService.updateVogn(vogn);
        } else {
            vognService.insertVogn(vogn);
        }
        populate(request);
        return mapping.findForward(Constants.LIST);      
    }
     
    public ActionForward delete(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

        String parm = request.getParameter("vognId");
        Integer id = Integer.parseInt(parm);
        vognService.deleteVogn(id);
        populate(request);
        return mapping.findForward(Constants.LIST);
    }

   
    public void populate(HttpServletRequest request) {
        List vogns =vognService.getAllVogn();
        Paging pages = new Paging();
        int page = pages.getPage(); 
         try{
	       page = Integer.parseInt(request.getParameter("page"));
		}catch(NumberFormatException e){} 

        pages.setPage(page);
        pages.setList(vogns);
        request.setAttribute(Constants.VOGNS, pages);
    }
    
    private boolean isUpdate(HttpServletRequest request, VognForm vognForm) {
        boolean updateFlag = true;
        String id = vognForm.getVognId();
        if (id == null || id.trim().length() == 0 || Integer.parseInt(id) == 0) {
            updateFlag = false;
        }
        request.setAttribute("updateFlag", Boolean.valueOf(updateFlag));
        return updateFlag;
    }
}