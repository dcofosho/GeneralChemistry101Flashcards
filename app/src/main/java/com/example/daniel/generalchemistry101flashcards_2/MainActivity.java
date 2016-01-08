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


    List<Integer> used_Ids;
    ArrayList<String> finished_subjects;
    Bundle extras;
    ArrayList<Integer> usedIds;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        extras=getIntent().getExtras();

        IdHelper idHelper = new IdHelper(this);
        SQLiteDatabase id_db = idHelper.getReadableDatabase();
        used_Ids=idHelper.getAllUsedIds();
        System.out.println("usedId list in mainactivity"+used_Ids);






//        try{
//            used_Ids=idHelper.getAllUsedIds();
//        }catch (Exception e){
//            UsedId usedId = new UsedId(0);
//            idHelper.insertUsedId(usedId);
//            used_Ids=idHelper.getAllUsedIds();
//        }

//

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

//        used_Ids=idHelper.getAllUsedIds();
//        System.out.println("usedId list in mainactivity" + used_Ids);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i;
                ArrayList<Integer> arrayList;
                if (position == 0) {
                    i = new Intent(MainActivity.this, QuestionActivity.class);
                    i.putExtra("subject", "units");
                    arrayList = new ArrayList<>();
                    for (int k = 0; k < 3; k++) {
                        if (!used_Ids.contains(k+100)) {
                            arrayList.add(k + 100);
                        }
                    }
                    i.putIntegerArrayListExtra("id_range", arrayList);

                } else if (position == 1) {
                    i = new Intent(MainActivity.this, QuestionActivity.class);
                    i.putExtra("subject", "periodic");
                    arrayList = new ArrayList<>();
                    for (int k = 0; k < 3; k++) {
                        if (!used_Ids.contains(k+200)) {
                            arrayList.add(k + 200);
                        }
                    }
                    i.putIntegerArrayListExtra("id_range", arrayList);
                } else if (position == 2) {
                    i = new Intent(MainActivity.this, QuestionActivity.class);
                    i.putExtra("subject", "atomic");
                    arrayList = new ArrayList<>();
                    for (int k = 0; k < 3; k++) {
                        if (!used_Ids.contains(k+300)) {
                            arrayList.add(k + 300);
                        }
                    }
                    i.putIntegerArrayListExtra("id_range", arrayList);
                } else if (position == 3) {
                    i = new Intent(MainActivity.this, QuestionActivity.class);
                    i.putExtra("subject", "bonding");
                    arrayList = new ArrayList<>();
                    for (int k = 0; k < 3; k++) {
                        if (!used_Ids.contains(k+400)) {
                            arrayList.add(k + 400);
                        }
                    }
                    i.putIntegerArrayListExtra("id_range", arrayList);
                } else if (position == 4) {
                    i = new Intent(MainActivity.this, QuestionActivity.class);
                    i.putExtra("subject", "ph");
                    arrayList = new ArrayList<>();
                    for (int k = 0; k < 3; k++) {
                        if (!used_Ids.contains(k+500)) {
                            arrayList.add(k + 500);
                        }
                    }
                    i.putIntegerArrayListExtra("id_range", arrayList);
                } else if (position == 5) {
                    i = new Intent(MainActivity.this, QuestionActivity.class);
                    i.putExtra("subject", "electro");
                    arrayList = new ArrayList<>();
                    for (int k = 0; k < 3; k++) {
                        if (!used_Ids.contains(k+600)) {
                            arrayList.add(k + 600);
                        }
                    }
                    i.putIntegerArrayListExtra("id_range", arrayList);
                } else if (position == 6) {
                    i = new Intent(MainActivity.this, QuestionActivity.class);
                    i.putExtra("subject", "solubility");
                    arrayList = new ArrayList<>();
                    for (int k = 0; k < 3; k++) {
                        if (!used_Ids.contains(k+700)) {
                            arrayList.add(k + 700);
                        }
                    }
                    i.putIntegerArrayListExtra("id_range", arrayList);
                } else if (position == 7) {
                    i = new Intent(MainActivity.this, QuestionActivity.class);
                    i.putExtra("subject", "stoich");
                    arrayList = new ArrayList<>();
                    for (int k = 0; k < 3; k++) {
                        if (!used_Ids.contains(k+800)) {
                            arrayList.add(k + 800);
                        }
                    }
                    i.putIntegerArrayListExtra("id_range", arrayList);
                } else {
                    i = new Intent(MainActivity.this, QuestionActivity.class);
                    i.putExtra("subject", "thermo");
                    arrayList = new ArrayList<>();
                    for (int k = 0; k < 3; k++) {
                        if (!used_Ids.contains(k+900)) {
                            arrayList.add(k + 900);
                        }
                    }
                }
                if(arrayList.isEmpty()){
                    Toast.makeText(MainActivity.this,
                            "You've already answered all of those questions! Pick another subject", Toast.LENGTH_LONG).show();
                }else {
                    Collections.shuffle(arrayList);
                    i.putIntegerArrayListExtra("id_range", arrayList);
                    startActivity(i);
                }
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


    }

}
