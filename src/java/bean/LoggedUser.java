/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import javax.ejb.Stateful;

/**
 *
 * @author klotor90
 */
@Stateful
public class LoggedUser {

    private static Person loggedUser;
    
    /**
     *
     * @param person
     */
    public static void setLoggedUser(Person person) {
        LoggedUser.loggedUser = person;
    }
    

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    /**
     *
     * @return
     */
    
    public static String getLoggedUser() {
        if(LoggedUser.loggedUser == null)
        {
            return "Niezalogowany";
        }
        return LoggedUser.loggedUser.getPersName();
    }

    /**
     *
     * @return
     */
    public static String getLoggedUserId() {
        if(LoggedUser.loggedUser == null)
        {
            return "dupa";
        }
        return  Integer.toString(LoggedUser.loggedUser.getUserId());
    }

    /**
     *
     * @return
     */
    public static int getLoggedUserAdmin() {
       if(LoggedUser.loggedUser == null)
       {
           return 0;
       }
       else if(loggedUser.isIsAdmin())
       {
           return 1;
       }
       else
       {
           return 0;
       }
    }
    
    
}
