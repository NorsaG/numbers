package core.impl;

import com.google.common.primitives.Ints;
import core.INumberChecker;

/**
 * User: LazarevEvgeny
 * Date: 11.04.2016
 */
public class GuavaDelegator implements INumberChecker {
    @Override
    public boolean isDigit(String str) {
        return Ints.tryParse(str) != null;
    }
}
