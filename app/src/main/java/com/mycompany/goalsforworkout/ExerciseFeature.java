package com.mycompany.goalsforworkout;

/**
 * Created by asus on 31.05.2015.
 */
public class ExerciseFeature {
    private String mTitle;
    private float mAmount;
    private ExerciseUnit mUnit;

    public ExerciseFeature(String title) {
        mTitle = title;
    }

    public ExerciseFeature(String title, float amount, ExerciseUnit unit) {
        mTitle = title;
        mAmount = amount;
        mUnit = unit;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public float getAmount() {
        return mAmount;
    }

    public void setAmount(float amount) {
        mAmount = amount;
    }

    public ExerciseUnit getUnit() {
        return mUnit;
    }

    public void setmUnit(ExerciseUnit unit) {
        mUnit = unit;
    }
}
