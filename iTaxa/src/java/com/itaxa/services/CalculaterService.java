/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.itaxa.services;


/**
 *
 * @author adnan
 */
public class CalculaterService {
    
    public double add(double amount1, double amount2){      
          return amount1 + amount2;
    }
    
    public double substract(double amount1, double amount2){       
        return amount1 - amount2;
    }
    
    public double multiply(double amount1, double amount2){
          return amount1 * amount2;
    }
    
    public double divide(double amount1, double amount2){
        return amount1/amount2;
    }
}
