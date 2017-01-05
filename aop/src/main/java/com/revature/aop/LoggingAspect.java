package com.revature.aop;

import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Aspect: 
 * 	Module that addresses the "Logging" cross-cutting concern
 */
@Aspect
@Component
public class LoggingAspect {
	
	@Around("execution(public int moreFun(..))")
	public Integer around(ProceedingJoinPoint pjp) throws Throwable{
		// BEFORE
		long start = new Date().getTime();
		// tell method to Go
		Integer returned = null;
		try {
			returned = (Integer) pjp.proceed();
		} catch (Throwable e) {
			System.out.println("Advice caught exception " + e.getClass());
		}
		
		// AFTER
		long end = new Date().getTime();
		long completion = end - start;
		System.out.println("Method " + pjp.getSignature() 
			+ " completed in " + completion + "ms");
		
		returned = 90001; // changed value actually returned back 
		return returned;
	}
	
	@After("stubby()")
	public void funfunfunfun(){
		System.out.println("@After..");
	}
	
	@AfterThrowing(pointcut="stubby()", throwing="e")
	public void getException(JoinPoint jp, Exception e){
		System.out.println(e.getClass() + " was thrown by "
				+ jp.getSignature());
	}
	
	@AfterReturning(pointcut="stubby()", returning="value")
	public void logFun(JoinPoint jp, String value){
		value = " new value ";
		System.out.println(jp.getSignature() + " returned " + value);
	}
	
	@After("stub()") // before pointcut
	public void logNoArg(JoinPoint jp){
		System.out.println("BEFORE: method invoked was " + jp.getSignature());
	}
	
	/**
	 * 
	 * POINTCUTS BELOW
	 * 
	 */
	@Pointcut("execution(* do*(..))")  // pointcut expression
	public void stub(){}
	
	@Pointcut("execution(* fun())")
	public void stubby(){}
}









