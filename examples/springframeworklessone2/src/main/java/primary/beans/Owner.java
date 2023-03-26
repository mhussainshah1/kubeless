package primary.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Owner {

    @Autowired
    private Cat cat;// fetch a same object from spring context
//    private Cat cat = new Cat();//It will create a new object.

    public Cat getCat() {
        return cat;
    }

    public void setCat(Cat cat) {
        this.cat = cat;
    }

    @Override
    public String toString() {
        return "Owner{cat=" + cat + '}';
    }
}