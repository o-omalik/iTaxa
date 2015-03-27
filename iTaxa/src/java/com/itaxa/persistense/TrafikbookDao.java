/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itaxa.persistense;

import com.itaxa.beans.Trafikbook;
import java.util.List;

/**
 *
 * @author adnan
 */
public interface TrafikbookDao {

    public List getAllTrafikbook();

    public Trafikbook getTrafikbook(Integer id);

    public void update(Trafikbook tb);

    public void insert(Trafikbook tb);

    public void delete(Integer id);
    
    public List search(Trafikbook trafikbook);

}
