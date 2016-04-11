package core.impl;

import core.INumberChecker;

/**
 * User: LazarevEvgeny
 * Date: 11.04.2016
 */
public class SimpleMatcher implements INumberChecker {
    @Override
    public boolean isDigit(String str) {
        return str.matches("[-+]?\\d+");
    }

}
