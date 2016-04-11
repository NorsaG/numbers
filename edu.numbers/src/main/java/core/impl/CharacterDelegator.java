package core.impl;

import core.INumberChecker;

/**
 * User: LazarevEvgeny
 * Date: 11.04.2016
 */
public class CharacterDelegator implements INumberChecker {
    @Override
    public boolean isDigit(String str) {
        if (str == null || str.isEmpty()) return false;
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) return false;
        }
        return true;
    }

}
