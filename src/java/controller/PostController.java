/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.LinkedPost;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import service.UniversalService;

/**
 * klasa kontrolera służacego do obsługi dodawania nowych postów
 * @author Klotor90
 */
public class PostController extends SimpleFormController {

    private UniversalService universalService;
    
    /**
     * metoda konfigurująca obiekt pośredniczący pom. kontrolerem a warstwą DAO
     * @param universalService [UniversalService]
     */
    public void setUniversalService(UniversalService universalService) {
        this.universalService = universalService;
    }
    
    /**
     * domyślny konstruktor klasy
     */
    public PostController() {
        setCommandClass(LinkedPost.class);
        setCommandName("linkedPost");
        setSuccessView("postSuccessView");
        setFormView("postFormView");
    }

    /**
     * metoda obsługująca dodawanie nowych postów użytkowników
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
        LinkedPost post = (LinkedPost) command;
        mv.addObject("postMessage", "Dziękujemy za wysłanie posta");
        universalService.addLinkedPost(post);
        
        return mv;
    }

}
