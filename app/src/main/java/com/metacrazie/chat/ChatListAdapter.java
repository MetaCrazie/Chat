package com.metacrazie.chat;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by praty on 30/12/2016.
 */

public class ChatListAdapter extends BaseAdapter {

    private Activity mContext;
    private ArrayList<String> mUsername;
    private ArrayList<String> mMessage;

    public ChatListAdapter(Activity context, ArrayList username, ArrayList message)
    {
        super();
        mContext=context;
        mUsername=username;
        mMessage=message;

    }

    @Override
    public int getCount() {
        return mMessage.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    private class ViewHolder{
        TextView mUserTextView;
        TextView mMessageTextView;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        ViewHolder holder;
        LayoutInflater inflater =  mContext.getLayoutInflater();

        if (convertView == null)
        {
            convertView = inflater.inflate(R.layout.chat_item, null);
            holder = new ViewHolder();
            holder.mUserTextView = (TextView) convertView.findViewById(R.id.chat_user);
            holder.mMessageTextView = (TextView) convertView.findViewById(R.id.chat_message);
            convertView.setTag(holder);
        }
        else
        {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.mUserTextView.setText(mUsername.get(i));
        holder.mMessageTextView.setText(mMessage.get(i));

        return convertView;
    }
}
