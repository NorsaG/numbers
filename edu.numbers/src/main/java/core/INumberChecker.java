package core;

import java.util.List;

/**
 * User: LazarevEvgeny
 * Date: 11.04.2016
 */
public interface INumberChecker {
    boolean isDigit(String str);

    default void performanceTest(List<String> hot, List<String> real) {
        hot.forEach(this::isDigit);
        long time = System.currentTimeMillis();

        real.forEach(this::isDigit);
        System.out.print( (System.currentTimeMillis() - time) + "ms\n");
    }


}
