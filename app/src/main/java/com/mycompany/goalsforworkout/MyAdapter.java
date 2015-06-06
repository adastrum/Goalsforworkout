package com.mycompany.goalsforworkout;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by user on 06.06.2015.
 */
public abstract class MyAdapter extends BaseAdapter {
    private LayoutInflater mInflater;
    private int mResource;
    private List mItems;

    public MyAdapter(Context context, int resource, List items) {
        mInflater = LayoutInflater.from(context);
        mResource = resource;
        mItems = items;
    }

    @Override
    public int getCount() {
        return mItems.size();
    }

    @Override
    public Object getItem(int position) {
        return mItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if (convertView == null) {
            convertView = mInflater.inflate(mResource, null);

            viewHolder = getViewHolder();
            viewHolder.storeView(convertView);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.fillView(getItem(position));

        return convertView;
    }

    abstract ViewHolder getViewHolder();
}