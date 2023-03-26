package scenario3.repositories;

import org.springframework.stereotype.Repository;

//@Component
@Repository
public class ProductRepository {
    public void add(){
        System.out.println("a new product is added");
    }
}
