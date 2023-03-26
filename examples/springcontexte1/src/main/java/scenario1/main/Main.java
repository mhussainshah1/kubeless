package scenario1.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import scenario1.beans.MyBean;
import scenario1.config.ProjectConfig;

public class Main {
    /**
     * XML
     * Annotations
     *
     * spring context - collection of instances managed by spring. Any object need to know and managed by sping then we have to put in context
     */
    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(ProjectConfig.class)) {
           //by name
            /*
            MyBean b1 = context.getBean("myBean1", MyBean.class);
            MyBean b2 = context.getBean("myBean2", MyBean.class);
            MyBean b3 = context.getBean("myBean1", MyBean.class);
            */

            //or

            MyBean b1 = context.getBean("A", MyBean.class);
            MyBean b2 = context.getBean("B", MyBean.class);
            MyBean b3 = context.getBean("A", MyBean.class);
        }
    }
}
