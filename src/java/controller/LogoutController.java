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
 * klasa kontrolera służacego do obsługi wylogowania się użytkownika
 * @author Klotor90
 */
public class LogoutController extends SimpleFormController {

    private UniversalService universalService;
    
    /**
     * metoda konfigurująca obiekt pośredniczący pom. kontrolerem a warstwą DAO
     * @param universalService [UniversalService]
     */
    public void setUniversalService(UniversalService universalService) {
        this.universalService = universalService;
    }
    
    /**
     * konstruktor klasy kontrolera
     */
    public LogoutController() {
        setCommandClass(Person.class);
        setCommandName("logout");
        setSuccessView("logoutFormView");
        setFormView("logoutFormView");
    }
    
    //Use onSubmit instead of doSubmitAction 
    //when you need access to the Request, Response, or BindException objects

    /**
     * metoda obsługująca akcję wylogowania się użytkownika
     * @param request
     * @param response
     * @param command
     * @param errors
     * @return
     * @throws Exception
     */
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
