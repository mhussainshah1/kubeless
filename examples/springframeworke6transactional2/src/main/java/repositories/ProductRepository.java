package repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
//@Transactional //apply to every method declare in the class
//@Transactional(propagation = Propagation.REQUIRED)//By Default
public class ProductRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional
    public void addProduct(String name){//receive the same transaction
        String sql = """
                    INSERT INTO Product
                    VALUES (NULL, ?)
                    """;
        jdbcTemplate.update(sql,name);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)//It overrides the transaction propagation level at class level
    public void addProductRequiresNew(String name){//create own transaction
        String sql = """
                    INSERT INTO Product
                    VALUES (NULL, ?)
                    """;
        jdbcTemplate.update(sql,name);
    }//commit own transaction

    @Transactional(propagation = Propagation.MANDATORY)
    public void addProductMandatory(String name){
        String sql = """
                    INSERT INTO Product
                    VALUES (NULL, ?)
                    """;
        jdbcTemplate.update(sql,name);
    }

    @Transactional(propagation = Propagation.NEVER)
    public void addProductNever(String name){
        String sql = """
                    INSERT INTO demo.Product
                    VALUES (NULL, ?)
                    """;
        jdbcTemplate.update(sql,name);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void addProductSupport(String name){
        String sql = """
                    INSERT INTO demo.Product
                    VALUES (NULL, ?)
                    """;
        jdbcTemplate.update(sql,name);
    }

    @Transactional(propagation = Propagation.NESTED)
    public void addProductNested(String name){//create own transaction
        String sql = """
                    INSERT INTO Product
                    VALUES (NULL, ?)
                    """;
        jdbcTemplate.update(sql,name);
    }//commit own transaction
}
