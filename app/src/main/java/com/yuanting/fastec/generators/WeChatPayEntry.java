package com.yuanting.fastec.generators;

import com.yuanting.latte_annotations.annotations.PayEntryGenerator;
import com.yuanting.latte_core.wechat.template.WXPayEntryTemplate;

/**
 * Created on 2018/5/2 18:09
 * Created by 薛立民
 * TEL 13262933389
 */
@PayEntryGenerator(packageName = "com.yuanting.fastec", payEntryTemplete = WXPayEntryTemplate.class)
public interface WeChatPayEntry {
}
