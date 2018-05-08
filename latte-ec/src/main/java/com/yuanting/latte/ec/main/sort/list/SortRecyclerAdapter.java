package com.yuanting.latte.ec.main.sort.list;

import android.support.v4.content.ContextCompat;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;

import com.yuanting.latte.ec.R;
import com.yuanting.latte.ec.main.sort.SortDelegate;
import com.yuanting.latte_core.ui.recycler.ItemType;
import com.yuanting.latte_core.ui.recycler.MultipleFields;
import com.yuanting.latte_core.ui.recycler.MultipleItemEntity;
import com.yuanting.latte_core.ui.recycler.MultipleRecyclerAdapter;
import com.yuanting.latte_core.ui.recycler.MultipleViewHolder;

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
        //添加处置菜单布局
        addItemType(ItemType.VERTICAL_MENU_LIST, R.layout.item_vertical_menu_list);
    }

    @Override
    protected void convert(MultipleViewHolder holder, MultipleItemEntity entity) {
        super.convert(holder, entity);
        switch (holder.getItemViewType()) {
            case ItemType.VERTICAL_MENU_LIST:
                final String text = entity.getField(MultipleFields.TEXT);
                final boolean isClicked = entity.getField(MultipleFields.TAG);
                final AppCompatTextView name = holder.getView(R.id.tv_vertical_item_name);
                final View line = holder.getView(R.id.view_line);
                final View itemView = holder.itemView;
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });
                if (!isClicked) {
                    line.setVisibility(View.INVISIBLE);
                    name.setTextColor(ContextCompat.getColor(mContext, R.color.we_chat_black));
                }
                break;
            default:
                break;
        }
    }
}
