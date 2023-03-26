package aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class HelloServiceAspect {
  /*
    //Joint Point
    //specify the logic decouple from normal business code

    //execute before method
    @Before("execution(* services.HelloService.hello(..))")
    public void before(){
        System.out.println("A");
    }

    //execute after method
    @After("execution(* services.HelloService.hello(..))")
    public void after(){
        System.out.println("B");
    }

    //execute when method return without exception
    @AfterReturning("execution(* services.HelloService.hello(..))")
    public void afterReturning(){
        System.out.println("C");
    }

    //execute when method throw exception
    @AfterThrowing("execution(* services.HelloService.hello(..))")
    public void afterThrowing(){
        System.out.println("D");
    }
    */

    //most powerful aspect. It can use instead of all of the above
    //Do something before and something after
    @Around("execution(* services.HelloService.hello(..))")
    public Object around(ProceedingJoinPoint jointPoint) { //ProceedingJoinPoint object represented the method is being executed
        //before the execution of method
        System.out.println("A");
        Object result = null;
        try {
            //execution of method

            result =  //jointPoint.proceed();
                    jointPoint.proceed(new Object[]{"Bill"});//use to replace parameter of method
            //after the execution of method
            System.out.println("B");
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return result; //"Something else :)";
    }
}
