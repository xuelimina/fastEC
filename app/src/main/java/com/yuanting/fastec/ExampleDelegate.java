package com.yuanting.fastec;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.yuanting.latte_core.delegates.LatteDelegate;
import com.yuanting.latte_core.net.RestClient;
import com.yuanting.latte_core.net.callback.IError;
import com.yuanting.latte_core.net.callback.IFailure;
import com.yuanting.latte_core.net.callback.IRequest;
import com.yuanting.latte_core.net.callback.ISuccess;

/**
 * Created on 2018/4/24 15:53
 * Created by 薛立民
 * TEL 13262933389
 */
public class ExampleDelegate extends LatteDelegate {
    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {
        testRestClient();
    }

    @Override
    public Object setLayout() {
        return R.layout.delegate_example;
    }

    private void testRestClient() {
        RestClient.builder().url("https://d.carbros.cn:4433/index")
                .loader(getContext())
                .onRequest(new IRequest() {
                    @Override
                    public void onRequestStart() {

                    }

                    @Override
                    public void onRequestEnd() {

                    }
                }).success(new ISuccess() {
            @Override
            public void onSuccess(String response) {
//                Toast.makeText(getContext(), response, Toast.LENGTH_LONG).show();
            }
        }).error(new IError() {
            @Override
            public void onError(int code, String msg) {

            }
        }).failure(new IFailure() {
            @Override
            public void onFailure() {

            }
        }).build().get();
    }
}
