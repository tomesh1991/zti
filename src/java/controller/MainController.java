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
 *
 * @author Klotor90
 */
public class MainController extends SimpleFormController {

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
    public MainController() {
        setCommandClass(LinkedPost.class);
        setCommandName("show");
        setSuccessView("mainView");
        setFormView("mainView");
    }
    
    //Use onSubmit instead of doSubmitAction 
    //when you need access to the Request, Response, or BindException objects

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
    protected ModelAndView onSubmit(
            HttpServletRequest request,
            HttpServletResponse response,
            Object command,
            BindException errors) throws Exception {
        ModelAndView mv = new ModelAndView(getSuccessView());

        mv.addObject("posts",universalService.showPosts(1));
        
        return mv;
    }
}
