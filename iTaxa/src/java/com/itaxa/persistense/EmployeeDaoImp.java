/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itaxa.persistense;

import com.itaxa.beans.Employee;
import java.sql.SQLException;
import java.util.List;


/**
 *
 * @author adnankaramat
 */
public class EmployeeDaoImp extends ConfigDb implements EmployeeDao {
   
    public List getAllEmployee() {
        List employees = null;
        try {
            employees = sqlMap.queryForList("Employee.getAll", null);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return employees;
    }

    public Employee getEmployee(Integer id) {
        Employee emp = null;
        try {
            emp = (Employee) sqlMap.queryForObject("Employee.getById", id);
        } catch (SQLException e) {
           System.out.println(e);
        }
        return emp;
    }

    public void insertEmployee(Employee emp) {
        try {
            sqlMap.insert("Employee.insert", emp);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void updateEmployee(Employee emp) {
        try {
            sqlMap.update("Employee.update", emp);
        } catch (SQLException e) {
             System.out.println(e);
        }
    }

    public void delete(Integer id) {
        try {
            sqlMap.delete("Employee.delete", id);
        } catch (SQLException e) {
            System.out.println(e);
        }


    }
}
