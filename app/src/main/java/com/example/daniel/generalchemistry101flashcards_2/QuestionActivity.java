package com.example.daniel.generalchemistry101flashcards_2;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by Daniel on 12/27/2015.
 */
public class QuestionActivity extends Activity  {

    TextView questionTextView;
    TextView lastQuestionTextView;
    TextView scoreTextView;
    RadioGroup radioChoices;
    RadioButton radioButton1;
    RadioButton radioButton2;
    RadioButton radioButton3;
    RadioButton radioButton4;
    Button submitButton;
    RadioButton radioButtonSelected;

    Question this_question;
    String question_text;
    String choice1_text;
    String choice2_text;
    String choice3_text;
    String choice4_text;
    String correctChoice_text;
    Bundle extras;

    ArrayList<Integer> arrayList;
    ArrayList<String> finishedSubjects;
    ArrayList<Integer> usedIdList;
//    ArrayList<Integer> usedIntIds;
//    List<UsedId> used_Ids;
    int questionId;

    TextView tryAgainTextView;
    Button nextQuestionButton;
    Button newSubjectButton;
    String subject;
    int possible_points=300;
    int score;
    int units_score;
    int periodic_score;
    int atomic_score;
    int bond_score;
    int ph_score;
    int electro_score;
    int solubility_score;
    int stoich_score;
    int thermo_score;


    Boolean startingOver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        Log.i("QuestionActivity", "you made it to question activity");

        extras = getIntent().getExtras();
        subject= extras.getString("subject");
        ScoreboardHelper scoreboardHelper = new ScoreboardHelper(this);
        SQLiteDatabase score_db = scoreboardHelper.getWritableDatabase();
        startingOver = extras.getBoolean("starting_over");

        if(startingOver) {
            if(subject.equals("units")) {
                units_score = 0;
                ContentValues cv = new ContentValues();
                cv.put("score", units_score); //These Fields should be your String values of actual column names
                score_db.update("Scoreboards", cv, "id=" + 0, null);
                Log.i("units_score = ", units_score + "");
            }
            startingOver=false;
        }//

        try{
            units_score=scoreboardHelper.readScoreboard(0).getScore();
        } catch (Exception e){
            units_score = 0;
            Scoreboard units_scoreboard = new Scoreboard(0, "units", units_score);
            scoreboardHelper.insertScoreboard(units_scoreboard);
            Log.i("units_score = ", units_score+"");
        }
        try{
            periodic_score=scoreboardHelper.readScoreboard(1).getScore();
        } catch (Exception e){
            periodic_score = 0;
            Scoreboard periodic_scoreboard = new Scoreboard(1, "periodic", periodic_score);
            scoreboardHelper.insertScoreboard(periodic_scoreboard);
            Log.i("periodic_score = ", periodic_score+"");
        }

        try{
            atomic_score=scoreboardHelper.readScoreboard(2).getScore();
        } catch (Exception e){
            atomic_score = 0;
            Scoreboard atomic_scoreboard = new Scoreboard(2, "atomic", atomic_score);
            scoreboardHelper.insertScoreboard(atomic_scoreboard);
            Log.i("atomic_score = ", atomic_score+"");
        }

        try{
            bond_score=scoreboardHelper.readScoreboard(3).getScore();
        } catch (Exception e){
            bond_score = 0;
            Scoreboard bonding_scoreboard = new Scoreboard(3, "bonding", bond_score);
            scoreboardHelper.insertScoreboard(bonding_scoreboard);
            Log.i("bond_score = ", bond_score+"");
        }

        try{
            ph_score=scoreboardHelper.readScoreboard(4).getScore();
        } catch (Exception e){
            ph_score = 0;
            Scoreboard ph_scoreboard = new Scoreboard(4, "ph", ph_score);
            scoreboardHelper.insertScoreboard(ph_scoreboard);
            Log.i("ph_score = ", ph_score+"");
        }

        try{
            electro_score=scoreboardHelper.readScoreboard(5).getScore();
        } catch (Exception e){
            electro_score = 0;
            Scoreboard electro_scoreboard = new Scoreboard(5, "electro", electro_score);
            scoreboardHelper.insertScoreboard(electro_scoreboard);
            Log.i("electro_score = ", electro_score+"");
        }


