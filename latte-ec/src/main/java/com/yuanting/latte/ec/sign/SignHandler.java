package com.yuanting.latte.ec.sign;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yuanting.latte.ec.database.DatabaseManager;
import com.yuanting.latte.ec.database.UserProfile;
import com.yuanting.latte_core.app.AccountManager;

/**
 * Created on 2018/5/2 10:20
 * Created by 薛立民
 * TEL 13262933389
 */
public class SignHandler {

    public static void onSignUp(String response ,ISignListener signListener) {
        final JSONObject profileJson = JSON.parseObject(response).getJSONObject("data");
        final long userId = profileJson.getLong("userId");
        final String name = profileJson.getString("name");
        final String avatar = profileJson.getString("avatar");
        final String gender = profileJson.getString("gender");
        final String address = profileJson.getString("address");
        final UserProfile profile = new UserProfile(userId, name, avatar, gender, address);
        DatabaseManager.getInstance().getDao().insert(profile);
        AccountManager.setSignState(true);
        signListener.onSignUpSuccess();
    }
    public static void onSignIn(String response ,ISignListener signListener) {
        final JSONObject profileJson = JSON.parseObject(response).getJSONObject("data");
        final long userId = profileJson.getLong("userId");
        final String name = profileJson.getString("name");
        final String avatar = profileJson.getString("avatar");
        final String gender = profileJson.getString("gender");
        final String address = profileJson.getString("address");
        final UserProfile profile = new UserProfile(userId, name, avatar, gender, address);
        DatabaseManager.getInstance().getDao().insert(profile);
        AccountManager.setSignState(true);
        signListener.onSignInSuccess();
    }
}
