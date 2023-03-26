package scenario3.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import scenario3.config.ProjectConfig;
import scenario3.services.ProductDeliveryServices;

public class Main {
    /**
     * How to create beans
     *
     * XML
     * Annotations
     */
    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(ProjectConfig.class)) {
            ProductDeliveryServices service = context.getBean(ProductDeliveryServices.class);
            service.addSomeProducts();
        }
    }
}
