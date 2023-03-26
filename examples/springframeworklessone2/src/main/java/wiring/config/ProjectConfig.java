package wiring.config;

import wiring.beans.Cat;
import wiring.beans.Owner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectConfig {
    @Bean
    public Cat cat() {
        Cat c = new Cat();
        c.setName("Tom");
        return c;
    }
   /* @Bean
    public Owner owner() {
        Owner o = new Owner();
//        o.setCat(new Cat()); // this cat object is not bean and outside of context
        o.setCat(cat());//wiring - this cat() method giving the bean if exist from context instead of making a new one
        return o;
    }*/
   @Bean
//   @Autowired
   public Owner owner(Cat cat) {//spring inject the value from context into the parameter
                                // check is there bean of argument's type and inject if it is there in context
       Owner o = new Owner();
       o.setCat(cat);
       return o;
   }
}