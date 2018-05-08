package com.yuanting.latte_core.app;

import com.yuanting.latte_core.util.storage.LattePreference;

/**
 * Created on 2018/5/2 11:41
 * Created by 薛立民
 * TEL 13262933389
 */
public class AccountManager {
    private enum SignTag {
        SIGN_TAG
    }

    public static void setSignState(boolean state) {
        LattePreference.setAppFlag(SignTag.SIGN_TAG.name(), state);
    }

    private static boolean isSignIn() {
        return LattePreference.getAppFlag(SignTag.SIGN_TAG.name());
    }

    public static void checkAccont(IUserChecker checker) {
        if (isSignIn()) {
            checker.onSignIn();
        } else {
            checker.onNoSignIn();
        }
    }
}
