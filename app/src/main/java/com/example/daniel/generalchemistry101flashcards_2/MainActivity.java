package com.example.daniel.generalchemistry101flashcards_2;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.Layout;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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
public class MainActivity extends AppCompatActivity {


    List<Integer> used_Ids;
    ArrayList<String> finished_subjects;
    Bundle extras;
    ArrayList<Integer> usedIds;
    MyDialog dialog;
    String subject;
    int units_score;
    int periodic_score;
    int atomic_score;
    int bond_score;
    int ph_score;
    int electro_score;
    int solubility_score;
    int stoich_score;
    int thermo_score;
    int score;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        extras=getIntent().getExtras();

        IdHelper idHelper = new IdHelper(this);
        SQLiteDatabase id_db = idHelper.getReadableDatabase();
        SQLiteDatabase id_db2 = idHelper.getWritableDatabase();
        used_Ids=idHelper.getAllUsedIds();
        System.out.println("usedId list in mainactivity"+used_Ids);

        try{
            units_score=extras.getInt("units_score");
        } catch (Exception e){
            units_score = 0;
        }
        try{
           periodic_score=extras.getInt("periodic_score");
        } catch (Exception e){
            periodic_score = 0;
        }

        try{
            atomic_score=extras.getInt("atomic_score");
        } catch (Exception e){
            atomic_score = 0;
        }

        try{
            bond_score=extras.getInt("bond_score");
        } catch (Exception e){
            bond_score = 0;
        }

        try{
            ph_score=extras.getInt("ph_score");
        } catch (Exception e){
            ph_score = 0;
        }

        try{
            electro_score=extras.getInt("electro_score");
        } catch (Exception e){
            electro_score = 0;
        }


        try{
            solubility_score=extras.getInt("solubility_score");
        } catch (Exception e){
            solubility_score = 0;
        }

        try{
            stoich_score=extras.getInt("stoich_score");
        } catch (Exception e){
            stoich_score = 0;
        }

