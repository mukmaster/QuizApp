package de.ihrprof.quizapp;

import android.app.Activity;
import android.content.ContentValues;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.preference.PreferenceManager;
import android.os.Bundle;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static de.ihrprof.quizapp.UserDataContract.UserDataEntry.*;

public class UsageActivity extends Activity {

    private UserDataDBHelper userDataDBHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usage);

        userDataDBHelper = new UserDataDBHelper(this);

        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        String userName = sharedPref.getString("pref_username", "N.N.");
        try {
            addUsageRecord(userName);
            Cursor cursor = getUsageRecords();
            showUsageRecords(cursor);
        } finally {
            userDataDBHelper.close();
        }
    }

    private void addUsageRecord(String s) {
        SQLiteDatabase db = userDataDBHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME_USER, s);
        DateFormat dfmt = new SimpleDateFormat( "dd.MM.yy', 'HH:mm:ss" );
        values.put(COLUMN_NAME_TIME, dfmt.format(new Date()));
        db.insertOrThrow(TABLE_NAME, null, values);
    }

    private static String[] FROM = { _ID, COLUMN_NAME_USER, COLUMN_NAME_TIME, };
    private static String ORDER_BY = _ID + " DESC";

    private Cursor getUsageRecords(){
        SQLiteDatabase db = userDataDBHelper.getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME,  FROM, null, null, null, null, ORDER_BY);
        startManagingCursor(cursor);
        return cursor;
    }

    private void showUsageRecords(Cursor cursor) {
        StringBuilder resultString =
                new StringBuilder("This QuizApp was used by:\n");
        while (cursor.moveToNext()) {
            long id = cursor.getLong(0);
            String name = cursor.getString(1);
            String time = cursor.getString(2);
            resultString.append(id).
                    append(": ").
                    append(name).
                    append(", ").
                    append(time).
                    append("\n");
        }
        TextView text = (TextView) findViewById(R.id.textLine);
        text.setText(resultString);
    }
}
