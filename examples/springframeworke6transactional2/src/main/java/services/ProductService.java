package services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import repositories.ProductRepository;

@Service
public class ProductService {
    /**
     * <br>
     * <b>REQUIRED</b> - It the default propagation. It creates new transaction when there is no transaction
     * but uses existing transaction if there is transaction. It rollback everything if exception occurs
     * <br>
     * <b>REQUIRES_NEW</b> - always create a new transaction. It rollbacks the only transaction where exception occurs
     * <br>
     * <b>MANDATORY</b> - must have existing transaction otherwise throw exception
     * <br>
     * <b>NEVER</b> - must not have existing transaction otherwise throw exception
     * <br>
     * <b>SUPPORT</b> - Do not create tranaction. It executes with and without existing transaction
     * <br>
     * <b>NOT_SUPPORTED</b> - Do not create tranaction. It executes without existing transaction
     * <br>
     * <b>NESTED</b> - create transaction within another transaction. Exception in nested transaction wont roll back
     * enclosed transaction but error in enclosed transaction can rollback everything.
     * <p>
     * <p>
     * addTenProduct*() --> addProduct*()
     */

    @Autowired
    private ProductRepository productRepository;

    //REQUIRED
    @Transactional
    public void addTenProduct() { //create transaction
        for (int i = 1; i <= 10; i++) {
            productRepository.addProduct("Product " + i);// use previous transaction
        }
    }//commits transaction

    @Transactional
    public void addTenProductWithException() { //create transaction
        for (int i = 1; i <= 10; i++) {
            productRepository.addProduct("Product " + i);// use previous transaction
            if (i == 5) throw new RuntimeException(":(");
        }
    }// rollback transaction

    //REQUIRES_NEW
    @Transactional
    public void addTenProductRequiresNew() { //create transaction
        for (int i = 1; i <= 10; i++) {
            productRepository.addProductRequiresNew("Product " + i);//always create new transaction
            if (i == 5) throw new RuntimeException(":(");
        }
    }//rollback first transaction

    //MANDATORY
    @Transactional
    public void addTenProductMandatoryWithTransaction() { //create transaction
        for (int i = 1; i <= 10; i++) {
            productRepository.addProductMandatory("Product " + i);// use previous transaction
            if (i == 5) throw new RuntimeException(":(");
        }
    }// commits transaction

    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public void addTenProductMandatoryWithoutTransaction() {
        for (int i = 1; i <= 10; i++) {
            productRepository.addProductMandatory("Product " + i);
            if (i == 5) throw new RuntimeException(":(");
        }
    }

    //NEVER
    @Transactional
    public void addTenProductNeverWithTransaction() {//create transaction
        for (int i = 1; i <= 10; i++) {
            productRepository.addProductNever("Product " + i);
        }
    }// commits transaction

    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public void addTenProductNeverWithoutTransaction() {
        for (int i = 1; i <= 10; i++) {
            productRepository.addProductNever("Product " + i);
        }
    }

    //SUPPORT
    @Transactional
    public void addTenProductSupportWithTransaction() {//create transaction
        for (int i = 1; i <= 10; i++) {
            productRepository.addProductSupport("Product " + i);
        }
    }// commits transaction

    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public void addTenProductSupportWithoutTransaction() {
        for (int i = 1; i <= 10; i++) {
            productRepository.addProductSupport("Product " + i);
        }
    }

    //NESTED
    @Transactional
    public void addTenProductNestedtWithTransaction() { //create transaction
        for (int i = 1; i <= 10; i++) {
            productRepository.addProductNested("Product " + i);//create new transaction
        }
    }//commits transaction

    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public void addTenProductNestedtWithoutTransaction() {
        for (int i = 1; i <= 10; i++) {
            productRepository.addProductNested("Product " + i);//create new transaction
        }
    }

    @Transactional
    public void addTenProductNestedtWithException() { //create transaction
        for (int i = 1; i <= 10; i++) {
            productRepository.addProductNested("Product " + i);//create new transaction
            if (i == 5) throw new RuntimeException(":(");
        }
    }//commits transaction
}
