package com.mjdroid.glimpsee;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;


public class DBHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "ActivitiesDB.db";
    public static final String ACTIVITY_TABLE_NAME = "activities";
    public static final String ACTIVITY_COLUMN_ID = "id";
    public static final String ACTIVITY_COLUMN_NAME = "activity";
    public static final String ACTIVITY_COLUMN_DATE = "date";
    public static final String ACTIVITY_COLUMN_START = "start";
    public static final String ACTIVITY_COLUMN_END = "end";
    public static final String ACTIVITY_COLUMN_CONTACT = "contact";
    public static final String ACTIVITY_COLUMN_NUMBER = "number";

    public DBHelper(Context context){
        super(context, DATABASE_NAME,null,1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
                "create table activities " + "(id integer primary key, activity text,date text,start text, end text,contact text, number text)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        db.execSQL("DROP TABLE IF EXISTS activities");
        onCreate(db);
    }

    public boolean insertActivity(String activity, String date, String start, String end,String contact, String number) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("activity", activity);
        contentValues.put("date", date);
        contentValues.put("start", start);
        contentValues.put("end", end);
        contentValues.put("contact", contact);
        contentValues.put("number", number);
        db.insert("activities", null, contentValues);
        return true;
    }

    public Cursor getData(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from activities where id=" + id + "",null );
        return res;
    }

    public int numberOfRows() {
        SQLiteDatabase db = this.getReadableDatabase();
        int numberOfRows = (int) DatabaseUtils.queryNumEntries(db, ACTIVITY_TABLE_NAME);
        return numberOfRows;
    }

    public boolean updateActivity(Integer id, String activity, String date, String start, String end,String contact, String number) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("activity", activity);
        contentValues.put("date", date);
        contentValues.put("start", start);
        contentValues.put("end", end);
        contentValues.put("contact", contact);
        contentValues.put("number", number);
        db.update("activities", contentValues, "id = ?", new String[] {Integer.toString(id)});
        return true;
    }

    public ArrayList<PlanActivity> getPlannedActivities() {
        ArrayList<PlanActivity> planActivityArrayList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery( "select * from activities", null);
        res.moveToFirst();

        while (!res.isAfterLast()) {
            String activity = res.getString(res.getColumnIndex(ACTIVITY_COLUMN_NAME));
            String date = res.getString(res.getColumnIndex(ACTIVITY_COLUMN_DATE));
            String start = res.getString(res.getColumnIndex(ACTIVITY_COLUMN_START));
            String end = res.getString(res.getColumnIndex(ACTIVITY_COLUMN_END));
            String contact = res.getString(res.getColumnIndex(ACTIVITY_COLUMN_CONTACT));
            String number = res.getString(res.getColumnIndex(ACTIVITY_COLUMN_NUMBER));

            planActivityArrayList.add(new PlanActivity(activity,date,start,end,contact,number));
        }

        return planActivityArrayList;
    }
}
