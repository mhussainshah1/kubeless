package primary.demo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class HelloServiceEn implements HelloService{
    @Override
    public String sayHello(String name) {
        return "Hello, " + name + "!";
    }
}
