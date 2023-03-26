package scenario1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import scenario1.beans.MyBean;

@Configuration
public class ProjectConfig {

    @Bean("A")
    public MyBean myBean1(){ //the name shouldn`t be verb or action
        MyBean b = new MyBean();
        b.setText("Hello");
        return b;
    }

    //instance of same type
    @Bean("B")
    public MyBean myBean2(){
        MyBean b = new MyBean();
        b.setText("World");
        return b;
    }
}
