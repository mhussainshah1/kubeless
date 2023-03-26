package qualifier.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import qualifier.config.ProjectConfig;
import qualifier.demo.Person;

public class Main {
    public static void main(String[] args) {
        try(var c = new AnnotationConfigApplicationContext(ProjectConfig.class)){
            Person p = c.getBean(Person.class);
            p.sayHello("Bill");
        }
    }
}