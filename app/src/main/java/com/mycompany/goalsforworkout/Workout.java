package com.mycompany.goalsforworkout;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by asus on 31.05.2015.
 */
public class Workout implements Serializable {
    private String mTitle;
    private Calendar mCreationDate;
    private Calendar mStartDate;
    private Calendar mEndDate;
    private List<ExerciseSet> mSets;
    private int mCurrentSetIndex;

    Workout() {
        initialize();
    }

    void initialize() {
        mCurrentSetIndex = 0;
        mCreationDate = Calendar.getInstance();
    }

    public List<ExerciseSet> getSets() {
        if(mSets == null) {
            mSets = new ArrayList<ExerciseSet>();
        }
        return mSets;
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
        return mCreationDate.getTimeInMillis();
    }
}
