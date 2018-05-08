package com.yuanting.latte_core.wechat.template;

import com.yuanting.latte_core.wechat.BaseWXEntryActivity;
import com.yuanting.latte_core.wechat.LatteWeChat;

/**
 * Created on 2018/5/2 18:05
 * Created by 薛立民
 * TEL 13262933389
 */
public class WXEntryTemplate extends BaseWXEntryActivity {

    @Override
    protected void onResume() {
        super.onResume();
        finish();
        overridePendingTransition(0, 0);

    }

    @Override
    protected void onSignInSuccess(String userInfo) {
        LatteWeChat.getInstance().getSignInCallBack().onSignInSuccess(userInfo);
    }
}