        try{
            thermo_score=extras.getInt("thermo_score");
        } catch (Exception e){
            thermo_score = 0;
        }
        score=units_score+periodic_score+atomic_score+bond_score+ph_score+electro_score+solubility_score+stoich_score+thermo_score;




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
                    subject = "units";
                    arrayList = new ArrayList<>();
                    for (int k = 0; k < 5; k++) {
                        if (!used_Ids.contains(k + 100)) {
                            arrayList.add(k + 100);
                        }
                    }
                    i.putIntegerArrayListExtra("id_range", arrayList);

                } else if (position == 1) {
                    i = new Intent(MainActivity.this, QuestionActivity.class);
                    i.putExtra("subject", "periodic");
                    subject = "periodic";
                    arrayList = new ArrayList<>();
                    for (int k = 0; k < 5; k++) {
                        if (!used_Ids.contains(k + 200)) {
                            arrayList.add(k + 200);
                        }
                    }
                    i.putIntegerArrayListExtra("id_range", arrayList);
                } else if (position == 2) {
                    i = new Intent(MainActivity.this, QuestionActivity.class);
                    i.putExtra("subject", "atomic");
                    subject = "atomic";
                    arrayList = new ArrayList<>();
                    for (int k = 0; k < 5; k++) {
                        if (!used_Ids.contains(k + 300)) {
                            arrayList.add(k + 300);
                        }
                    }
                    i.putIntegerArrayListExtra("id_range", arrayList);
                } else if (position == 3) {
                    i = new Intent(MainActivity.this, QuestionActivity.class);
                    i.putExtra("subject", "bonding");
                    subject = "bonding";
                    arrayList = new ArrayList<>();
                    for (int k = 0; k < 5; k++) {
                        if (!used_Ids.contains(k + 400)) {
                            arrayList.add(k + 400);
                        }
                    }
                    i.putIntegerArrayListExtra("id_range", arrayList);
                } else if (position == 4) {
                    i = new Intent(MainActivity.this, QuestionActivity.class);
                    i.putExtra("subject", "ph");
                    subject = "ph";
                    arrayList = new ArrayList<>();
                    for (int k = 0; k < 5; k++) {
                        if (!used_Ids.contains(k + 500)) {
                            arrayList.add(k + 500);
                        }
                    }
                    i.putIntegerArrayListExtra("id_range", arrayList);
                } else if (position == 5) {
                    i = new Intent(MainActivity.this, QuestionActivity.class);
                    i.putExtra("subject", "electro");
                    subject = "electro";
                    arrayList = new ArrayList<>();
                    for (int k = 0; k < 5; k++) {
                        if (!used_Ids.contains(k + 600)) {
                            arrayList.add(k + 600);
                        }
                    }
                    i.putIntegerArrayListExtra("id_range", arrayList);
                } else if (position == 6) {
                    i = new Intent(MainActivity.this, QuestionActivity.class);
                    i.putExtra("subject", "solubility");
                    subject = "solubility";
                    arrayList = new ArrayList<>();
                    for (int k = 0; k < 5; k++) {
                        if (!used_Ids.contains(k + 700)) {
                            arrayList.add(k + 700);
                        }
                    }
                    i.putIntegerArrayListExtra("id_range", arrayList);
                } else if (position == 7) {
                    i = new Intent(MainActivity.this, QuestionActivity.class);
                    i.putExtra("subject", "stoich");
                    subject = "stoich";
                    arrayList = new ArrayList<>();
                    for (int k = 0; k < 5; k++) {
                        if (!used_Ids.contains(k + 800)) {
                            arrayList.add(k + 800);
                        }
                    }
                    i.putIntegerArrayListExtra("id_range", arrayList);
                } else {
                    i = new Intent(MainActivity.this, QuestionActivity.class);
                    i.putExtra("subject", "thermo");
                    subject = "thermo";
                    arrayList = new ArrayList<>();
                    for (int k = 0; k < 5; k++) {
                        if (!used_Ids.contains(k + 900)) {
                            arrayList.add(k + 900);
                        }
                    }
                }
                if (arrayList.isEmpty()) {
                    dialog = new MyDialog();
                    Bundle args = new Bundle();
                    args.putString("subject", subject);
                    dialog.setArguments(args);
                    dialog.show(getSupportFragmentManager(), "MyDialog");
//                    Toast.makeText(MainActivity.this,
//                            "You've already answered all of those questions! Pick another subject", Toast.LENGTH_LONG).show();
                } else {
                    Collections.shuffle(arrayList);
                    i.putIntegerArrayListExtra("id_range", arrayList);
                    i.putExtra("starting_over", false);
                    startActivity(i);
                }
            }
        });
        DBHelper helper = new DBHelper(this);
        SQLiteDatabase db = helper.getWritableDatabase();

        Question units_question1 = new Question(100,"Volume is a measurement of...", "How much matter is in a sample", "How much space a substance takes up","The ratio of a sample's size to mass", "The ratio of mass to size", "How much space a substance takes up");
        helper.insertQuestion(units_question1);
        Question units_question2 = new Question(101,"Which unit of length is longest?", "Centimeter", "Nanometer","Milimeter", "Decimeter", "Decimeter");
        helper.insertQuestion(units_question2);
        Question units_question3 = new Question(102,"Which correctly describes the difference between mass and weight?", "Mass is measured in kilograms and weight is measured in pounds.", "Objects in space have less mass","Mass is how much matter is in a sample, weight is the force of attraction with the ground", "Mass is the ratio of weight to density", "Mass is how much matter is in a sample, weight is the force of attraction with the ground");
        helper.insertQuestion(units_question3);
        Question units_question4 = new Question(103,"How many centimeters in a kilometer?", "1000", "10,000","100,000", "1,000,000", "100,000");
        helper.insertQuestion(units_question4);
        Question units_question5 = new Question(104,"Water freezes at what temperature?", "0 Celsius", "0 Farenheit", "0 Kelvin", "27 Farenheit", "0 Celsius");
        helper.insertQuestion(units_question5);


        Question periodic_question1 = new Question(200, "Which element has the highest electronegativity?", "Fluorine", "Chlorine", "Barium", "Francium", "Fluorine");
        helper.insertQuestion(periodic_question1);
        Question periodic_question2 = new Question(201, "In the periodic table, atomic radius increases...", "from left to right/top to bottom", "right to left/top to bottom", "left to right/bottom to top", "right to left/bottom to top", "right to left/top to bottom");
        helper.insertQuestion(periodic_question2);
        Question periodic_question3 = new Question(202, "Atomic number is...", "The number of neutrons in an element's nucleus", "The ratio of protons to neutrons", "The number of protons in an atom's nucleus", "The ratio of protons to electrons", "The number of protons in an atom's nucleus");
        helper.insertQuestion(periodic_question3);
        Question periodic_question4 = new Question(203, "In the periodic table, atomic mass decreases", "from left to right/top to bottom", "right to left/top to bottom", "left to right/bottom to top", "right to left/bottom to top", "left to right/bottom to top");
        helper.insertQuestion(periodic_question4);
        Question periodic_question5 = new Question(204, "Metals are elements which....", "try to gain electrons, and are found on the right side of the periodic table.", "try to lose electrons, and are found on the left side of the periodic table.", "try to gain electrons, and are found on the top of the periodic table.", "try to lose electrons, and are found on the bottom of the periodic table.", "try to lose electrons, and are found on the left side of the periodic table.");
        helper.insertQuestion(periodic_question5);


        Question atomic_question1 = new Question(300, "The charge on an electron is...", "equal to a proton's charge in magnitude and sign", "smaller than a proton's charge in magnitude but equal in sign", "equal to a proton's charge in magnitude but opposite sign", "greater than a protons charge but opposite sign", "equal to a proton's charge in magnitude but opposite sign");
        helper.insertQuestion(atomic_question1);
        Question atomic_question2 = new Question(301, "Different isotopes of an element have different numbers of...", "Neutrons", "Protons", "Electrons", "Nuclei", "Neutrons");
        helper.insertQuestion(atomic_question2);
        Question atomic_question3 = new Question(302, "The chemical behavior of an atom is mostly determined by...", "The valence electrons, i.e. those closest to the nucleus", "The valence electrons, i.e. those furthest to the nucleus", "The inner electrons, i.e. those closest to the nucleus", "All the electrons in the electron cloud", "The valence electrons, i.e. those furthest to the nucleus");
        helper.insertQuestion(atomic_question3);
        Question atomic_question4 = new Question(303, "Different ions of an element have different numbers of...", "Neutrons", "Protons", "Electrons", "Nuclei", "Electrons");
        helper.insertQuestion(atomic_question4);
        Question atomic_question5 = new Question(304, "All atoms of a given element have the same number of...", "Neutrons", "Protons", "Electrons", "Nuclei", "Protons");
        helper.insertQuestion(atomic_question5);


        Question bonding_question1 = new Question(400, "Ionic bonds occur...", "Between metals only", "Between non-metals only", "Between metalloids only", "Between metals and non-metals, or polyatomic ions", "Between metals and non-metals, or polyatomic ions");
        helper.insertQuestion(bonding_question1);
        Question bonding_question2 = new Question(401, "Non-polar bonds occur...", "Between metals only", "Between non-metals only", "Between two atoms of the same element only", "Between polyatomic ions only", "Between two atoms of the same element only");
        helper.insertQuestion(bonding_question2);
        Question bonding_question3 = new Question(402, "Polar molecules are characterized by...", "Asymmetric distribution of charge", "Symmetric distribution of charge", "Total positive charge", "total negative charge", "Asymmetric distribution of charge");
        helper.insertQuestion(bonding_question3);
        Question bonding_question4 = new Question(403, "Covalent bonds are formed when...", "Electrons are transferred between atoms", "Protons are transferred between atoms", "Electrons change energy levels", "Electrons are shared between atoms", "Electrons are shared between atoms");
        helper.insertQuestion(bonding_question4);
        Question bonding_question5 = new Question(404, "Which is the proper order, from weakest to strongest?", "Ionic, non-polar covalent, polar covalent", "Polar covalent, non-polar covalent, ionic", "non-polar covalent, polar covalent, ionic", "Ionic, polar covalent, non-polar covalent", "non-polar covalent, polar covalent, ionic");
        helper.insertQuestion(bonding_question5);

        Question ph_question1 = new Question(500,"Strong acids differ from weak acids in that...", "Strong acids are lower on the pH scale", "Weak Acids are soluble in water","Strong acids fully dissociate into ions in solution", "Strong acids only react with strong bases", "Strong acids fully dissociate into ions in solution");
        helper.insertQuestion(ph_question1);
        Question ph_question2 = new Question(501,"The modern understanding of acids and bases is described by these three theoretical frameworks...", "Arrhenius, Dalton, Lavoisier", "Bronsted, Lowrey, Lewis","Bronsted, Dalton, and Thompson", "Arrhenius, Bronsted-Lowry, Lewis", "Arrhenius, Bronsted-Lowry, Lewis");
        helper.insertQuestion(ph_question2);
        Question ph_question3 = new Question(502,"Acids produce which ion in aqueous solutions?", "Hydronium (H+)", "Hydroxide (OH-)","Peroxide (O-)", "Carbonate(CO2-3)", "Hydronium (H+)");
        helper.insertQuestion(ph_question3);
        Question ph_question4 = new Question(503,"According to the Bronsted-Lowry theory...", "Acids are electron donors and Bases are proton acceptors", "Acids are proton donors and bases are proton acceptors","Acids are electron acceptors and bases are electron donors", "Acids and bases accept and donate both protons and electrons", "Acids are proton donors and bases are proton acceptors");
        helper.insertQuestion(ph_question4);
        Question ph_question5 = new Question(504,"Bases produce which ion in aqueous solutions?", "Hydronium (H+)", "Hydroxide (OH-)","Peroxide (O-)", "Carbonate(CO2-3)", "Hydroxide (OH-)");
        helper.insertQuestion(ph_question5);

        Question electro_question1 = new Question(600, "Electrons flow in which direction in a battery (electrochemical cell)?", "Anode to cathode only", "Cathode to anode only", "Both directions", "Depends on the type of battery", "Anode to cathode only");
        helper.insertQuestion(electro_question1);
        Question electro_question2 = new Question(601, "In an electrolytic cell...", "Electrons flow from anode to cathode and electricity is produced", "Electrons flow from anode to cathode and electricity is used", "Electrons flow from cathode to anode and electricity is produced", "Electrons flow from cathode to anode and electricity is used", "Electrons flow from anode to cathode and electricity is used");
        helper.insertQuestion(electro_question2);
        Question electro_question3 = new Question(602, "When an substance is reduced...", "It loses electrons and decreases in charge", "It gains electrons and decreases in charge", "It gains protons and increases in charge", "It gains electrons and increases in charge", "It gains electrons and decreases in charge");
        helper.insertQuestion(electro_question3);
        Question electro_question4 = new Question(603, "The cathode of a battery (electrochemical cell)...", "is more electronegative than the anode", "is less electronegative than the anode", "has greater molar mass than the anode", "has smaller molar mass than the anode", "is more electronegative than the anode");
        helper.insertQuestion(electro_question4);
        Question electro_question5 = new Question(604, "In an electrochemical cell...", "Electrons flow from anode to cathode and electricity is produced", "Electrons flow from anode to cathode and electricity is used", "Electrons flow from cathode to anode and electricity is produced", "Electrons flow from cathode to anode and electricity is used", "Electrons flow from anode to cathode and electricity is produced");
        helper.insertQuestion(electro_question5);

        Question solubility_question1 = new Question(700, "Solutes dissolve in solvents with...", "similar chemical properties", "different chemical properties", "a high number of ions", "a low number of ions", "similar chemical properties");
        helper.insertQuestion(solubility_question1);
        Question solubility_question2 = new Question(701, "Oil does not mix with water because", "Oil and water have opposite polarities", "Oil is polar and water is non-polar", "Water is polar and oil is non-polar", "Water is polar and oil is ionic", "Water is polar and oil is non-polar");
        helper.insertQuestion(solubility_question2);
        Question solubility_question3 = new Question(702, "Aqueous solutions are solutions in which...", "water is the solute", "ions are the solute", "water is the solvent", "The ratio of solute to solvent is 1", "water is the solvent");
        helper.insertQuestion(solubility_question3);
        Question solubility_question4 = new Question(703, "Molarity (molar) is a unit of concentration defined as:", "moles of solute divided by liters of solution", "moles of solvent divided by liters of solute", "moles of solute divided by liters of solution", "moles of solute divided by kilograms of solution", "moles of solute divided by liters of solution");
        helper.insertQuestion(solubility_question4);
        Question solubility_question5 = new Question(704, "Molality (molal) is a unit of concentration defined as:", "moles of solute divided by liters of solvent", "moles of solvent divided by liters of solute", "moles of solute divided by liters of solution", "moles of solute divided by kilograms of solvent", "moles of solute divided by kilograms of solvent");
        helper.insertQuestion(solubility_question5);


        Question stoich_question1 = new Question(800, "Which equation shows a double replacement reaction?", "A→BC", "A+B→AB", "AB+CD→AD+CB", "AB+C→AC+B", "AB+CD→AD+CB");
        helper.insertQuestion(stoich_question1);
        Question stoich_question2 = new Question(801, "Which equation shows a single replacement reaction?", "A→BC", "A+B→AB", "AB+CD→AD+CB", "AB+C→AC+B", "AB+C→AC+B");
        helper.insertQuestion(stoich_question2);
        Question stoich_question3 = new Question(802, "Which equation shows a synthesis reaction?", "A→BC", "A+B→AB", "AB+CD→AD+CB", "AB+C→AC+B", "A+B→AB");
        helper.insertQuestion(stoich_question3);
        Question stoich_question4 = new Question(803, "The reverse of a synthesis reaction is...", "double replacement","decomposition","single replacement","oxidation","decomposition");
        helper.insertQuestion(stoich_question4);
        Question stoich_question5 = new Question(804, "The reverse of a double replacement reaction is...", "double replacement","decomposition","single replacement","oxidation","double replacement");
        helper.insertQuestion(stoich_question5);


        Question thermo_question1 = new Question(900, "Exothermic reactions are reactions which...", "release heat", "absorb heat", "for a precipitate", "convert heat to electricity", "release heat");
        helper.insertQuestion(thermo_question1);
        Question thermo_question2 = new Question(901, "Endothermic reactions are reactions which...", "release heat", "absorb heat", "for a precipitate", "convert heat to electricity", "absorb heat");
        helper.insertQuestion(thermo_question2);
        Question thermo_question3 = new Question(902, "Increasing the temperature will have what impact on an exothermic reaction?", "The reaction would slow down", "The reaction would speed up", "The reaction would stop", "The reaction would proceed at the same rate", "The reaction would slow down");
        helper.insertQuestion(thermo_question3);
        Question thermo_question4 = new Question(903, "Increasing the temperature will have what impact on an endothermic reaction?", "The reaction would slow down", "The reaction would speed up", "The reaction would stop", "The reaction would proceed at the same rate", "The reaction would speed up");
        helper.insertQuestion(thermo_question4);
        Question thermo_question5 = new Question(904, "Combustion occurs when...", "fuel reacts exothermically with oxygen", "fuel reacts endothermically with oxygen", "fuel reacts exothermically with hydrogen", "fuel reacts endothermically with nitrogen", "fuel reacts exothermically with oxygen");
        helper.insertQuestion(thermo_question5);



        Log.i("Questions", helper.getAllQuestions().toString());


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater M = getMenuInflater();
        M.inflate(R.menu.main, menu);

//        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.settings) {
            Toast.makeText(getApplicationContext(), "clicked on setting", Toast.LENGTH_LONG).show();
            return true;
        }else if (id == R.id.bookmarks) {
            Intent intent;
            intent = new Intent(MainActivity.this, ScoreboardActivity.class);
            intent.putExtra("units_score", units_score);
            intent.putExtra("periodic_score", periodic_score);
            intent.putExtra("atomic_score", atomic_score);
            intent.putExtra("bond_score", bond_score);
            intent.putExtra("ph_score", ph_score);
            intent.putExtra("electro_score", electro_score);
            intent.putExtra("solubility_score", solubility_score);
            intent.putExtra("stoich_score", stoich_score);
            intent.putExtra("thermo_score", thermo_score);
//            finish();
            startActivity(intent);
//            Toast.makeText(getApplicationContext(), "clicked on bookmarks", Toast.LENGTH_LONG).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
