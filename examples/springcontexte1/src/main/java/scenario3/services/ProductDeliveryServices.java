package scenario3.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import scenario3.repositories.ProductRepository;

//@Component
@Service // To do some work
public class ProductDeliveryServices {

    //1
    @Autowired //instruct spring to take object from context and inject in to the reference.
    private ProductRepository productRepository;

   /* //2
    @Autowired
    public ProductDeliveryServices(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    //3
    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }*/

    public void addSomeProducts() {
        productRepository.add();
        productRepository.add();
        productRepository.add();
    }
}
