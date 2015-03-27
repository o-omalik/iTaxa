/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itaxa.persistense;

import com.itaxa.beans.Vogn;
import java.util.List;

/**
 *
 * @author adnankaramat
 */
public interface VognDao {

    public List getAllVogn();
    
    public void insertVogn(Vogn vogn);
    
    public void updateVogn(Vogn vogn);
    
    public void deleteVogn(Integer id);
    
    public Vogn getVogn(Integer id);
}
