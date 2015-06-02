package com.mycompany.goalsforworkout;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by asus on 31.05.2015.
 */
public class ExerciseSet {
    private String mTitle;
    private Date mStartDate;
    private Date mEndDate;
    private Exercise mExercise;
    private List<ExerciseFeature> mFeatures;
    private int mRepCount;
    private int mActualRepCount;

    public ExerciseSet(String title) {
        mTitle = title;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public Date getStartDate() {
        return mStartDate;
    }

    public void setStartDate(Date startDate) {
        mStartDate = startDate;
    }

    public Exercise getExercise() {
        return mExercise;
    }

    public void setExercise(Exercise exercise) {
        mExercise = exercise;
    }

    int getRepCount() {
        return mRepCount;
    }

    void setRepCount(int repCount) {
        mRepCount = repCount;
    }

    int getActualRepCount() {
        return mActualRepCount;
    }

    void setActualRepCount(int actualRepCount) {
        mActualRepCount = actualRepCount;
    }

    List<ExerciseFeature> getFeatures() {
        if (mFeatures == null) {
            mFeatures = new ArrayList<ExerciseFeature>();
        }
        return mFeatures;
    }

    List<ExerciseSet> multiply(int setCount) throws CloneNotSupportedException {
        List<ExerciseSet> sets = new ArrayList<ExerciseSet>();
        for (int i = 0; i < setCount; i++) {
            sets.add((ExerciseSet) this.clone());
        }
        return sets;
    }

    void start() {
        mStartDate = new Date();
    }

    void stop() {
        mEndDate = new Date();
        //todo: get actual rep count from dialog
    }
}