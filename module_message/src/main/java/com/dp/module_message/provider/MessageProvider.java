package com.dp.module_message.provider;

import android.content.Context;

import androidx.fragment.app.Fragment;

import com.alibaba.android.arouter.facade.annotation.Route;


import com.dp.module_message.fragment.MessageFragment;
import com.ly.base_module.provider.IMessageProvider;

/**
 * Description: <NewProvider><br>
 * Update:     <br>
 */
@Route(path = "/message/main", name = "消息")
public class MessageProvider implements IMessageProvider {

    @Override
    public void init(Context context) {

    }

    @Override
    public Fragment getMessageFragment() {
        return MessageFragment.newInstance();
    }
}