        try{
            solubility_score=scoreboardHelper.readScoreboard(6).getScore();
        } catch (Exception e){
            solubility_score = 0;
            Scoreboard solubility_scoreboard = new Scoreboard(6, "solubility", solubility_score);
            scoreboardHelper.insertScoreboard(solubility_scoreboard);
            Log.i("solubility_score = ", solubility_score+"");
        }

        try{
            stoich_score=scoreboardHelper.readScoreboard(7).getScore();
        } catch (Exception e){
            stoich_score = 0;
            Scoreboard stoich_scoreboard = new Scoreboard(7, "stoich", stoich_score);
            scoreboardHelper.insertScoreboard(stoich_scoreboard);
            Log.i("stoich_score = ", stoich_score+"");
        }

        try{
            thermo_score=scoreboardHelper.readScoreboard(8).getScore();
        } catch (Exception e){
            thermo_score = 0;
            Scoreboard thermo_scoreboard = new Scoreboard(8, "thermo", thermo_score);
            scoreboardHelper.insertScoreboard(thermo_scoreboard);
            Log.i("thermo_score = ", thermo_score+"");
        }

        Log.i("Scoreboards", scoreboardHelper.getAllScoreboards().toString());
        Log.i("units_scoreboard", scoreboardHelper.readScoreboard(0).getScore()+"");
        score=units_score+periodic_score+atomic_score+bond_score+ph_score+electro_score+solubility_score+stoich_score+thermo_score;

//        IdHelper idHelper = new IdHelper(this);
//        SQLiteDatabase id_db = idHelper.getWritableDatabase();
//        score=extras.getInt("score");
        arrayList= getIntent().getIntegerArrayListExtra("id_range");
//        UsedId usedId = new UsedId(arrayList.get(0));
//        idHelper.insertUsedId(usedId);
//        for(int i=0; i<idHelper.getAllUsedIds().size();i++) {
//            usedIdList.add(Integer.parseInt(idHelper.getAllUsedIds().get(i).toString()));
//        }
//        System.out.println(usedIdList + "used_ids");


//        used_Ids=getIntent().getIntegerArrayListExtra("used_Ids");





