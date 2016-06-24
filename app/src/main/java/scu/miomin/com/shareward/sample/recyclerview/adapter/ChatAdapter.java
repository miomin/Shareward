package scu.miomin.com.shareward.sample.recyclerview.adapter;

import android.content.Context;

import java.util.List;

import scu.miomin.com.shareward.R;
import scu.miomin.com.shareward.sample.recyclerview.bean.ChatMessage;
import scu.miomin.com.shareward.widgets.recyclerview.ShareMultiItemCommonAdapter;
import scu.miomin.com.shareward.widgets.recyclerview.ShareMultiItemTypeSupport;
import scu.miomin.com.shareward.widgets.recyclerview.holder.ShareViewHolder;


/**
 * Created by zhy on 15/9/4.
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
