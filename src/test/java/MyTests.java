import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author Xin Chen
 * @date 2018/3/2 14:12
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class MyTests {

    @Autowired
    private CacheManager manager;

    @Test
    public void test1(){
        Cache cache = manager.getCache("xinchen");
    }
}
