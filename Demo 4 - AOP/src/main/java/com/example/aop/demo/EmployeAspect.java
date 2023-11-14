package com.example.aop.demo;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class EmployeAspect {
  private final Logger logger = LoggerFactory.getLogger(this.getClass());

  @Around("execution(* com.example.aop.demo.*Controller.*(..))")
  public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable{
    long start = System.currentTimeMillis();
    Object result = joinPoint.proceed();
    long tpsExecution = System.currentTimeMillis() - start;

    logger.info(joinPoint.getSignature() + " executé en " + tpsExecution + "ms");
    return result;
  }
}
