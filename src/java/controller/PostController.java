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

/**
 *
 * @author Klotor90
 */
public class PostController extends SimpleFormController {

    public PostController() {
        setCommandClass(LinkedPost.class);
        setCommandName("post");
        setSuccessView("postSuccessView");
        setFormView("postFormView");
    }

    //@Override
    //protected void doSubmitAction(Object command) throws Exception {
    //    throw new UnsupportedOperationException("Not yet implemented");
    //}
    //Use onSubmit instead of doSubmitAction 
    //when you need access to the Request, Response, or BindException objects
    @Override
    protected ModelAndView onSubmit(
            HttpServletRequest request,
            HttpServletResponse response,
            Object command,
            BindException errors) throws Exception {
        ModelAndView mv = new ModelAndView(getSuccessView());
        
        mv.addObject("postMessage","Dziękujemy za wysłanie wwpisu.");
        
        return mv;
    }

}