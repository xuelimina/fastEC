package com.yuanting.latte.ec.main.sort.list;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.yuanting.latte.ec.R;
import com.yuanting.latte.ec.R2;
import com.yuanting.latte_core.delegates.LatteDelegate;
import com.yuanting.latte_core.net.RestClient;
import com.yuanting.latte_core.net.callback.ISuccess;
import com.yuanting.latte_core.ui.recycler.MultipleItemEntity;

import java.util.List;

import butterknife.BindView;

/**
 * Created on 2018/5/7 17:03
 * Created by 薛立民
 * TEL 13262933389
 */
public class VerticalListDelegate extends LatteDelegate {
    @BindView(R2.id.rv_vertical_menu_list)
    RecyclerView mRecyclerView = null;

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {
    }

    private void initRecyclerView() {
        final LinearLayoutManager manager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(manager);
        mRecyclerView.setItemAnimator(null);
    }

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
        RestClient.builder().url("sort_list_data.json")
                .loader(getContext())
                .success(new ISuccess() {
                    @Override
                    public void onSuccess(String response) {
                        final List<MultipleItemEntity> data = new VerticalListDelegateConverter().setJsonData(response).convert();
                    }
                }).build().get();
    }

    @Override
    public Object setLayout() {
        return R.layout.detegate_vertical_list;
    }
}
