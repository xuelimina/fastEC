package com.yuanting.latte.ec.sign;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.view.View;

import com.yuanting.latte.ec.R;
import com.yuanting.latte.ec.R2;
import com.yuanting.latte_core.delegates.LatteDelegate;
import com.yuanting.latte_core.util.log.LatteLogger;
import com.yuanting.latte_core.wechat.LatteWeChat;
import com.yuanting.latte_core.wechat.callbacks.IWeChatSignInCallBack;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created on 2018/4/27 13:01
 * Created by 薛立民
 * TEL 13262933389
 */
public class SignInDelegate extends LatteDelegate {
    @BindView(R2.id.edit_sign_in_phone)
    TextInputEditText mPhone = null;
    @BindView(R2.id.edit_sign_in_password)
    TextInputEditText mPassword = null;
    private ISignListener mISignListener = null;
    @OnClick(R2.id.btn_sign_in)
    void onClickSignIn() {
        if (checkForm()) {
//            RestClient.builder().url("")
//                    .params("name", mName.getText().toString())
//                    .params("email", mEmail.getText().toString())
//                    .params("phone", mPhone.getText().toString())
//                    .params("password", mPassword.getText().toString())
//                    .success(new ISuccess() {
//                        @Override
//                        public void onSuccess(String response) {
//                            String userData = "{ \"code\" : 0,\"message\":\"ok\"," +
//                                    " \"data\": {" +
//                                    "\"seerId\":\"1\"," +
//                                    "\"name\":\"张三\"," +
//                                    "\"avatar\":\"1\"," +
//                                    "\"gender\":\"男\"," +
//                                    "\"address\":\"张江高科\",}} ";
//                            LatteLogger.json("user_profile",userData);
//                            SignHandler.onSignUp(userData);
//
//                        }
//                    }).build().post();
            String userData = "{ \"code\" : 0,\"message\":\"ok\"," +
                    " \"data\": {" +
                    "\"userId\":\"4\"," +
                    "\"name\":\"张三\"," +
                    "\"avatar\":\"1\"," +
                    "\"gender\":\"男\"," +
                    "\"address\":\"张江高科\",}} ";
            LatteLogger.json("user_profile", userData);
            SignHandler.onSignIn(userData, mISignListener);
        }
    }
    private void setTestString() {
        mPhone.setText("11111111111");
        mPassword.setText("123456");
    }
    @OnClick(R2.id.tv_link_sign_up)
    void linSignUp() {
        getSupportDelegate().start(new SignUpDelegate());
    }

    @OnClick(R2.id.tv_sign_in_wechat)
    void signInWeChat() {
        LatteWeChat.getInstance().onSignSuccess(new IWeChatSignInCallBack() {
            @Override
            public void onSignInSuccess(String userInfo) {

            }
        }).signIn();
    }

    private boolean checkForm() {
        final String phone = mPhone.getText().toString();
        final String password = mPassword.getText().toString();
        boolean isPass = true;
        if (phone.isEmpty() || phone.length() != 11) {
            mPhone.setError(getString(R.string.sign_up_delegate_phone_error));
            isPass = false;
        } else {
            mPhone.setError(null);
        }
        if (password.isEmpty() || password.length() < 6) {
            mPassword.setError(getString(R.string.sign_up_delegate_password_error));
            isPass = false;
        } else {
            mPassword.setError(null);
        }
        return isPass;
    }
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof ISignListener) {
            mISignListener = (ISignListener) activity;
        }
    }
    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {
        setTestString();
    }

    @Override
    public Object setLayout() {
        return R.layout.delegate_sign_in;
    }
}
