package com.mycompany.goalsforworkout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;


public class WorkoutDetailsActivity extends Activity {

    static final String EXTRA_WORKOUT = "WORKOUT";

    private Workout mWorkout;
    private ExerciseSetAdapter mExerciseSetAdapter;
    private ListView mExerciseSetListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_details);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            mWorkout = (Workout) extras.getSerializable(EXTRA_WORKOUT);
        }

        mExerciseSetAdapter = new ExerciseSetAdapter(this, R.layout.exercise_set_view, mWorkout.getSets());

        mExerciseSetListView = (ListView) findViewById(R.id.exercise_sets);
        mExerciseSetListView.setAdapter(mExerciseSetAdapter);

        setListeners();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_workout_details, menu);
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

    private void setListeners() {
        Button button = (Button) findViewById(R.id.button_add_exercise_set);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ExerciseSet exerciseSet = new ExerciseSet();
                exerciseSet.setTitle(getString(R.string.exercise_set_title_default));
                mWorkout.getSets().add(exerciseSet);
                mExerciseSetAdapter.notifyDataSetChanged();
            }
        });

        mExerciseSetListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getBaseContext(), ExerciseSetDetailsActivity.class);
                intent.putExtra(ExerciseSetDetailsActivity.EXTRA_EXERCISE_SET, (ExerciseSet) mExerciseSetListView.getItemAtPosition(position));
                startActivity(intent);
            }
        });
    }
}
