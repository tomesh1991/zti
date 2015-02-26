/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.LoggedUser;
import bean.Person;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import service.UniversalService;

/**
 *
 * @author Klotor90
 */
public class LogoutController extends SimpleFormController {

    private UniversalService universalService;
    
    public void setUniversalService(UniversalService universalService) {
        this.universalService = universalService;
    }
    
    public LogoutController() {
        setCommandClass(Person.class);
        setCommandName("logout");
        setSuccessView("logoutFormView");
        setFormView("logoutFormView");
    }
    
    //Use onSubmit instead of doSubmitAction 
    //when you need access to the Request, Response, or BindException objects
    @Override
    protected ModelAndView onSubmit(
            HttpServletRequest request,
            HttpServletResponse response,
            Object command,
            BindException errors) throws Exception {
        ModelAndView mv = new ModelAndView(getSuccessView());
        LoggedUser.setLoggedUser(null);
        mv.addObject("info","Wylogowano");
        
        return mv;
    }
}
