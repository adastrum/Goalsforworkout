package com.mycompany.goalsforworkout;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 06.06.2015.
 */
public class WorkoutLoader extends MyLoader<List<Workout>> {

    public WorkoutLoader(Context context) {
        super(context);
    }

    @Override
    public List<Workout> loadInBackground() {
        return WorkoutFactory.loadWorkouts(getContext());
    }
}
