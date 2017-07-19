package mihaelaursu.habittracker;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Date;

import mihaelaursu.habittracker.data.HabitContract;
import mihaelaursu.habittracker.data.HabitDbHelper;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        HabitDbHelper habitDbHelper = new HabitDbHelper(this);
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyy");
        String dateString = formatter.format(date);
        int dateInt = Integer.parseInt(dateString);
//insert dummy data
        habitDbHelper.insertHabit(dateInt, HabitContract.HabitEntry.HABIT_1,
                "Learning Android");
        habitDbHelper.insertHabit(dateInt, HabitContract.HabitEntry.HABIT_2,
                "Running every 2 days");
        habitDbHelper.insertHabit(dateInt, HabitContract.HabitEntry.HABIT_3,
                "Going to pilates once per week");
        habitDbHelper.insertHabit(dateInt, HabitContract.HabitEntry.HABIT_4,
                "Eating every day a fruit");
        Cursor cursor = habitDbHelper.readHabits();
        while (cursor.moveToNext()) {
            Log.v(TAG, "habit: " + cursor.getInt(0) + " " + cursor.getInt(1) +
                    " " + cursor.getInt(2) + " " + cursor.getString(3));
        }
    }
}
