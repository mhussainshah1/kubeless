package scenario2.beans;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Component // with this way, we can not create more than one instance of type
//@Controller
//@Service
//@Repository
public class MyBean {
    //whatever you want here
    private  String text;

    @PostConstruct //use with object managed by context. It call after the constructor call or creation of component
    private void init(){
        this.text = "HELLO";
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
