/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.LoginWrapper;
import bean.Person;
import bean.User;
import java.net.BindException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import service.UniversalService;

/**
 *
 * @author Klotor90
 */
public class LoginController extends SimpleFormController {

    private UniversalService universalService;

    public void setUniversalService(UniversalService universalService) {
        this.universalService = universalService;
    }

    public LoginController() {
        setCommandClass(User.class);
        setCommandName("user");
        setSuccessView("userWelcomeView");
        setFormView("loginFormView");
    }

    @Override
    protected void doSubmitAction(Object command) throws Exception {
        throw new UnsupportedOperationException("Not yet implemented");
    }


    @Override
    protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, org.springframework.validation.BindException errors) throws Exception {
        User user = (User) command;
        LoginWrapper loginWrapper = universalService.logIn(user);
        Person person = loginWrapper.getPerson();
        ModelAndView mv = new ModelAndView(getSuccessView());
        if (person == null) {
            mv.addObject("welcomeMessage", loginWrapper.getMessage());
        } else {
            mv.addObject("welcomeMessage", universalService.personWelcome(person));
        }
        return mv;
    }
}
