import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author Xin Chen
 * @date 2018/3/2 14:12
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-cache-test.xml"})
public class AppTests {

    private static CountDownLatch latch = new CountDownLatch(1);

    private final static Logger LOG = LoggerFactory.getLogger(AppTests.class);

    @Autowired
    private CacheManager manager;

    @Test
    public void test1() throws InterruptedException {
        Cache cache = manager.getCache("hello");
        for (int i = 0; i < 1000; i++) {
            cache.put(new Element(i,new TestObject(i,new Date())));
            LOG.info("ADD {}, size {}, mem {}",new Object[]{i,cache.getSize(),cache.getMemoryStoreSize()});
        }

        latch.await(5, TimeUnit.SECONDS);
    }
}
