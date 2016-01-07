package com.example.daniel.generalchemistry101flashcards_2;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.content.res.ResourcesCompat;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by Daniel on 12/27/2015.
 */
public class MainActivity extends Activity {

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

    List<UsedId> used_Ids;

    Bundle extras;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        extras=getIntent().getExtras();

        IdHelper idHelper = new IdHelper(this);
        SQLiteDatabase id_db = idHelper.getWritableDatabase();

//        ScoreboardHelper scoreboardHelper = new ScoreboardHelper(this);
//        SQLiteDatabase score_db = scoreboardHelper.getWritableDatabase();
//
//        try{
//            if(getIntent().hasExtra("units_score")) {
//                units_score = extras.getInt("units_score");
//                ContentValues cv = new ContentValues();
//                cv.put("score", units_score); //These Fields should be your String values of actual column names
//                score_db.update("Scoreboards", cv, "id=" + 0, null);
//                Log.i("units_score = ", units_score + "");
////            Log.i("units_score = ", units_score+"");
//            }else{
//                units_score=scoreboardHelper.readScoreboard(0).getScore();
//            }
//        } catch (Exception e){
//            units_score = 0;
//            Scoreboard units_scoreboard = new Scoreboard(0, "units", units_score);
//            scoreboardHelper.insertScoreboard(units_scoreboard);
//            Log.i("units_score = ", units_score+"");
//        }
//
//
//        try{
//            if(getIntent().hasExtra("periodic_score")) {
//                periodic_score = extras.getInt("periodic_score");
//                ContentValues cv = new ContentValues();
//                cv.put("score", periodic_score); //These Fields should be your String values of actual column names
//                score_db.update("Scoreboards", cv, "id=" + 1, null);
//                Log.i("periodic_score = ", periodic_score + "");
//            }else{
//                periodic_score=scoreboardHelper.readScoreboard(1).getScore();
//            }
//        } catch (Exception e){
//            periodic_score = 0;
//            Scoreboard periodic_scoreboard = new Scoreboard(1, "periodic", periodic_score);
//            scoreboardHelper.insertScoreboard(periodic_scoreboard);
//            Log.i("periodic_score = ", periodic_score+"");
//        }
//
//
//        try{
//            if(getIntent().hasExtra("atomic_score")) {
//                atomic_score = extras.getInt("atomic_score");
//                ContentValues cv = new ContentValues();
//                cv.put("score", atomic_score); //These Fields should be your String values of actual column names
//                score_db.update("Scoreboards", cv, "id=" + 2, null);
//                Log.i("atomic_score = ", atomic_score + "");
//            }else{
//                atomic_score=scoreboardHelper.readScoreboard(2).getScore();
//            }
//        } catch (Exception e){
//            atomic_score = 0;
//            Scoreboard atomic_scoreboard = new Scoreboard(2, "atomic", atomic_score);
//            scoreboardHelper.insertScoreboard(atomic_scoreboard);
//            Log.i("atomic_score = ", atomic_score+"");
//        }
//
//
//        try{
//            if(getIntent().hasExtra("bond_score")) {
//                bond_score = extras.getInt("bond_score");
//                ContentValues cv = new ContentValues();
//                cv.put("score", bond_score); //These Fields should be your String values of actual column names
//                score_db.update("Scoreboards", cv, "id=" + 3, null);
//                Log.i("bond_score = ", bond_score + "");
//            }else{
//                bond_score=scoreboardHelper.readScoreboard(3).getScore();
//            }
//        } catch (Exception e){
//            bond_score = 0;
//            Scoreboard bonding_scoreboard = new Scoreboard(3, "bonding", bond_score);
//            scoreboardHelper.insertScoreboard(bonding_scoreboard);
//            Log.i("bond_score = ", bond_score+"");
//        }
//
//        try{
//            if(getIntent().hasExtra("ph_score")) {
//                ph_score = extras.getInt("ph_score");
//                ContentValues cv = new ContentValues();
//                cv.put("score", bond_score); //These Fields should be your String values of actual column names
//                score_db.update("Scoreboards", cv, "id=" + 4, null);
//                Log.i("ph_score = ", ph_score + "");
//            }else{
//                ph_score=scoreboardHelper.readScoreboard(4).getScore();
//            }
//        } catch (Exception e){
//            ph_score = 0;
//            Scoreboard ph_scoreboard = new Scoreboard(4, "ph", ph_score);
//            scoreboardHelper.insertScoreboard(ph_scoreboard);
//            Log.i("ph_score = ", ph_score+"");
//        }
//
//        try{
//            if(getIntent().hasExtra("electro_score")) {
//                electro_score = extras.getInt("electro_score");
//                ContentValues cv = new ContentValues();
//                cv.put("score", electro_score); //These Fields should be your String values of actual column names
//                score_db.update("Scoreboards", cv, "id=" + 5, null);
//                Log.i("electro_score = ", electro_score + "");
//            }else{
//                electro_score=scoreboardHelper.readScoreboard(5).getScore();
//            }
//        } catch (Exception e){
//            electro_score = 0;
//            Scoreboard electro_scoreboard = new Scoreboard(5, "electro", electro_score);
//            scoreboardHelper.insertScoreboard(electro_scoreboard);
//            Log.i("electro_score = ", electro_score+"");
//        }
//
//
//        try{
//            if(getIntent().hasExtra("solubility_score")) {
//                solubility_score = extras.getInt("solubility_score");
//                ContentValues cv = new ContentValues();
//                cv.put("score", solubility_score); //These Fields should be your String values of actual column names
//                score_db.update("Scoreboards", cv, "id=" + 6, null);
//                Log.i("solubility_score = ", solubility_score + "");
//            }else{
//                solubility_score=scoreboardHelper.readScoreboard(6).getScore();
//            }
//        } catch (Exception e){
//            solubility_score = 0;
//            Scoreboard solubility_scoreboard = new Scoreboard(6, "solubility", solubility_score);
//            scoreboardHelper.insertScoreboard(solubility_scoreboard);
//            Log.i("solubility_score = ", solubility_score+"");
//        }
//
//
//        try{
//            if(getIntent().hasExtra("stoich_score")) {
//                stoich_score = extras.getInt("stoich_score");
//                ContentValues cv = new ContentValues();
//                cv.put("score", stoich_score); //These Fields should be your String values of actual column names
//                score_db.update("Scoreboards", cv, "id=" + 7, null);
//                Log.i("stoich_score = ", stoich_score + "");
//            }else{
//                stoich_score=scoreboardHelper.readScoreboard(7).getScore();
//            }
//        } catch (Exception e){
//            stoich_score = 0;
//            Scoreboard stoich_scoreboard = new Scoreboard(7, "stoich", stoich_score);
//            scoreboardHelper.insertScoreboard(stoich_scoreboard);
//            Log.i("stoich_score = ", stoich_score+"");
//        }
//
//
//        try{
//            if(getIntent().hasExtra("thermo_score")) {
//                thermo_score = extras.getInt("thermo_score");
//                ContentValues cv = new ContentValues();
//                cv.put("score", thermo_score); //These Fields should be your String values of actual column names
//                score_db.update("Scoreboards", cv, "id=" + 8, null);
//                Log.i("thermo_score = ", thermo_score + "");
//            }else{
//                thermo_score=scoreboardHelper.readScoreboard(8).getScore();
//            }
//        } catch (Exception e){
//            thermo_score = 0;
//            Scoreboard thermo_scoreboard = new Scoreboard(8, "thermo", thermo_score);
//            scoreboardHelper.insertScoreboard(thermo_scoreboard);
//            Log.i("thermo_score = ", thermo_score+"");
//        }


