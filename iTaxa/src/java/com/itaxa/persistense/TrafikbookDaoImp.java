/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.itaxa.persistense;

import com.itaxa.beans.Trafikbook;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author adnan
 */
public class TrafikbookDaoImp extends ConfigDb implements TrafikbookDao {

    public List getAllTrafikbook() {
      List trafikbooks = null;
      try{
          trafikbooks = sqlMap.queryForList("Trafikbook.getAll", null);
      }catch(SQLException e){
        System.out.println("Getting trafikbook list failed: " + e);
        Logger.getLogger(TrafikbookDaoImp.class.getName()).log(Level.INFO, null, e);
      }
      return trafikbooks;
    }

    public Trafikbook getTrafikbook(Integer id) {
        Trafikbook trafikbook = null;
        try{
            trafikbook = (Trafikbook) sqlMap.queryForObject("Trafikbook.getById", id);
        }catch(SQLException e){
        System.out.println("Gettting trafikbook failed: " + e);
        Logger.getLogger(TrafikbookDaoImp.class.getName()).log(Level.INFO, null, e);
        }
        return trafikbook;
        
    }

    public void update(Trafikbook tb) {
        try{
        sqlMap.update("Trafikbook.update", tb);
        }catch(SQLException e){
        System.out.println("Update Failed: " + e);
        Logger.getLogger(TrafikbookDaoImp.class.getName()).log(Level.INFO, null, e);
        }
    }

    public void insert(Trafikbook tb) {
      try{
          sqlMap.insert("Trafikbook.insert", tb);
      }catch(SQLException e){
          System.out.println("Insert failed: " + e);
          Logger.getLogger(TrafikbookDaoImp.class.getName()).log(Level.INFO, null, e);
      }  
    }

    public void delete(Integer id) {
       try{
           sqlMap.delete("Trafikbook.delete", id);
       }catch(SQLException e){
       System.out.println("Delete trafikbook: " + e);
       Logger.getLogger(TrafikbookDaoImp.class.getName()).log(Level.INFO, null, e);
       }  
    }

    public List search(Trafikbook trafikbook) {
        List tbList = null;
        try {
            tbList = sqlMap.queryForList("Trafikbook.searchByDriver", trafikbook);
        } catch (SQLException e) {
            Logger.getLogger(TrafikbookDaoImp.class.getName()).log(Level.INFO, null, e);
        }
        return tbList;
    }
   
}
