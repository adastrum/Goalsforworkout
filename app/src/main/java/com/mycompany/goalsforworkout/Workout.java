package com.mycompany.goalsforworkout;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by asus on 31.05.2015.
 */
public class Workout {
    static final String WORKOUT_TITLE_DEFAULT = "untitled";

    private String mTitle;
    private Calendar mStartDate;
    private Calendar mEndDate;
    private List<ExerciseSet> mSets;
    private int mCurrentSetIndex;

    Workout() {
        mTitle = WORKOUT_TITLE_DEFAULT;
        initialize();
    }

    Workout(String title) {
        mTitle = title;
        initialize();
    }

    void initialize() {
        mSets = new ArrayList();
        mCurrentSetIndex = 0;
    }

    void addSet(ExerciseSet set) {
        mSets.add(set);
    }

    void addSetRange(List<ExerciseSet> sets) {
        mSets.addAll(sets);
    }

    void start() {
        mStartDate = Calendar.getInstance();
        if (!mSets.isEmpty()) {
            ExerciseSet currentSet = mSets.get(mCurrentSetIndex);
            currentSet.start();
        }
    }

    void stop() {
        mEndDate = Calendar.getInstance();
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public long getId() {
        return mStartDate.getTimeInMillis();
    }
}
