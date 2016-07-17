package scu.miomin.com.shareward.activity.recyclerview.adapter;

import android.content.Context;

import com.scu.miomin.sharewardlib.widgets.recyclerview.ShareMultiItemCommonAdapter;
import com.scu.miomin.sharewardlib.widgets.recyclerview.ShareMultiItemTypeSupport;
import com.scu.miomin.sharewardlib.widgets.recyclerview.holder.ShareViewHolder;

import java.util.List;

import scu.miomin.com.shareward.R;
import scu.miomin.com.shareward.activity.recyclerview.bean.ChatMessage;


/**
 * Created by 莫绪旻 on 16/6/24.
 */
public class ChatAdapter extends ShareMultiItemCommonAdapter<ChatMessage> {

    public ChatAdapter(Context context, List<ChatMessage> datas) {

        super(context, datas, new ShareMultiItemTypeSupport<ChatMessage>() {
            @Override
            public int getLayoutId(int itemType) {
                if (itemType == ChatMessage.RECIEVE_MSG) {
                    return R.layout.item_chat_from_msg;
                } else
                    return R.layout.item_chat_send_msg;
            }

            @Override
            public int getItemViewType(int postion, ChatMessage msg) {
                if (msg.isComMeg()) {
                    return ChatMessage.RECIEVE_MSG;
                }
                return ChatMessage.SEND_MSG;
            }
        });
    }

    @Override
    public void convert(ShareViewHolder holder, ChatMessage chatMessage) {

        switch (holder.getLayoutId()) {
            case R.layout.item_chat_from_msg:
                holder.setText(R.id.chat_from_content, chatMessage.getContent());
                holder.setText(R.id.chat_from_name, chatMessage.getName());
                holder.setImageResource(R.id.chat_from_icon, chatMessage.getIcon());
                break;
            case R.layout.item_chat_send_msg:
                holder.setText(R.id.chat_send_content, chatMessage.getContent());
                holder.setText(R.id.chat_send_name, chatMessage.getName());
                holder.setImageResource(R.id.chat_send_icon, chatMessage.getIcon());
                break;
        }
    }
}
