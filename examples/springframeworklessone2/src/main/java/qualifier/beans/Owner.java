package qualifier.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import primary.beans.Cat;

@Component
public class Owner {

    //scenario 1
    @Autowired
    @Qualifier("cat1")
    private primary.beans.Cat cat;// fetch a same object from spring context
//    private Cat cat = new Cat();//It will create a new object.

    public primary.beans.Cat getCat() {
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