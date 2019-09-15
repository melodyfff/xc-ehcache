import java.io.Serializable;
import java.util.Date;

/**
 * @author Xin Chen (xinchenmelody@gmail.com)
 * @version 1.0
 * @date Created In 2018/11/18 22:45
 */
public class TestObject implements Serializable {
    private int name;

    private Date date;

    TestObject(){}


    public TestObject(int name, Date date) {
        this.name = name;
        this.date = date;
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }
}
