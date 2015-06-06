package com.mycompany.goalsforworkout;

import android.view.View;
import android.widget.TextView;

/**
 * Created by user on 06.06.2015.
 */
public class ExerciseSetViewHolder implements ViewHolder<ExerciseSet> {

    TextView title;

    @Override
    public void storeView(View convertView) {
        title = (TextView) convertView.findViewById(R.id.exercise_set_title);
    }

    @Override
    public void fillView(ExerciseSet item) {
        title.setText(item.getTitle());
    }
}
