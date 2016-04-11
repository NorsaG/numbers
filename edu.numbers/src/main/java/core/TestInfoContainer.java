package core;

import core.impl.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * User: LazarevEvgeny
 * Date: 11.04.2016
 */
public class TestInfoContainer {

    private final static int RANDOM_OFFSET = 100000;

    private final static int HOT_COUNT = 10000;
    private final static int REAL_COUNT = 1000000;

    private final static String[] STRING_FOR_TESTING = {"1", "1.1", "1.11", "1.0", "-1",
            "-1.0", "-1.1", "4563575687468353456", "1l", "1L", "1f", "1F", "0xCAFEBABE", "1F",
            "10000000000000000000000000000000000000000000000000", "1.26767E108"};

    private final static INumberChecker[] IMPL_LIST = {
            new CharacterDelegator(), new ComplexMatcher(), new InnerSetImpl(),
            new NumberUtilsDelegator(), new SimpleMatcher(), new GuavaDelegator(),
            new SimpleMatcherWithDot(), new SimpleParser(), new GuavaComplexDelegator()};

    public static void testStrings() {
        for (INumberChecker check : IMPL_LIST) {
            System.out.println("Start checking examples for " + check.getClass().getName());
            for (String s : STRING_FOR_TESTING)
                if (!check.isDigit(s))
                    System.out.println(s + " => " + check.isDigit(s));
            System.out.println("End test");
            System.out.println("!!!!!!!!!!!!!!!!!!!!!\n\n\n");
        }
    }

    public static void testPerformance() {
        for (INumberChecker check : IMPL_LIST) {
            System.out.println("\nStart performance test for    " + check.getClass().getName());
            System.out.print ("Ints: ");
            check.performanceTest(generateInt(HOT_COUNT), generateInt(REAL_COUNT));
            System.out.print("Numbers: ");
            check.performanceTest(generateRandomNumbers(HOT_COUNT), generateRandomNumbers(REAL_COUNT));
            System.out.print("Numbers with 25% errors: ");
            check.performanceTest(generateRandomNumbersWithError(HOT_COUNT), generateRandomNumbersWithError(REAL_COUNT));
            System.out.print("Small Ints: ");
            check.performanceTest(generateSmallInts(HOT_COUNT), generateSmallInts(REAL_COUNT));
        }
    }

    private static List<String> generateInt(int count) {
        Random r = new Random();
        List<String> results = new ArrayList<>();
        for (int i = 0; i < count; i++)
            results.add(String.valueOf(r.nextInt()));
        return results;
    }

    private static List<String> generateRandomNumbers(int count) {
        Random r = new Random();
        Random r2 = new Random();
        List<String> results = new ArrayList<>();
        for (int i = 0; i < count; i++)
            results.add(String.valueOf(r.nextInt() % RANDOM_OFFSET) + (r2.nextBoolean() ? "." : "") + String.valueOf(r.nextInt() % RANDOM_OFFSET));
        return results;
    }

    private static List<String> generateRandomNumbersWithError(int count) {
        Random r = new Random();
        Random r2 = new Random();
        List<String> results = new ArrayList<>();
        for (int i = 0; i < count; i++)
            results.add(String.valueOf(r.nextInt() % RANDOM_OFFSET) + (r2.nextBoolean() && r2.nextBoolean() ? "error" : "") + String.valueOf(r.nextInt() % RANDOM_OFFSET));
        return results;
    }

    private static List<String> generateSmallInts(int count) {
        Random r = new Random();
        List<String> results = new ArrayList<>();
        for (int i = 0; i < count; i++)
            results.add(String.valueOf(r.nextInt() % RANDOM_OFFSET));
        return results;
    }
}
