/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 *
 * @author Klotor90
 */
@Aspect
public class LoggerAspect {

    @Pointcut("execution(* service.*.*(..))")
    private void selectAll() {
    }

    @Pointcut("execution(* service.UniversalService.getPerson(..))")
    private void getPerson() {
    }

    /**
     *
     * @param joinPoint
     */
    @Before("selectAll()")
    public void beforeMethod(JoinPoint joinPoint) {
        System.out.println("Before excecution of method ["
                + joinPoint.getSignature().getName() + "]");
    }

    /**
     *
     * @param joinPoint
     */
    @After("selectAll()")
    public void afterMethod(JoinPoint joinPoint) {
        System.out.println("After excecution of method ["
                + joinPoint.getSignature().getName() + "]");
    }

    /**
     *
     * @param retVal
     */
    @AfterReturning(pointcut = "getPerson()", returning = "retVal")
    public void afterReturningMethod(Object retVal) {
        System.out.println("Method getPerson() returning:" + retVal.toString());
    }
}

