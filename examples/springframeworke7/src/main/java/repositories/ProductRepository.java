package repositories;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

//The class communicate with database
@Repository
@Transactional
public class ProductRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @PostConstruct //called during the creation of bean right after injection of bean
    public void init(){

    }

    public void addProduct(String name){
        String sql = "INSERT INTO Product VALUES(NULL,?)";
        jdbcTemplate.update(sql,name);
    }
}
