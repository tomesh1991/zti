/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import javax.ejb.Stateless;
import service.UniversalService;

/**
 *
 * @author klotor90
 */
@Stateless
public class ShowPosts {
    
    private UniversalService universalService;
    
    /**
     *
     * @return
     */
    public String show() {
        String toShow = new String();
        toShow = universalService.showPosts(1);
        System.out.println(toShow);
        return toShow;
    }
    
}
