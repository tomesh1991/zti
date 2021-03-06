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
 * element programowania aspektowego generująca log aplikacji na standardowe wyjście serwera 
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
     * metoda generująca komunikat przed wykonaniem metody
     * @param joinPoint
     */
    @Before("selectAll()")
    public void beforeMethod(JoinPoint joinPoint) {
        System.out.println("Before excecution of method ["
                + joinPoint.getSignature().getName() + "]");
    }

    /**
     * metoda generująca komunikat po wykonaniu metody
     * @param joinPoint
     */
    @After("selectAll()")
    public void afterMethod(JoinPoint joinPoint) {
        System.out.println("After excecution of method ["
                + joinPoint.getSignature().getName() + "]");
    }

    /**
     * metoda generująca komunikat o wyniku działania wykonanej metody
     * @param retVal
     */
    @AfterReturning(pointcut = "getPerson()", returning = "retVal")
    public void afterReturningMethod(Object retVal) {
        System.out.println("Method getPerson() returning:" + retVal.toString());
    }
}

