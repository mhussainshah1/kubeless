package scenario2.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import scenario2.beans.MyBean;
import scenario2.config.ProjectConfig;

public class Main {
    /**
     * How to create beans
     *
     * XML
     * Annotations
     */
    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(ProjectConfig.class)) {

            //By type
            MyBean b1 = context.getBean(MyBean.class);
            MyBean b2 = context.getBean(MyBean.class);
            MyBean b3 = context.getBean(MyBean.class);

            //b1 , b2 and b3 are same bean because scope of application is singleton
            System.out.println(b1.getText());
            System.out.println(b2.getText());
            System.out.println(b3.getText());
        }

        MyBean b4 = new MyBean();
        System.out.println(b4.getText());//@PostConstruct will not call because b4 is not part of context.
    }
}