        score=units_score+periodic_score+atomic_score+bond_score+ph_score+electro_score+solubility_score+stoich_score+thermo_score;

        try{
            used_Ids=idHelper.getAllUsedIds();
        }catch (Exception e){
            UsedId usedId = new UsedId(0);
            idHelper.insertUsedId(usedId);
            used_Ids=idHelper.getAllUsedIds();
        }

//        if(getIntent().hasExtra("used_Ids")){
//            Bundle bundle=getIntent().getExtras();
//            used_Ids=bundle.getIntegerArrayList("used_Ids");
//        }else{
//            int[] array = {0};
//            used_Ids= new ArrayList(Arrays.asList(array));
//        }


        setContentView(R.layout.activity_main);
        Subject units = new Subject("Units and measurements", ResourcesCompat.getDrawable(getResources(), R.drawable.units, null));
        Subject periodic = new Subject("Periodic table and trends", ResourcesCompat.getDrawable(getResources(), R.drawable.periodic_table, null));
        Subject atomic = new Subject("Atoms, ions, and isotopes", ResourcesCompat.getDrawable(getResources(), R.drawable.atom, null));
        Subject bonds = new Subject("Bonding", ResourcesCompat.getDrawable(getResources(), R.drawable.bonding, null));
        Subject ph = new Subject("Acids, bases, and pH", ResourcesCompat.getDrawable(getResources(), R.drawable.ph, null));
        Subject electro = new Subject("Electrochemistry", ResourcesCompat.getDrawable(getResources(), R.drawable.electro, null));
        Subject solubility = new Subject("Solubility and mixtures", ResourcesCompat.getDrawable(getResources(), R.drawable.solutions_and_mixtures, null));
        Subject stoich = new Subject("Equations and Stoichiometry", ResourcesCompat.getDrawable(getResources(), R.drawable.equations_stoich, null));
        Subject thermo = new Subject("Thermochemistry", ResourcesCompat.getDrawable(getResources(), R.drawable.thermo, null));

