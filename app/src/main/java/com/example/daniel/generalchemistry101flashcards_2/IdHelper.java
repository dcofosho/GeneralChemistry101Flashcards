package com.example.daniel.generalchemistry101flashcards_2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Daniel on 1/4/2016.
 */
public class IdHelper extends SQLiteOpenHelper {

    private static final String[] COLUMNS = {"usedId"};


    public IdHelper(Context context){
        super(context, "Library3", null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase id_db) {
        String create = "Create table UsedId ( usedId Old integer primary key)";
        id_db.execSQL(create);
        Log.i("DB", "DB created");
    }

    @Override
    public void onUpgrade(SQLiteDatabase id_db, int oldVersion, int newVersion) {
        id_db.execSQL("DROP TABLE IF EXISTS UsedId");
        onCreate(id_db);
    }

    public void insertUsedId(UsedId usedId) {
        SQLiteDatabase id_db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("usedId", usedId.getUsedId());


        id_db.insert("UsedId", null, values);
        id_db.close();
        Log.i("DB", "UsedId got inserted");
    }
    public List<Integer> getAllUsedIds(){
        List<Integer> usedIdList = new LinkedList<Integer>();
        String query = "SELECT * FROM UsedId";

        SQLiteDatabase id_db = this.getReadableDatabase();
        Cursor cursor = id_db.rawQuery(query, null);

        int usedId;
        if (cursor.moveToFirst()) {
            do {
                usedId=Integer.parseInt(cursor.getString(0));
                usedIdList.add(usedId);
            } while (cursor.moveToNext());
        }
        return usedIdList;
    }


}
