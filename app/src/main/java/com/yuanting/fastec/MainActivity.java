package com.yuanting.fastec;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.widget.Toast;

import com.yuanting.latte.ec.laucher.LauncherDelegate;
import com.yuanting.latte.ec.main.EcBottomDelegate;
import com.yuanting.latte.ec.sign.ISignListener;
import com.yuanting.latte.ec.sign.SignInDelegate;
import com.yuanting.latte_core.activites.ProxyActivity;
import com.yuanting.latte_core.app.Latte;
import com.yuanting.latte_core.delegates.LatteDelegate;
import com.yuanting.latte_core.ui.laucher.ILauncherListener;
import com.yuanting.latte_core.ui.laucher.OnLauncherFinishTag;

import qiu.niorgai.StatusBarCompat;

public class MainActivity extends ProxyActivity implements ISignListener, ILauncherListener {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        Latte.getConfigurator().withActivity(this);
        StatusBarCompat.translucentStatusBar(this, true);
    }

    @Override
    public LatteDelegate setRootDelegate() {
        return new LauncherDelegate();
    }

    @Override
    public void onSignInSuccess() {
        Toast.makeText(this, "登录成功", Toast.LENGTH_LONG).show();
        startWithPop(new EcBottomDelegate());
    }

    @Override
    public void onSignUpSuccess() {
        Toast.makeText(this, "注册成功", Toast.LENGTH_LONG).show();
        startWithPop(new SignInDelegate());
    }

    @Override
    public void onLauncherFinish(OnLauncherFinishTag tag) {
        switch (tag) {
            case SIGNED:
                startWithPop(new EcBottomDelegate());
                break;
            case NOT_SIGNED:
                startWithPop(new SignInDelegate());
                break;
            default:
                break;
        }
    }
}
