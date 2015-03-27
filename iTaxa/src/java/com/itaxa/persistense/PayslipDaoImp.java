/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.itaxa.persistense;

import com.itaxa.beans.Payslip;
import java.sql.SQLException;


/**
 *
 * @author adnan
 */
public class PayslipDaoImp extends ConfigDb implements PayslipDao{

    public double getTotal(Payslip payslip) {
        double total = 0.0;
        try {
            
            total = (Double) sqlMap.queryForObject("Payslip.getTotal", payslip);
            payslip.setIndkoert(total);
             
        } catch (SQLException ex) {
            System.out.println(ex + "" + total);
        }
        return total;
    }

    public void insert(Payslip payslip) {
        try {
            sqlMap.insert("Payslip.insert", payslip);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
    }

    public void update(Payslip payslip) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
