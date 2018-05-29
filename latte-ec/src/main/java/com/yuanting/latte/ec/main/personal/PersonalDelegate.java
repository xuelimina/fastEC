package com.yuanting.latte.ec.main.personal;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.yuanting.latte.ec.R;
import com.yuanting.latte.ec.R2;
import com.yuanting.latte.ec.main.personal.list.ListAdapter;
import com.yuanting.latte.ec.main.personal.list.ListBean;
import com.yuanting.latte.ec.main.personal.list.ListItemType;
import com.yuanting.latte.ec.main.personal.order.OrderListDelegate;
import com.yuanting.latte_core.delegates.bottom.BottomItemDelegate;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created on 2018/5/28 13:07
 * Created by 薛立民
 * TEL 13262933389
 */
public class PersonalDelegate extends BottomItemDelegate{
    public static final String ORDER_TYPE = "ORDER_TYPE";
    private Bundle mArgs = null;
    @BindView(R2.id.rv_personal_setting)
    RecyclerView mRvSettings = null;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mArgs = new Bundle();
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {

        final ListBean address = new ListBean.Builder()
                .setItemType(ListItemType.ITEM_NORMAL)
                .setId(1)
//                .setDelegate(new AddressDelegate())
                .setText("收货地址")
                .build();

        final ListBean system = new ListBean.Builder()
                .setItemType(ListItemType.ITEM_NORMAL)
                .setId(2)
//                .setDelegate(new SettingsDelegate())
                .setText("系统设置")
                .build();

        final List<ListBean> data = new ArrayList<>();
        data.add(address);
        data.add(system);

        //设置RecyclerView
        final LinearLayoutManager manager = new LinearLayoutManager(getContext());
        mRvSettings.setLayoutManager(manager);
        final ListAdapter adapter = new ListAdapter(data);
        mRvSettings.setAdapter(adapter);
//        mRvSettings.addOnItemTouchListener(new PersonalClickListener(this));
    }
    @OnClick(R2.id.tv_all_order)
    void onClickAllOrder() {
        mArgs.putString(ORDER_TYPE, "all");
        startOrderListByType();
    }

    private void startOrderListByType() {
        final OrderListDelegate delegate = new OrderListDelegate();
        delegate.setArguments(mArgs);
        getParentDelegate().getSupportDelegate().start(delegate);
    }
    @Override
    public Object setLayout() {
        return R.layout.delegate_personal;
    }
}
