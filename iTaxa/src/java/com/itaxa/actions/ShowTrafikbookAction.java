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
import com.itaxa.services.Paging;
import java.util.Iterator;
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
public class ShowTrafikbookAction extends DispatchAction {
    
    private static TrafikbookDao tbService = new TrafikbookDaoImp();
    private static EmployeeDao empService = new EmployeeDaoImp();
    public ActionForward searchByDriver(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
         TrafikbookForm tbform = (TrafikbookForm) form;
         Trafikbook tbook = new Trafikbook();
         BeanUtils.copyProperties(tbook, tbform);
         Paging pages = new Paging();
         if(tbook !=null){
         List tblist = tbService.search(tbook);
         getTotal(tblist, tbook, tbform);
         int page = pages.getPage();
         try{
	       page = Integer.parseInt(request.getParameter("page"));
		}catch(NumberFormatException e){}
        
        pages.setPage(page);
        pages.setList(tblist);
        request.setAttribute(Constants.TRAFIKBOOKS, pages);
        }
        pages.setPage(1);
        request.setAttribute(Constants.EMPLOYEES, empService.getAllEmployee());
        return mapping.findForward(Constants.LIST);
    }

    public void getTotal(List list, Trafikbook book, TrafikbookForm form){
        double hours = 0.0;
        double cash = 0.0;
        double amount = 0.0;
        double km = 0.0;
        double credit = 0.0;
        double akonto = 0.0;
        double diesel = 0.0;
        double tours = 0.0;

    for(Iterator it = list.iterator(); it.hasNext();){
        book = (Trafikbook) it.next();
        hours = book.getHours() + hours;
        akonto = book.getAkonto() + akonto;
        cash = book.getCash() + cash;
        km = book.getKm() + km;
        amount = book.getEnheder() + amount;
        credit = book.getCredit() + credit;
        diesel = book.getDiverse() + diesel;
        tours = book.getTours() + tours;
        }
        form.setHours(Double.toString(hours));
        form.setAkonto(Double.toString(akonto));
        form.setCash(Double.toString(cash));
        form.setKm(Double.toString(km));
        form.setEnheder(Double.toString(amount));
        form.setCredit(Double.toString(credit));
        form.setDiverse(Double.toString(diesel));
        form.setTours(Double.toString(tours));

    }

}
