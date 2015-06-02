package com.mycompany.goalsforworkout;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        runDemo();
    }

    private void runDemo() {
        Workout workout = new Workout();
        ExerciseSet set = new ExerciseSet("wide grip pull-ups with dumbbell");
        set.setExercise(new Exercise("pull-ups"));
        set.setRepCount(12);
        set.getFeatures().add(new ExerciseFeature("wide grip"));
        set.getFeatures().add(new ExerciseFeature("dumbbell", 28, new ExerciseUnit("kg")));
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
}
