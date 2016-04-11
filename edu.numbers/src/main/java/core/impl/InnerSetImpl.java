package core.impl;

import core.INumberChecker;

import java.util.HashSet;
import java.util.Set;

/**
 * User: LazarevEvgeny
 * Date: 11.04.2016
 */
public class InnerSetImpl implements INumberChecker {

    private static Set<String> intSet = new HashSet<>();

    static {
        for (int i = 0; i < Integer.MAX_VALUE / 1000000; i++) {
            intSet.add(String.valueOf(i));
        }
    }

    @Override
    public boolean isDigit(String str) {
        return intSet.contains(str);
    }

}
