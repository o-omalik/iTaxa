/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itaxa.persistense;

import com.itaxa.beans.SkatteKort;
import java.util.List;

/**
 *
 * @author adnan
 */
public interface SkatteKortDao {

    public List getAllSkatteKort();

    public void insert(SkatteKort sk);

    public void update(SkatteKort sk);

    public void delete(Integer id);

    public SkatteKort getById(Integer id);
    
}
