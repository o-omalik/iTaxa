/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itaxa.persistense;

import com.itaxa.beans.Vogn;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author adnankaramat
 */
public class VognDaoImp extends ConfigDb implements VognDao {

    public List getAllVogn() {
        List vogns = null;
        try {
            vogns = sqlMap.queryForList("Vogn.getAll", null);
        } catch (SQLException e) {
            System.out.println("Getting vognlist " + e);
        }
        return vogns;
    }

    public void deleteVogn(Integer id) {
        try {
            sqlMap.delete("Vogn.delete", id);
        } catch (SQLException e) {
            System.out.println("Deleting vogns " + e);
        }
    }
    public Vogn getVogn(Integer id) {
        Vogn vogn = null;
        try {
          vogn = (Vogn) sqlMap.queryForObject("Vogn.getById", id);
        } catch (SQLException e) {
           System.out.println("Getting Vogn " + e);
        }
        return vogn;
    }

    public void insertVogn(Vogn vogn) {
        try {
            sqlMap.insert("Vogn.insert", vogn);
        } catch (SQLException e) {
           System.out.println("Insert Vogn " + e); 
        }
    }

    public void updateVogn(Vogn vogn) {
        try {
            sqlMap.update("Vogn.update", vogn);
        } catch (SQLException e) {
            System.out.println("Update vogn" + e);
        }
    }
    
}
