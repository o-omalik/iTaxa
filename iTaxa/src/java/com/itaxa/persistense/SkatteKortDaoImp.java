/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.itaxa.persistense;

import com.itaxa.beans.SkatteKort;
import java.sql.SQLException;
import java.util.List;


/**
 *
 * @author adnan
 */
public class SkatteKortDaoImp extends ConfigDb implements SkatteKortDao {

    public List getAllSkatteKort() {
        List skattekorts = null;
        try{
            skattekorts = sqlMap.queryForList("SkatteKort.getAll", null);
        }catch(SQLException e){
        System.out.println(e);
        }
        return skattekorts;
    }
    
    public SkatteKort getById(Integer id) {
        SkatteKort skattekort = null;
        try{
            skattekort = (SkatteKort) sqlMap.queryForObject("SkatteKort.getById", id);
        }catch(SQLException e){
            System.out.println(e);
        }
        return skattekort;
    }
    public void insert(SkatteKort sk) {
        try{
            sqlMap.insert("SkatteKort.insert", sk);
        }catch(SQLException e){
        System.out.println(e);
        }
    }

    public void update(SkatteKort sk) {
        try{
            sqlMap.update("SkatteKort.update", sk);
        }catch(SQLException e){
        System.out.println(e);
        }
    }

    public void delete(Integer id) {
        try{
            sqlMap.delete("SkatteKort.delete", id);
        }catch(SQLException e){
        System.out.println(e);
        }
    }    

}
