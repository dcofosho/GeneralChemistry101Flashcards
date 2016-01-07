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
 * Created by Daniel on 12/28/2015.
 */
public class ScoreboardHelper extends SQLiteOpenHelper {

    private static final String[] COLUMNS = {"id", "subject", "score"};


    public ScoreboardHelper(Context context){
        super(context, "Library2", null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase score_db) {
        String create = "Create table Scoreboards ( id Old integer primary key, subject text, score Old integer)";
        score_db.execSQL(create);
        Log.i("DB", "DB created");
    }

    @Override
    public void onUpgrade(SQLiteDatabase score_db, int oldVersion, int newVersion) {
        score_db.execSQL("DROP TABLE IF EXISTS Scoreboards");
        onCreate(score_db);
    }

    public void insertScoreboard(Scoreboard scoreboard) {
        SQLiteDatabase score_db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("id", scoreboard.getId());
        values.put("subject", scoreboard.getSubject());
        values.put("score", scoreboard.getScore());

        score_db.insert("Scoreboards", null, values);
        score_db.close();
        Log.i("DB", "Scoreboard got inserted");
    }
    public List<Scoreboard> getAllScoreboards(){
        List<Scoreboard> scoreboards = new LinkedList<Scoreboard>();
        String query = "SELECT * FROM Scoreboards";

        SQLiteDatabase score_db = this.getReadableDatabase();
        Cursor cursor = score_db.rawQuery(query, null);

        Scoreboard scoreboard = null;
        if (cursor.moveToFirst()) {
            do {
                scoreboard = new Scoreboard();
                scoreboard.setId(Integer.parseInt(cursor.getString(0)));
                scoreboard.setSubject(cursor.getString(1));
                scoreboard.setScore(Integer.parseInt(cursor.getString(2)));
                scoreboards.add(scoreboard);
            } while (cursor.moveToNext());
        }
        return scoreboards;
    }

    public Scoreboard readScoreboard(int id){

        SQLiteDatabase score_db = this.getReadableDatabase();
        Cursor cursor = score_db.query("Scoreboards",
                COLUMNS, "id = ?", new String[]{String.valueOf(id)}, null, null, null, null);

        if (cursor!=null)
            cursor.moveToFirst();

        int columnIndex=cursor.getColumnIndex("id");
        Scoreboard scoreboard = new Scoreboard();
        scoreboard.setId(Integer.parseInt(cursor.getString(columnIndex)));
        scoreboard.setSubject(cursor.getString(1));
        scoreboard.setScore(Integer.parseInt(cursor.getString(2)));

        return scoreboard;
    }

}
