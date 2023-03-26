package primary.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import primary.beans.Cat;

@Configuration
@ComponentScan(basePackages = "primary.beans")
public class ProjectConfig {

    @Bean
    @Primary
    public Cat cat1(){
        Cat cat = new Cat();
        cat.setName("Tom");
        return cat;
    }

    @Bean
//    @Primary // a bean pick up if we have multiple same type bean in context
    public Cat cat2(){
        Cat cat = new Cat();
        cat.setName("Leo");
        return cat;
    }
}
