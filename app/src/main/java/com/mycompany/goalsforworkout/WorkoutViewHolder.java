package com.mycompany.goalsforworkout;

import android.view.View;
import android.widget.TextView;

/**
 * Created by user on 06.06.2015.
 */
public class WorkoutViewHolder implements ViewHolder<Workout> {

    TextView title;

    @Override
    public void storeView(View convertView) {
        title = (TextView)convertView.findViewById(R.id.workout_title);
    }

    @Override
    public void fillView(Workout item) {
        title.setText(item.getTitle());
    }
}
