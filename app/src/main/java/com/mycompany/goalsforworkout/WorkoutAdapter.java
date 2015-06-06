package com.mycompany.goalsforworkout;

import android.content.Context;

import java.util.List;

/**
 * Created by user on 06.06.2015.
 */
public class WorkoutAdapter extends MyAdapter {

    public WorkoutAdapter(Context context, int resource, List items) {
        super(context, resource, items);
    }

    @Override
    ViewHolder getViewHolder() {
        return new WorkoutViewHolder();
    }
}