        if(arrayList.isEmpty()){
            Intent intent;
            intent = new Intent(QuestionActivity.this, MainActivity.class);

            finish();
            startActivity(intent);
        } else {
            IdHelper idHelper = new IdHelper(this);
            SQLiteDatabase id_db = idHelper.getWritableDatabase();
            questionId = arrayList.get(0);
            idHelper.insertUsedId(new UsedId(arrayList.get(0)));
            List<Integer>used_Ids=idHelper.getAllUsedIds();
            System.out.println("usedId list in Questionactivity" + used_Ids);
            DBHelper helper = new DBHelper(this);
            SQLiteDatabase db = helper.getReadableDatabase();
            this_question = helper.readQuestion(questionId);
            question_text = this_question.getAsk();
            choice1_text = this_question.getChoice1();
            choice2_text = this_question.getChoice2();
            choice3_text = this_question.getChoice3();
            choice4_text = this_question.getChoice4();
            correctChoice_text = this_question.getCorrectChoice();

            scoreTextView=(TextView) findViewById(R.id.scoreTextView);
            lastQuestionTextView=(TextView) findViewById(R.id.lastQuestionTextView);
            questionTextView = (TextView) findViewById(R.id.questionTextView);
            radioButton1 = (RadioButton) findViewById(R.id.radioButton1);
            radioButton2 = (RadioButton) findViewById(R.id.radioButton2);
            radioButton3 = (RadioButton) findViewById(R.id.radioButton3);
            radioButton4 = (RadioButton) findViewById(R.id.radioButton4);
            nextQuestionButton=(Button) findViewById(R.id.nextQuestionButton);
            newSubjectButton=(Button) findViewById(R.id.newSubjectButton);

            if (arrayList.size()==1){
                lastQuestionTextView.setText("Final Question in Topic");
                lastQuestionTextView.setVisibility(View.VISIBLE);
            }
            scoreTextView.setText("your score is " + score);
            questionTextView.setText(question_text);
            radioButton1.setText(choice1_text);
            radioButton2.setText(choice2_text);
            radioButton3.setText(choice3_text);
            radioButton4.setText(choice4_text);

            addListenerOnButton();
        }
    }


    public void addListenerOnButton() {

        radioChoices = (RadioGroup) findViewById(R.id.radioChoices);
        submitButton = (Button) findViewById(R.id.submitButton);
        nextQuestionButton = (Button) findViewById(R.id.nextQuestionButton);
        newSubjectButton = (Button) findViewById(R.id.newSubjectButton);
        tryAgainTextView=(TextView) findViewById(R.id.tryAgainTextView);
        submitButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (arrayList.size()==1){
                    nextQuestionButton.setText("Congratulations, you've answered all questions for this topic! Pick a new topic.");
                }
                if(radioButton1.isChecked()||radioButton2.isChecked()||radioButton3.isChecked()||radioButton4.isChecked()) {
                    // get selected radio button from radioGroup
                    int selectedId = radioChoices.getCheckedRadioButtonId();

                    // find the radiobutton by returned id
                    radioButtonSelected = (RadioButton) findViewById(selectedId);

                    if (radioButtonSelected.getText().equals(correctChoice_text)) {
                        Toast.makeText(QuestionActivity.this,
                                radioButtonSelected.getText() + " is correct!", Toast.LENGTH_SHORT).show();
                        radioButtonSelected.setText(radioButtonSelected.getText() + " is correct!");
                        radioButtonSelected.setTextColor(getResources().getColor(R.color.green));
                        submitButton.setVisibility(View.INVISIBLE);
                        nextQuestionButton.setVisibility(View.VISIBLE);
                        newSubjectButton.setVisibility(View.VISIBLE);

                        if(subject.equals("units")) {
                            ScoreboardHelper scoreboardHelper = new ScoreboardHelper(getBaseContext());
                            SQLiteDatabase score_db = scoreboardHelper.getWritableDatabase();
                            units_score += possible_points;
                            ContentValues cv = new ContentValues();
                            cv.put("score", units_score); //These Fields should be your String values of actual column names
                            score_db.update("Scoreboards", cv, "id=" + 0, null);
                            Log.i("units_score = ", units_score + "");
                        } else if(subject.equals("periodic")){
                            ScoreboardHelper scoreboardHelper = new ScoreboardHelper(getBaseContext());
                            SQLiteDatabase score_db = scoreboardHelper.getWritableDatabase();
                            periodic_score += possible_points;
                            ContentValues cv = new ContentValues();
                            cv.put("score", periodic_score); //These Fields should be your String values of actual column names
                            score_db.update("Scoreboards", cv, "id=" + 1, null);
                            Log.i("periodic_score = ", periodic_score + "");
                        }else if(subject.equals("atomic")){
                            ScoreboardHelper scoreboardHelper = new ScoreboardHelper(getBaseContext());
                            SQLiteDatabase score_db = scoreboardHelper.getWritableDatabase();
                            atomic_score += possible_points;
                            ContentValues cv = new ContentValues();
                            cv.put("score", atomic_score); //These Fields should be your String values of actual column names
                            score_db.update("Scoreboards", cv, "id=" + 2, null);
                            Log.i("atomic_score = ", atomic_score + "");
                        }else if(subject.equals("bonding")){
                            ScoreboardHelper scoreboardHelper = new ScoreboardHelper(getBaseContext());
                            SQLiteDatabase score_db = scoreboardHelper.getWritableDatabase();
                            bond_score += possible_points;
                            ContentValues cv = new ContentValues();
                            cv.put("score", bond_score); //These Fields should be your String values of actual column names
                            score_db.update("Scoreboards", cv, "id=" + 3, null);
                            Log.i("bond_score = ", bond_score + "");
                        }else if(subject.equals("ph")){
                            ScoreboardHelper scoreboardHelper = new ScoreboardHelper(getBaseContext());
                            SQLiteDatabase score_db = scoreboardHelper.getWritableDatabase();
                            ph_score += possible_points;
                            ContentValues cv = new ContentValues();
                            cv.put("score", bond_score); //These Fields should be your String values of actual column names
                            score_db.update("Scoreboards", cv, "id=" + 4, null);
                            Log.i("ph_score = ", ph_score + "");
                        }else if(subject.equals("electro")){
                            ScoreboardHelper scoreboardHelper = new ScoreboardHelper(getBaseContext());
                            SQLiteDatabase score_db = scoreboardHelper.getWritableDatabase();
                            electro_score += possible_points;
                            ContentValues cv = new ContentValues();
                            cv.put("score", electro_score); //These Fields should be your String values of actual column names
                            score_db.update("Scoreboards", cv, "id=" + 5, null);
                            Log.i("electro_score = ", electro_score + "");
                        }else if(subject.equals("solubility")){
                            ScoreboardHelper scoreboardHelper = new ScoreboardHelper(getBaseContext());
                            SQLiteDatabase score_db = scoreboardHelper.getWritableDatabase();
                            solubility_score += possible_points;
                            ContentValues cv = new ContentValues();
                            cv.put("score", solubility_score); //These Fields should be your String values of actual column names
                            score_db.update("Scoreboards", cv, "id=" + 6, null);
                            Log.i("solubility_score = ", solubility_score + "");
                        }else if(subject.equals("stoich")){
                            ScoreboardHelper scoreboardHelper = new ScoreboardHelper(getBaseContext());
                            SQLiteDatabase score_db = scoreboardHelper.getWritableDatabase();
                            stoich_score += possible_points;
                            ContentValues cv = new ContentValues();
                            cv.put("score", stoich_score); //These Fields should be your String values of actual column names
                            score_db.update("Scoreboards", cv, "id=" + 7, null);
                            Log.i("stoich_score = ", stoich_score + "");
                        }else if(subject.equals("thermo")){
                            ScoreboardHelper scoreboardHelper = new ScoreboardHelper(getBaseContext());
                            SQLiteDatabase score_db = scoreboardHelper.getWritableDatabase();
                            thermo_score += possible_points;
                            ContentValues cv = new ContentValues();
                            cv.put("score", thermo_score); //These Fields should be your String values of actual column names
                            score_db.update("Scoreboards", cv, "id=" + 8, null);
                            Log.i("thermo_score = ", thermo_score + "");
                        }
                        score=units_score+periodic_score+atomic_score+bond_score+ph_score+electro_score+solubility_score+stoich_score+thermo_score;
                        scoreTextView.setText("your score is "+score);
                    } else {
                        Toast.makeText(QuestionActivity.this,
                                radioButtonSelected.getText() + " is wrong!", Toast.LENGTH_SHORT).show();
                        radioButtonSelected.setText(radioButtonSelected.getText() + " is wrong!, try again!");
                        radioButtonSelected.setTextColor(getResources().getColor(R.color.red));
                        possible_points -= 100;
                    }
                } else{
                    Toast.makeText(QuestionActivity.this,
                            "Make a choice", Toast.LENGTH_SHORT).show();
                }

            }

        });

    }

    public void nextQuestion(View v){
            arrayList.remove(arrayList.indexOf(questionId));
            Collections.shuffle(arrayList);
            Intent mIntent = getIntent();
            mIntent.putExtra("subject", extras.getString("subject"));
            mIntent.putIntegerArrayListExtra("id_range", arrayList);
            mIntent.putExtra("units_score", units_score);
            mIntent.putExtra("periodic_score", periodic_score);
            mIntent.putExtra("atomic_score", atomic_score);
            mIntent.putExtra("bond_score", bond_score);
            mIntent.putExtra("ph_score", ph_score);
            mIntent.putExtra("electro_score", electro_score);
            mIntent.putExtra("solubility_score", solubility_score);
            mIntent.putExtra("stoich_score", stoich_score);
            mIntent.putExtra("thermo_score", thermo_score);
            mIntent.putExtra("starting_over", false);
            finish();
            startActivity(mIntent);
    }
    public void newSubject(View v){
//        used_Ids.add(questionId);
//        arrayList.remove(arrayList.indexOf(questionId));
        Intent intent;
        intent = new Intent(QuestionActivity.this, MainActivity.class);
        intent.putExtra("starting_over", false);
        finish();
        startActivity(intent);
    }


}
//test2


