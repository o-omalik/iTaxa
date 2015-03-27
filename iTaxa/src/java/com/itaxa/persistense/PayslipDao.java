/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itaxa.persistense;

import com.itaxa.beans.Payslip;

/**
 *
 * @author adnan
 */
public interface PayslipDao {

    public double getTotal(Payslip payslip);

    public void insert(Payslip payslip);

    public void update(Payslip payslip);

    public void delete(Integer id);
}
