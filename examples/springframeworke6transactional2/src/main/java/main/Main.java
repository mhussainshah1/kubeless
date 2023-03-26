package main;

import config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import services.ProductService;

public class Main {
    public static void main(String[] args) {
        try(var c = new AnnotationConfigApplicationContext(ProjectConfig.class)){
            ProductService service = c.getBean(ProductService.class);

//            service.addTenProduct();// no transaction
//            service.addTenProductWithException();//no transaction

//            service.addTenProductRequiresNew();// no transaction

//            service.addTenProductMandatoryWithTransaction();// no transaction
//            service.addTenProductMandatoryWithoutTransaction();// no transaction

//            service.addTenProductNeverWithTransaction();// no transaction
//            service.addTenProductNeverWithoutTransaction();// no transaction

//            service.addTenProductSupportWithTransaction();// no transaction
//            service.addTenProductSupportWithoutTransaction();// no transaction

//            service.addTenProductNestedtWithTransaction();// no transaction
//            service.addTenProductNestedtWithoutTransaction();
            service.addTenProductNestedtWithException();
        }
    }
}