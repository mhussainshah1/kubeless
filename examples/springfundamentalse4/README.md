## Inversion of Control

Application control by framework instead of classes written by user

## Annotation

- metadata to tell spring how to control classes

## @Aspect

- specify the logic decouple from normal business code
- It is used to add functionality to the method not replacing the logic
- It is weaved into the source code
  eg- Transactional, Security

## @Advice

## Joint Point

specify the logic decouple from normal business code

### @Before ("execution(* <package_name.class_name.method_names(..)>)")

Joint point will be executed before the set of methods define in the value of annotation
Around

### @Before("execution(* <package_name.class_name.method_names(..)>)")
execute before method

### @After("execution(* <package_name.class_name.method_names(..)>)")
execute after method
    
### @AfterReturning("execution(* <package_name.class_name.method_names(..)>)")
execute when method return without exception

### @AfterThrowing("execution(* <package_name.class_name.method_names(..)>)")
execute when method throw exception

### @Around("execution(* <package_name.class_name.method_names(..)>)"")
Do something before and something after
most powerful aspect. It can use instead of all of the above
    
### ProceedingJoinPoint 
object represented the method is being executed


