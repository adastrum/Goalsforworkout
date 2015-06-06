package com.mycompany.goalsforworkout;

import android.view.View;

/**
 * Created by user on 06.06.2015.
 */
public interface ViewHolder<T> {
    void storeView(View convertView);
    void fillView(T item);
}
