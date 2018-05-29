package com.yuanting.latte_core.delegates.bottom;

import android.widget.Toast;

import com.yuanting.latte_core.R;
import com.yuanting.latte_core.app.Latte;
import com.yuanting.latte_core.delegates.LatteDelegate;

/**
 * Created on 2018/5/3 13:54
 * Created by 薛立民
 * TEL 13262933389
 */
public abstract class BottomItemDelegate extends LatteDelegate  {
    // 再点一次退出程序时间设置
    private static final long WAIT_TIME = 2000L;
    private long TOUCH_TIME = 0;

    @Override
    public boolean onBackPressedSupport() {
        if (System.currentTimeMillis() - TOUCH_TIME < WAIT_TIME) {
            _mActivity.finish();
        } else {
            TOUCH_TIME = System.currentTimeMillis();
            Toast.makeText(_mActivity, "双击退出" + Latte.getApplicationContext().getString(R.string.app_name), Toast.LENGTH_SHORT).show();
        }
        return true;
    }
}
