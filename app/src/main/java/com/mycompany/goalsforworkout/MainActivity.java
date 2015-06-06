package com.mycompany.goalsforworkout;

import android.app.Activity;
import android.app.LoaderManager;
import android.content.Loader;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends Activity implements LoaderManager.LoaderCallbacks<List<Workout>> {

    private List<Workout> mWorkouts;
    private WorkoutAdapter mWorkoutAdapter;
    private ListView mWorkoutListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mWorkouts = new ArrayList<Workout>();

        mWorkoutAdapter = new WorkoutAdapter(this, R.layout.workout_view, mWorkouts);

        mWorkoutListView = (ListView) findViewById(R.id.workouts);
        mWorkoutListView.setAdapter(mWorkoutAdapter);

        getLoaderManager().initLoader(0, null, this);

        setListeners();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public Loader<List<Workout>> onCreateLoader(int id, Bundle args) {
        return new WorkoutLoader(this);
    }

    @Override
    public void onLoadFinished(Loader<List<Workout>> loader, List<Workout> data) {
        mWorkouts.clear();
        mWorkouts.addAll(data);
    }

    @Override
    public void onLoaderReset(Loader<List<Workout>> loader) {

    }

    private void setListeners() {
        Button button = (Button) findViewById(R.id.button_add_workout);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Workout workout = new Workout();
                workout.start();
                workout.stop();
                mWorkouts.add(workout);
                mWorkoutAdapter.notifyDataSetChanged();
            }
        });

        button = (Button) findViewById(R.id.button_save);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WorkoutFactory.saveWorkouts(MainActivity.this, mWorkouts);
            }
        });
    }
}
