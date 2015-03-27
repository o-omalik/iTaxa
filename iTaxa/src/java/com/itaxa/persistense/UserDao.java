/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.itaxa.persistense;

import com.itaxa.beans.User;
import javax.naming.AuthenticationException;

/**
 *
 * @author adnan
 */
public interface UserDao {
public User authenticate(String username, String password)throws AuthenticationException;
}
