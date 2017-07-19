package mihaelaursu.habittracker.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by ursum on 19/07/2017.
 */
/**
 * Displays list of habits
 */
public class HabitDbHelper extends SQLiteOpenHelper {

    private static final String database = "HabitTracker.db";
    private static final int version = 1;
   //Database helper that will provide us access to the database
    public HabitDbHelper(Context context) {
        super(context, database, null, version);
    }
//create table and columns
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String create_table_tracking_diary = "CREATE TABLE " + HabitContract.HabitEntry.TABLE_NAME +
                "(" + HabitContract.HabitEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                HabitContract.HabitEntry.DATE + " INTEGER NOT NULL," +
                HabitContract.HabitEntry.HABIT + " INTEGER NOT NULL," +
                HabitContract.HabitEntry.NOTE + " STRING);";
        Log.v("HabitDbHelper", "create table: " + create_table_tracking_diary);
        sqLiteDatabase.execSQL(create_table_tracking_diary);
    }
//updating data
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
//insert data
    public void insertHabit(int date, int habit, String comment) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(HabitContract.HabitEntry.DATE, date);
        values.put(HabitContract.HabitEntry.HABIT, habit);
        values.put(HabitContract.HabitEntry.NOTE, comment);
        db.insert(HabitContract.HabitEntry.TABLE_NAME, null, values);
    }

    public Cursor readHabits() {
        SQLiteDatabase db = getReadableDatabase();
        String[] projection = {
                HabitContract.HabitEntry._ID,
                HabitContract.HabitEntry.DATE,
                HabitContract.HabitEntry.HABIT,
                HabitContract.HabitEntry.NOTE
        };
        Cursor cursor = db.query(
                HabitContract.HabitEntry.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                null
        );
        return cursor;
    }


}
