package services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import repositories.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    /**
     *
     *  Problems With Synchronous Transaction:
     *  1) Dirty Reads -    the uncommitted transaction (T2) can be seen by other transaction (T1) and T1 read the wrong value if T2 rollbacks.
     *                      T1 --------$10-----------------------$20(read)-----------------> read 20
     *                      T2-----------------------$20-----------------------------------> if rollbacks then actual value is 10 not 20
     *
     *  2) Repeatable Read - the committed transaction (T2) can be seen by other transaction (T1), and if we have multiple read of T1 in a time then it would give different values.
     *                       T1 --------$10-----------------------$20(read)----------------> read 20
     *                       T2-----------------------$20 (commit)------------------------->
     *
     *  3) Phantom Reads - The later addition of data is in a group of record is called phantom data.
     *                       T1 --------100 product-------------------total 110 product-----> 10 phantom products appear at end which were not at beggining
     *                       T2-----------------------10 product (add)---------------------->
     *
     *  Isolation Level: when two or more transaction run simultaneously. We can apply isolation level for consistency of data.
     *  --------------
     *  1) DEFAULT -            not declared from @Transaction, and it is taken from under layer. It is normally read committed
     *  2) READ_UNCOMMITTED -   The one transaction can see the uncommitted change of another transaction.
     *                          It gives fast performance and low consistency. This isolation level use in website having posting messages
     *  3) READ_COMMITTED -     use to avoid dirty reads
     *  4) REPEATABLE_READ -    use to avoid dirty and repeatable reads
     *  5) SERIALIZABLE -       use to avoid dirty, repeatable reads and phantom reads
     *
     *

     */
    @Transactional(isolation =  Isolation.READ_COMMITTED)
    public void addTenProduct(){
        for (int i = 0; i < 10; i++) {
            productRepository.addProduct("Product " + i);
        }
    }
}
