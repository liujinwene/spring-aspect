package com.test.config.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAspect {
	//方法执行前调用  
	@Before("execution (* com..*.*hello(..))")  
	public void before() {  
		System.out.println("before");  
	}

	@Around("execution (* com..*.*hello(..))")
	public Object around(ProceedingJoinPoint point) throws Throwable {  
		System.out.println("around-before");
		Object result = point.proceed();
		System.out.println("around-after.result=" + result);
		return result;
	}

	//方法执行前调用  
	@After("execution (* com..*.*hello(..))")  
	public void after() {  
		System.out.println("after");
	}

	@AfterReturning(
			pointcut="execution (* com..*.*hello(..))",
			returning="result")
	public Object afterReturning(Object result) {
		System.out.println("afterReturning.result=" + result);
		return result;
	}	
}
