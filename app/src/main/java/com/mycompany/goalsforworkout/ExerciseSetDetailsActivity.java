package com.mycompany.goalsforworkout;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;


public class ExerciseSetDetailsActivity extends Activity {

    static final String EXTRA_EXERCISE_SET = "EXERCISE_SET";

    private ExerciseSet mExerciseSet;
    private ExerciseFeatureAdapter mExerciseFeatureAdapter;
    private ListView mExerciseFeatureListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_set_details);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            mExerciseSet = (ExerciseSet) extras.getSerializable(EXTRA_EXERCISE_SET);
        }

        mExerciseFeatureAdapter = new ExerciseFeatureAdapter(this, R.layout.exercise_feature_view, mExerciseSet.getFeatures());

        mExerciseFeatureListView = (ListView) findViewById(R.id.exercise_features);
        mExerciseFeatureListView.setAdapter(mExerciseFeatureAdapter);

        setListeners();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_exercise_set_details, menu);
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
        Button button = (Button) findViewById(R.id.button_add_exercise_feature);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ExerciseFeature exerciseFeature = new ExerciseFeature();
                exerciseFeature.setTitle(getString(R.string.exercise_feature_title_default));
                mExerciseSet.getFeatures().add(exerciseFeature);
                mExerciseFeatureAdapter.notifyDataSetChanged();
            }
        });
    }
}
