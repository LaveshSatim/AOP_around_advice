package com.lavesh.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)
public class LoggingAspect {

	@Around(value = "execution(* com.lavesh.bean.Calculator.add(..))")
	public Object logging(ProceedingJoinPoint joinPoint) throws Throwable {

		Object[] args = joinPoint.getArgs();

		System.out.println("args length " + args.length);
		System.out.println(args[0] + "   " + args[1]);

		Object object = joinPoint.proceed();

		return object;

	}
}
