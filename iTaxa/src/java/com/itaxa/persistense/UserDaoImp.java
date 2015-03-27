/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.itaxa.persistense;

import com.itaxa.beans.User;
import java.sql.SQLException;
import javax.naming.AuthenticationException;

/**
 *
 * @author adnan
 */
public class UserDaoImp extends ConfigDb implements UserDao {

    public User authenticate(String username, String password)throws AuthenticationException {
        User user = null;
        try{
            user = (User) sqlMap.queryForObject("User.authenticate", username);
        }catch(SQLException e){
            System.out.print(e);
        }
        return user;
    }

}
