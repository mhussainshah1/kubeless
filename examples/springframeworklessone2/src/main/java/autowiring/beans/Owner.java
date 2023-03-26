package autowiring.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Owner {

    //scenario 1
    @Autowired
    private Cat cat;// fetch a same object from spring context
//    private Cat cat = new Cat();//It will create a new object.
 /*
    //scenario 2
    private final Cat cat;
    @Autowired
    public Owner(Cat cat) {
        this.cat = cat;
    }

    //scenario 3
    private Cat cat;

    @Autowired
    public void setCat(Cat cat) {
        //some other stuff as well
        this.cat = cat;
    }
*/
    public Cat getCat() {
        return cat;
    }

    @Override
    public String toString() {
        return "Owner{cat=" + cat + '}';
    }
}