/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.LoggedUser;
import bean.LoginWrapper;
import bean.Person;
import bean.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import service.UniversalService;

/**
 * klasa kontrolera służacego do obsługi zalogowania się użytkownika
 * @author Klotor90
 */
public class LoginController extends SimpleFormController {

    private UniversalService universalService;

    /**
     * metoda konfigurująca obiekt pośredniczący pom. kontrolerem a warstwą DAO
     * @param universalService [UniversalService]
     */
    public void setUniversalService(UniversalService universalService) {
        this.universalService = universalService;
    }

    /**
     * kostruktor klasy kontrolera
     */
    public LoginController() {
        setCommandClass(User.class);
        setCommandName("user");
        setSuccessView("userWelcomeView");
        setFormView("loginFormView");
    }

    /**
     * metoda obsługująca akcję zalogowania się użytkownika
     * @param request
     * @param response
     * @param command
     * @param errors
     * @return
     * @throws Exception
     */
    @Override
    protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, org.springframework.validation.BindException errors) throws Exception {
        User user = (User) command;
        LoginWrapper loginWrapper = universalService.logIn(user);
        Person person = loginWrapper.getPerson();
        ModelAndView mv = new ModelAndView(getSuccessView());
        LoggedUser.setLoggedUser(person);
        if (person == null) {
            mv.addObject("welcomeMessage", loginWrapper.getMessage());
        } else {
            mv.addObject("welcomeMessage", universalService.personWelcome(person));
        }
        return mv;
    }
}
