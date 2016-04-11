package core.impl;

import core.INumberChecker;
import org.apache.commons.lang3.math.NumberUtils;

/**
 * User: LazarevEvgeny
 * Date: 11.04.2016
 */
public class NumberUtilsDelegator implements INumberChecker {
    @Override
    public boolean isDigit(String str) {
        return NumberUtils.isNumber(str);
    }

}
