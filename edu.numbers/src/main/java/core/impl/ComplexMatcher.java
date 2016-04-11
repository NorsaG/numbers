package core.impl;

import core.INumberChecker;

/**
 * User: LazarevEvgeny
 * Date: 11.04.2016
 */
public class ComplexMatcher implements INumberChecker {
    @Override
    public boolean isDigit(String str) {
        return str.matches("^(-?([1-9][0-9]{0,8}" +
                "       |1[0-9]{9}" +
                "       |20[0-9]{8}" +
                "       |21[0-3][0-9]{7}" +
                "       |214[0-6][0-9]{6}" +
                "       |2147[0-3][0-9]{5}" +
                "       |21474[0-7][0-9]{4}" +
                "       |214748[0-2][0-9]{3}" +
                "       |2147483[0-5][0-9]{2}" +
                "       |21474836[0-3][0-9]" +
                "       |214748364[0-7]" +
                "      )" +
                "    |-2147483648" +
                "    |0)$");
    }


}