        ArrayList<Subject> subjects = new ArrayList<Subject>();
        subjects.add(units);
        subjects.add(periodic);
        subjects.add(atomic);
        subjects.add(bonds);
        subjects.add(ph);
        subjects.add(electro);
        subjects.add(solubility);
        subjects.add(stoich);
        subjects.add(thermo);

        CustomListViewAdapter adapter = new CustomListViewAdapter(this,R.layout.list_layout1,subjects);
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i;

                if (position == 0) {
                    i = new Intent(MainActivity.this, QuestionActivity.class);
                    i.putExtra("subject", "units");
                    ArrayList<Integer> arrayList = new ArrayList<>();

                    for (int k = 0; k < 3; k++) {
                        UsedId usedId = new UsedId(k + 100);
                        Log.i("usedID inside for loop", usedId.toString());
                        if (!used_Ids.contains(usedId)) {
                            arrayList.add(k + 100);
                        }
                    }

                    Collections.shuffle(arrayList);
                    i.putIntegerArrayListExtra("id_range", arrayList);
                    Log.i("id_range", arrayList.toString());
                    Log.i("score", score+"");
                } else if (position == 1) {
                    i = new Intent(MainActivity.this, QuestionActivity.class);
                    i.putExtra("subject", "periodic");
                    ArrayList<Integer> arrayList = new ArrayList<>();
                    for (int k = 0; k < 3; k++) {
                        UsedId usedId = new UsedId(k + 200);
                        if (used_Ids==null ||!used_Ids.contains(usedId)) {
                            arrayList.add(k + 200);
                        }
                    }
                    i.putIntegerArrayListExtra("id_range", arrayList);
                } else if (position == 2) {
                    i = new Intent(MainActivity.this, QuestionActivity.class);
                    i.putExtra("subject", "atomic");
                    ArrayList<Integer> arrayList = new ArrayList<>();
                    for (int k = 0; k < 3; k++) {
                        UsedId usedId = new UsedId(k + 300);
                        if (used_Ids==null || !used_Ids.contains(usedId)) {
                            arrayList.add(k + 300);
                        }
                    }
                    i.putIntegerArrayListExtra("id_range", arrayList);
                } else if (position == 3) {
                    i = new Intent(MainActivity.this, QuestionActivity.class);
                    i.putExtra("subject", "bonding");
                    ArrayList<Integer> arrayList = new ArrayList<>();
                    for (int k = 0; k < 3; k++) {
                        UsedId usedId = new UsedId(k + 400);
                        if (used_Ids==null ||!used_Ids.contains(usedId)) {
                            arrayList.add(k + 400);
                        }
                    }
                    i.putIntegerArrayListExtra("id_range", arrayList);
                } else if (position == 4) {
                    i = new Intent(MainActivity.this, QuestionActivity.class);
                    i.putExtra("subject", "ph");
                    ArrayList<Integer> arrayList = new ArrayList<>();
                    for (int k = 0; k < 3; k++) {
                        UsedId usedId = new UsedId(k + 500);
                        if (used_Ids==null ||!used_Ids.contains(usedId)) {
                            arrayList.add(k + 500);
                        }
                    }
                    i.putIntegerArrayListExtra("id_range", arrayList);
                } else if (position == 5) {
                    i = new Intent(MainActivity.this, QuestionActivity.class);
                    i.putExtra("subject", "electro");
                    ArrayList<Integer> arrayList = new ArrayList<>();
                    for (int k = 0; k < 3; k++) {
                        UsedId usedId = new UsedId(k + 600);
                        if (used_Ids==null ||!used_Ids.contains(usedId)) {
                            arrayList.add(k + 600);
                        }
                    }
                    i.putIntegerArrayListExtra("id_range", arrayList);
                } else if (position == 6) {
                    i = new Intent(MainActivity.this, QuestionActivity.class);
                    i.putExtra("subject", "solubility");
                    ArrayList<Integer> arrayList = new ArrayList<>();
                    for (int k = 0; k < 3; k++) {
                        UsedId usedId = new UsedId(k + 700);
                        if (used_Ids==null ||!used_Ids.contains(usedId)) {
                            arrayList.add(k + 700);
                        }
                    }
                    i.putIntegerArrayListExtra("id_range", arrayList);
                } else if (position == 7) {
                    i = new Intent(MainActivity.this, QuestionActivity.class);
                    i.putExtra("subject", "stoich");
                    ArrayList<Integer> arrayList = new ArrayList<>();
                    for (int k = 0; k < 3; k++) {
                        UsedId usedId = new UsedId(k + 800);
                        if (used_Ids==null ||!used_Ids.contains(usedId)) {
                            arrayList.add(k + 800);
                        }
                    }
                    i.putIntegerArrayListExtra("id_range", arrayList);
                } else {
                    i = new Intent(MainActivity.this, QuestionActivity.class);
                    i.putExtra("subject", "thermo");
                    ArrayList<Integer> arrayList = new ArrayList<>();
                    for (int k = 0; k < 3; k++) {
                        UsedId usedId = new UsedId(k + 900);
                        if (used_Ids==null ||!used_Ids.contains(usedId)) {
                            arrayList.add(k + 900);
                        }
                    }
                    i.putIntegerArrayListExtra("id_range", arrayList);
                }

//                i.putExtra("used_Ids", used_Ids);
//                i.putExtra("score", score);
                i.putExtra("units_score", units_score);
                i.putExtra("periodic_score", periodic_score);
                i.putExtra("atomic_score", atomic_score);
                i.putExtra("bond_score", bond_score);
                i.putExtra("ph_score", ph_score);
                i.putExtra("electro_score", electro_score);
                i.putExtra("solubility_score", solubility_score);
                i.putExtra("stoich_score", stoich_score);
                i.putExtra("thermo_score", thermo_score);
                startActivity(i);
            }
        });
        DBHelper helper = new DBHelper(this);
        SQLiteDatabase db = helper.getWritableDatabase();

        Question science_question1 = new Question(100,"What is the main ingredient in air?", "Nitrogen", "Oxygen","Carbon Dioxide", "Hydrogen", "Nitrogen");
        helper.insertQuestion(science_question1);
        Question science_question2 = new Question(101,"Which is not a metal?", "Lithium", "Calcium","Manganese", "Bromide", "Bromide");
        helper.insertQuestion(science_question2);
        Question science_question3 = new Question(102,"Which substance is found in smoke detectors?", "Uranium", "Americium","Tungsten", "Carbon Monoxide", "Americium");
        helper.insertQuestion(science_question3);


        Question math_question1 = new Question(200, "The graph of a second order polynomial has what shape?", "hyperbola", "parabola", "square", "line", "parabola");
        helper.insertQuestion(math_question1);
        Question math_question2 = new Question(201, "Which of the following is NOT a prime number?", "7", "2", "17", "21", "21");
        helper.insertQuestion(math_question2);
        Question math_question3 = new Question(202, "Pi is equal to...", "The ratio of a circle's area to it's radius", "The ratio of a circle's circumference to radius", "The ratio of a circle's circumference to diameter", "The ratio of a square's diagonal to it's side", "The ratio of a circle's circumference to diameter");
        helper.insertQuestion(math_question3);


        Question history_question1 = new Question(300, "The assisination of this politician sparked the first world war", "Heinrich Helmholtz", "Werner Herzog", "Leif Erikson", "Franz Ferdinand", "Franz Ferdinand");
        helper.insertQuestion(history_question1);
        Question history_question2 = new Question(301, "Which Iranian dynasty was overthrown in the 1979 revolution", "Qajar", "Safavid", "Pahlavi", "Zand", "Pahlavi");
        helper.insertQuestion(history_question2);
        Question history_question3 = new Question(302, "This body of water, opened for shipping in 1869, connects the Mediterranean sea with the Red Sea", "Strait of Gibraltar", "Suez Canal", "Persian Gulf", "Welland Canal", "Suez Canal");
        helper.insertQuestion(history_question3);


        Question literature_question1 = new Question(400, "Paul French was actually a pen name used by this author", "Tom Robins", "Anne Rice", "Isaac Asimov", "Virginia Wolf", "Isaac Asimov");
        helper.insertQuestion(literature_question1);
        Question literature_question2 = new Question(401, "Which author is commonly associated with the post-modern movement?", "James Joyce", "Thomas Pynchon", "Jean Paul Sartre", "Franz Kafka", "Thomas Pynchon");
        helper.insertQuestion(literature_question2);
        Question literature_question3 = new Question(402, "Which book series, written by George RR Martin, became the basis for the TV show Game of Thrones?", "A Game of Thrones", "The Magician's Trilogy", "The Westeros Chronicles", "A Song of Ice and Fire", "A Song of Ice and Fire");
        helper.insertQuestion(literature_question3);

        Question arts_and_music_question1 = new Question(500, "What year did The Beatles break up?", "1968", "1969", "1970", "1971", "1970");
        helper.insertQuestion(arts_and_music_question1);
        Question arts_and_music_question2 = new Question(501, "This 1970s-80s American pop artist is known for simple human and animal forms, with works including 'Radiant Baby' and 'Dancing Dog'... ", "Andy Warhol", "Roy Lichtenstein,", "Keith Haring", "Jean‑Michel Basquiat", "Keith Haring");
        helper.insertQuestion(arts_and_music_question2);
        Question arts_and_music_question3 = new Question(501, "This 1970s-80s American pop artist is known for simple human and animal forms, with works including 'Radiant Baby' and 'Dancing Dog'... ", "Andy Warhol", "Roy Lichtenstein,", "Keith Haring", "Jean‑Michel Basquiat", "Keith Haring");
        helper.insertQuestion(arts_and_music_question3);


        Log.i("Questions", helper.getAllQuestions().toString());

        System.out.println(idHelper.getAllUsedIds()+"used_ids");
    }

}
