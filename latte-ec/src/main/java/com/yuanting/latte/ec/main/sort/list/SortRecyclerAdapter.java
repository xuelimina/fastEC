package com.yuanting.latte.ec.main.sort.list;

import com.yuanting.latte.ec.main.sort.SortDelegate;
import com.yuanting.latte_core.ui.recycler.MultipleItemEntity;
import com.yuanting.latte_core.ui.recycler.MultipleRecyclerAdapter;

import java.util.List;

/**
 * Created on 2018/5/7 17:58
 * Created by 薛立民
 * TEL 13262933389
 */
public class SortRecyclerAdapter extends MultipleRecyclerAdapter {
    private final SortDelegate DELEGATE;

    private SortRecyclerAdapter(List<MultipleItemEntity> data, SortDelegate delegate) {
        super(data);
        this.DELEGATE = delegate;
//        addItemType();
    }
}
