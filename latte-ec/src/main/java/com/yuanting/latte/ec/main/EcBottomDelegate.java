package com.yuanting.latte.ec.main;

import android.graphics.Color;

import com.yuanting.latte.ec.main.cart.ShopCartDelegate;
import com.yuanting.latte.ec.main.discover.DiscoverDelegate;
import com.yuanting.latte.ec.main.index.IndexDelegate;
import com.yuanting.latte.ec.main.personal.PersonalDelegate;
import com.yuanting.latte.ec.main.sort.SortDelegate;
import com.yuanting.latte_core.delegates.bottom.BaseBottomDelegate;
import com.yuanting.latte_core.delegates.bottom.BottomItemDelegate;
import com.yuanting.latte_core.delegates.bottom.BottomTabBean;
import com.yuanting.latte_core.delegates.bottom.ItemBuilder;

import java.util.LinkedHashMap;

/**
 * Created on 2018/5/3 16:31
 * Created by 薛立民
 * TEL 13262933389
 */
public class EcBottomDelegate extends BaseBottomDelegate {
    @Override
    public LinkedHashMap<BottomTabBean, BottomItemDelegate> setItems(ItemBuilder builder) {
        final LinkedHashMap<BottomTabBean, BottomItemDelegate> items = new LinkedHashMap<>();
        items.put(new BottomTabBean("{fa-home}", "主页"), new IndexDelegate());
        items.put(new BottomTabBean("{fa-sort}", "分类"), new SortDelegate());
        items.put(new BottomTabBean("{fa-compass}", "发现"), new DiscoverDelegate());
        items.put(new BottomTabBean("{fa-shopping-cart}", "购物车"), new ShopCartDelegate());
        items.put(new BottomTabBean("{fa-user}", "我的"), new PersonalDelegate());
        return builder.addItems(items).build();
    }

    @Override
    public int setIndexDelegate() {
        return 0;
    }

    @Override
    public int setClickedColor() {
        return Color.parseColor("#ffff8800");
    }
}
