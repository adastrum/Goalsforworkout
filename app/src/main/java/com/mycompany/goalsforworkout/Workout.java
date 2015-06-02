package com.mycompany.goalsforworkout;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by asus on 31.05.2015.
 */
public class Workout {
    String mTitle;
    Date mStartDate;
    Date mEndDate;
    List<ExerciseSet> mSets;
    int mCurrentSetIndex;

    Workout() {
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
        mStartDate = new Date();
        if (!mSets.isEmpty()) {
            ExerciseSet currentSet = mSets.get(mCurrentSetIndex);
            currentSet.start();
        }
    }

    void stop() {
        mEndDate = new Date();
    }
}
