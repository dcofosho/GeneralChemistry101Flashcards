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
public class DBHelper extends SQLiteOpenHelper {

    private static final String[] COLUMNS = {"id", "ask", "choice1", "choice2", "choice3", "choice4", "correctChoice"};

    public DBHelper(Context context){
        super(context, "Library", null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String create = "Create table Questions ( id Old integer primary key, ask text, choice1 text, choice2 text, choice3 text, choice4 text, correctChoice text)";
        db.execSQL(create);
        Log.i("DB", "DB created");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Questions");
        onCreate(db);
    }

    public void insertQuestion(Question question) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("id", question.getId());
        values.put("ask", question.getAsk());
        values.put("choice1", question.getChoice1());
        values.put("choice2", question.getChoice2());
        values.put("choice3", question.getChoice3());
        values.put("choice4", question.getChoice4());
        values.put("correctChoice", question.getCorrectChoice());
        db.insert("Questions", null, values);
        db.close();
        Log.i("DB", "Question got inserted");
    }
    public List<Question> getAllQuestions(){
        List<Question> questions = new LinkedList<Question>();

        String query = "SELECT * FROM Questions";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        Question question = null;
        if (cursor.moveToFirst()) {
            do {
                question = new Question();
                question.setId(Integer.parseInt(cursor.getString(0)));
                question.setAsk(cursor.getString(1));
                question.setChoice1(cursor.getString(2));
                question.setChoice2(cursor.getString(3));
                question.setChoice3(cursor.getString(4));
                question.setChoice4(cursor.getString(5));
                question.setCorrectChoice(cursor.getString(6));

                questions.add(question);
            } while (cursor.moveToNext());
        }
        return questions;

    }

    public Question readQuestion(int id){

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query("Questions",
                COLUMNS, "id = ?", new String[]{String.valueOf(id)}, null, null, null, null);

        if (cursor!=null)
            cursor.moveToFirst();

        int columnIndex=cursor.getColumnIndex("id");
        Question question = new Question();
        question.setId(Integer.parseInt(cursor.getString(columnIndex)));
        question.setAsk(cursor.getString(1));
        question.setChoice1(cursor.getString(2));
        question.setChoice2(cursor.getString(3));
        question.setChoice3(cursor.getString(4));
        question.setChoice4(cursor.getString(5));
        question.setCorrectChoice(cursor.getString(6));
        return question;
    }

}
