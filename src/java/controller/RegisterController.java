/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.Person;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.servlet.ModelAndView;
import service.UniversalService;

/**
 *
 * @author Klotor90
 */
public class RegisterController extends SimpleFormController {

    private UniversalService universalService;

    /**
     *
     * @param universalService
     */
    public void setUniversalService(UniversalService universalService) {
        this.universalService = universalService;
    }

    /**
     *
     */
    public RegisterController() {
//klasa odpowiedzialna za dane przesyłane z formularza:
        setCommandClass(Person.class);
//nazwa powiązana z beanem przesyłanym z formularza:
        setCommandName("person");
//podpięcie widoku następującego po wysłaniu formularza:
        setSuccessView("userWelcomeView");
//podpięcie widoku formularza:
        setFormView("userFormView");
    }

    /**
     *
     * @param command
     * @throws Exception
     */
    @Override
    protected void doSubmitAction(Object command) throws Exception {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    /**
     *
     * @param request
     * @param response
     * @param command
     * @param errors
     * @return
     * @throws Exception
     */
    @Override
    protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, org.springframework.validation.BindException errors) throws Exception {
        Person person = (Person) command;
        ModelAndView mv = new ModelAndView(getSuccessView());
        mv.addObject("welcomeMessage", universalService.personWelcome(person));
        universalService.addPerson(person);
        return mv;
    }
}
