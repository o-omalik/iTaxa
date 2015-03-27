/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itaxa.persistense;

import com.itaxa.beans.Employee;
import java.util.List;

/**
 *
 * @author adnankaramat
 */
public interface EmployeeDao {

    public List getAllEmployee();

    public Employee getEmployee(Integer id);

    public void insertEmployee(Employee emp);

    public void updateEmployee(Employee emp);

    public void delete(Integer id);
}
