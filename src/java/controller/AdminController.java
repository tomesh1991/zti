/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.LinkedPost;
import bean.LoggedUser;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import service.UniversalService;

/**
 * klasa kontrolera służacego do obsługi czynności administracyjnych
 * @author Klotor90
 */
public class AdminController extends SimpleFormController {

    UniversalService universalService;

    /**
     * metoda konfigurująca obiekt pośredniczący pom. kontrolerem a warstwą DAO
     * @param universalService [UniversalService]
     */
    public void setUniversalService(UniversalService universalService) {
        this.universalService = universalService;
    }

    /**
     * konstruktor domyślny klasy 
     */
    public AdminController() {
        setCommandClass(LinkedPost.class);
        setCommandName("MyCommandName");
        setSuccessView("adminFormView");
        setFormView("adminFormView");
    }

    /**
     * metoda obsługująca akceptowanie nowych postów użytkowników
     * @param request
     * @param response
     * @param command
     * @param errors
     * @return
     * @throws Exception
     */
    @Override
    protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, org.springframework.validation.BindException errors) throws Exception {
        String adminowanie = new String();
        adminowanie += "Posty do potwierdzenia:<br/>";
        adminowanie += universalService.showPosts(0);

        for (int i = 0; i < 1000; i++) {
            String s = new String();
            s = "accept" + i;
            if ((request.getParameter(s)) != null) {
                universalService.acceptPost(i);
            }
        }

        ModelAndView mv = new ModelAndView(getSuccessView());
        if (LoggedUser.getLoggedUserAdmin() != 1) {
            mv.addObject("adminText", "Nie jesteś adminem, nie masz dostępu do tej strony");
        } else {
            mv.addObject("adminText", adminowanie);
        }
        return mv;
    }
}
