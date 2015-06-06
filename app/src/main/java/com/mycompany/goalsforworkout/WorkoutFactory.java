package com.mycompany.goalsforworkout;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by user on 06.06.2015.
 */
public class WorkoutFactory {

    static final String PREFERENCE_NAME_WORKOUTS = "workouts";

    static final Gson gson = new Gson();

    private static SharedPreferences getSharedPreferences(Context context) {
        return context.getSharedPreferences(PREFERENCE_NAME_WORKOUTS, Context.MODE_PRIVATE);
    }

    public static List<Workout> loadWorkouts(Context context) {
        List<Workout> workouts = new ArrayList<Workout>();
        Map<String, ?> map = getSharedPreferences(context).getAll();
        for (Map.Entry<String, ?> entry : map.entrySet()) {
            String value = (String) entry.getValue();
            workouts.add(gson.fromJson(value, Workout.class));
        }
        return workouts;
    }

    public static void saveWorkouts(Context context, List<Workout> workouts) {
        SharedPreferences.Editor editor = getSharedPreferences(context).edit();
        for (Workout workout : workouts) {
            editor.putString(String.valueOf(workout.getId()), gson.toJson(workout));
        }
        editor.apply();
    }
}
