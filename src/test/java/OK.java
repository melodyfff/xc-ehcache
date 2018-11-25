import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * @author xinchen
 * @version 1.0
 * @date 20/11/2018 15:32
 */
public class OK {

    private final static Logger LOG = LoggerFactory.getLogger(OK.class);

    public static void main(String[] args) {
        Function<Integer, Integer> number = x -> x * 100;
        Function<Integer, Integer> square = x -> x * x;
        LOG.info(number.andThen(square).apply(2).toString());


        LOG.info(number.compose(square).andThen(String::valueOf).apply(2));

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        final Object collect = list.stream().filter(x -> x > 5).collect(Collectors.toList());

        System.out.println(collect);

        Supplier<TestObject> stringSupplier = TestObject::new;
        stringSupplier.get();


    }
}
