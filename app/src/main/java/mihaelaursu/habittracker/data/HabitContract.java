package mihaelaursu.habittracker.data;

import android.provider.BaseColumns;

/**
 * Created by ursum on 19/07/2017.
 */

public class HabitContract {

    public HabitContract() {
    }

    public class HabitEntry implements BaseColumns {
//columns definition
        public final static String TABLE_NAME = "tracking_diary";
        public final static String _ID = BaseColumns._ID;
        public final static String DATE = "date";
        public final static String HABIT = "habit";
        public final static String NOTE = "note";
//habit list
        public final static int HABIT_1 = 0;
        public final static int HABIT_2 = 1;
        public final static int HABIT_3 = 3;
        public final static int HABIT_4 = 4;
    }

}
