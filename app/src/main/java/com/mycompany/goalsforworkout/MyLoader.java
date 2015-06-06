package com.mycompany.goalsforworkout;

import android.content.AsyncTaskLoader;
import android.content.Context;

/**
 * Created by user on 06.06.2015.
 */
public abstract class MyLoader<T> extends AsyncTaskLoader<T> {

    T mData;

    public MyLoader(Context context) {
        super(context);
    }

    @Override
    public void deliverResult(T data) {
        if (isReset()) {
            if (data != null) {
                releaseResources(data);
            }
        }
        T oldData = mData;
        mData = data;

        if (isStarted()) {
            super.deliverResult(data);
        }

        if (oldData != null) {
            releaseResources(oldData);
        }
    }

    @Override
    protected void onStartLoading() {
        if (mData != null) {
            deliverResult(mData);
        }

        //todo: check for changes?

        forceLoad();
    }

    @Override
    protected void onStopLoading() {
        cancelLoad();
    }

    @Override
    public void onCanceled(T data) {
        super.onCanceled(data);

        releaseResources(data);
    }

    @Override
    protected void onReset() {
        super.onReset();

        onStopLoading();

        if (mData != null) {
            releaseResources(mData);
            mData = null;
        }

        //todo: stop monitoring for changes
    }

    protected void releaseResources(T data) {
    }
}
