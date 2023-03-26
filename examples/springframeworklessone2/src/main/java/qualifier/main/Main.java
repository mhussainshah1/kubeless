package qualifier.main;

import qualifier.beans.Owner;
import qualifier.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        try (var c = new AnnotationConfigApplicationContext(ProjectConfig.class)) {

//            Cat x = c.getBean(Cat.class);
            Owner o = c.getBean(Owner.class);

//            x.setName("Leo");
//            System.out.println(x);
            System.out.println(o);
        }
    }
}
