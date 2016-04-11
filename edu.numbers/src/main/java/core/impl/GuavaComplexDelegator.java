package core.impl;

import com.google.common.primitives.Floats;
import core.INumberChecker;

/**
 * User: LazarevEvgeny
 * Date: 11.04.2016
 */
public class GuavaComplexDelegator implements INumberChecker {
    @Override
    public boolean isDigit(String str) {
        return Floats.tryParse(str) != null;
    }
}
