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
                IdHelper idHelper = new IdHelper(getBaseContext());
                SQLiteDatabase id_db = idHelper.getReadableDatabase();
                SQLiteDatabase id_db2 = idHelper.getWritableDatabase();
                used_Ids=idHelper.getAllUsedIds();
                System.out.println("usedId list in mainactivity"+used_Ids);
                ArrayList<Integer> arrayList;
                if (position == 0) {
                    i = new Intent(MainActivity.this, QuestionActivity.class);
                    i.putExtra("subject", "units");
                    subject = "units";
                    arrayList = new ArrayList<>();
                    for (int k = 0; k < 20; k++) {
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
                    for (int k = 0; k < 20; k++) {
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
                    for (int k = 0; k < 20; k++) {
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
                    for (int k = 0; k < 20; k++) {
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
                    for (int k = 0; k < 20; k++) {
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
                    for (int k = 0; k < 20; k++) {
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
                    for (int k = 0; k < 20; k++) {
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
                    for (int k = 0; k < 20; k++) {
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
                    for (int k = 0; k < 20; k++) {
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
        Question units_question5 = new Question(104,"Water freezes at what temperature?", "0 Celsius", "0 Fahrenheit", "0 Kelvin", "27 Farenheit", "0 Celsius");
        helper.insertQuestion(units_question5);
        Question units_question6=new Question(105, "What is the SI Unit for pressure?", "Pascal", "Newton", "Joule", "Kilojoule","Pascal");
        helper.insertQuestion(units_question6);
        Question units_question7=new Question(106, "Standard atmospheric pressure is...", "1 Pa", "100 bar","50 mmHg", "101.325 kPa","101.325 kPa");
        helper.insertQuestion(units_question7);
        Question units_question8=new Question(107, "Typical ambient temperature (i.e. 'room temperature') is around...", "20 K", "20 C", "0 C", "0K", "20 C");
        helper.insertQuestion(units_question8);
        Question units_question9 = new Question(108,"Water boils at what temperature?", "100 Celsius", "100 Fahrenheit", "1000 Kelvin", "27 Fahrenheit", "100 Celsius");
        helper.insertQuestion(units_question9);
        Question units_question10 = new Question(109, "All of the following are units of pressure except...", "Bar", "Atmosphere", "Milimeters of Hg", "Joule", "Joule");
        helper.insertQuestion(units_question10);
        Question units_question11 = new Question(110,"Which unit of length is longest?", "Kilometer", "Hectometer","Megameter", "Picometer", "Megameter");
        helper.insertQuestion(units_question11);
        Question units_question12 = new Question(111,"How many megabytes are in a gigabyte?", "a million", "a thousand","a billion", "1/1000", "a thousand");
        helper.insertQuestion(units_question12);
        Question units_question13 = new Question(112,"How many kilobytes are in a gigabyte?", "a million", "a thousand","a billion", "1/1000", "a million");
        helper.insertQuestion(units_question13);
        Question units_question14 = new Question(113,"How many kilobytes are in a megabyte?", "a million", "a thousand","a billion", "1/1000", "a thousand");
        helper.insertQuestion(units_question14);
        Question units_question15 = new Question(114, "What is absolute zero?", "The temperature at which all liquids freeze","Exactly 0 degrees Celsius", "0 degrees Fahrenheit", "The theoretical coldest temperature possible", "The theoretical coldest temperature possible");
        helper.insertQuestion(units_question15);
        Question units_question16 = new Question(115, "What is absolute zero?", "-450 C","0 Kelvin", "-273 F", "-100K", "0 Kelvin");
        helper.insertQuestion(units_question16);
        Question units_question17=new Question(116, "What is the SI Unit for Energy?", "Watt", "Newton", "Joule", "Kilowatt","Joule");
        helper.insertQuestion(units_question17);
        Question units_question18=new Question(117, "What is the SI Unit for Volume?", "Liter", "Gallon", "Quart", "Cubic Meter","Liter");
        helper.insertQuestion(units_question18);
        Question units_question19=new Question(118, "What is the SI Unit for Mass?", "Pound", "Kilogram", "Liter", "Cubic Meter","Kilogram");
        helper.insertQuestion(units_question19);
        Question units_question20=new Question(119, "Density is...", "mass divided by volume", "mass divided by diameter", "volume divided by mass", "lengths divided by mass squared","mass divided by volume");
        helper.insertQuestion(units_question20);




        Question periodic_question1 = new Question(200, "Which element has the highest electronegativity?", "Fluorine", "Chlorine", "Barium", "Francium", "Fluorine");
        helper.insertQuestion(periodic_question1);
        Question periodic_question2 = new Question(201, "In the periodic table, atomic radius increases...", "from left to right/top to bottom", "right to left/top to bottom", "left to right/bottom to top", "right to left/bottom to top", "right to left/top to bottom");
        helper.insertQuestion(periodic_question2);
        Question periodic_question3 = new Question(202, "Atomic number is...", "The number of neutrons in an element's nucleus", "The ratio of protons to neutrons", "The number of protons in an atom's nucleus", "The ratio of protons to electrons", "The number of protons in an atom's nucleus");
        helper.insertQuestion(periodic_question3);
        Question periodic_question4 = new Question(203, "In the periodic table, atomic mass decreases...", "from left to right/top to bottom", "right to left/top to bottom", "left to right/bottom to top", "right to left/bottom to top", "left to right/bottom to top");
        helper.insertQuestion(periodic_question4);
        Question periodic_question5 = new Question(204, "Metals are elements which....", "try to gain electrons, and are found on the right side of the periodic table.", "try to lose electrons, and are found on the left side of the periodic table.", "try to gain electrons, and are found on the top of the periodic table.", "try to lose electrons, and are found on the bottom of the periodic table.", "try to lose electrons, and are found on the left side of the periodic table.");
        helper.insertQuestion(periodic_question5);
        Question periodic_question6 = new Question(205, "Which element has the largest atomic radius?", "Fluorine", "Chlorine", "Bromine", "Iodine", "Iodine");
        helper.insertQuestion(periodic_question6);
        Question periodic_question7 = new Question(206, "Which element has the largest atomic radius?", "Silicon (Si)", "Phosphorous (P)", "Sulfur (S)", "Chlorine (Cl)", "Silicon (Si)");
        helper.insertQuestion(periodic_question7);
        Question periodic_question8 = new Question(207, "Which element has the smallest atomic radius?", "Silicon (Si)", "Phosphorous (P)", "Sodium (Na)", "Magnesium (Mg)", "Sodium (Na)");
        helper.insertQuestion(periodic_question8);
        Question periodic_question9 = new Question(208, "In the periodic table, first ionization energy increases...", "from left to right/top to bottom", "right to left/top to bottom", "left to right/bottom to top", "right to left/bottom to top", "left to right/bottom to top");
        helper.insertQuestion(periodic_question9);
        Question periodic_question10 = new Question(209, "Most elements on the periodic table are...", "Metals", "Non-metals", "Metalloids", "Gases", "Metals");
        helper.insertQuestion(periodic_question10);
        Question periodic_question11 = new Question(210, "At room temperature, most elements on the periodic table are...", "Solids", "Liquids", "Gases","Plasmas", "Solids");
        helper.insertQuestion(periodic_question11);
        Question periodic_question12 = new Question(211, "Which element is most electronegative?", "Silicon (Si)", "Phosphorous (P)", "Sodium (Na)", "Magnesium (Mg)", "Phosphorous (P)");
        helper.insertQuestion(periodic_question12);
        Question periodic_question13 = new Question(212, "Non-metals are elements which....", "try to gain electrons, and are found on the right side of the periodic table.", "try to lose electrons, and are found on the left side of the periodic table.", "try to gain electrons, and are found on the top of the periodic table.", "try to lose electrons, and are found on the bottom of the periodic table.", "try to gain electrons, and are found on the right side of the periodic table.");
        helper.insertQuestion(periodic_question13);
        Question periodic_question14 = new Question(213, "Which element has the greatest first ionization energy?", "Lithium (Li)", "Boron (B)", "Carbon (C)", "Neon (Ne)", "Neon (Ne)");
        helper.insertQuestion(periodic_question14);
        Question periodic_question15 = new Question(214, "Which element is a halogen?", "Lithium (Li)", "Beryllium (Be)", "Iodine (I)", "Neon (Ne)", "Iodine (I)");
        helper.insertQuestion(periodic_question15);
        Question periodic_question16 = new Question(215, "Which element is a alkali earth metal?", "Lithium (Li)", "Beryllium (Be)", "Iodine (I)", "Neon (Ne)", "Beryllium (Be)");
        helper.insertQuestion(periodic_question16);
        Question periodic_question17 = new Question(216, "Which element is a alkali metal?", "Lithium (Li)", "Beryllium (Be)", "Iodine (I)", "Neon (Ne)", "Lithium (Li)");
        helper.insertQuestion(periodic_question17);
        Question periodic_question18 = new Question(217, "Which element is a transition metal?", "Cesius (Cs)", "Mercury (Hg)", "Aluminum (Al)", "Magnesium (Mg)", "Mercury (Hg)");
        helper.insertQuestion(periodic_question18);
        Question periodic_question19 = new Question(218, "Which element is a nobel gas?", "Nitrogen", "Oxygen", "Hydrogen", "Radon", "Radon");
        helper.insertQuestion(periodic_question19);
        Question periodic_question20 = new Question(219,"Nobel gases are elements which...", "Don't react with other elements because their outer shells are empty", "React with other elements because their outer shells are full", "Don't react with other elements because their outer shells are full", "React with other elements because their shells are empty", "Don't react with other elements because their outer shells are full");
        helper.insertQuestion(periodic_question20);
        //add family and group questions

        Question atomic_question1 = new Question(300, "The charge on an electron is...", "equal to a proton's charge in magnitude and sign", "smaller than a proton's charge in magnitude but equal in sign", "equal to a proton's charge in magnitude but opposite sign", "Zero", "equal to a proton's charge in magnitude but opposite sign");
        helper.insertQuestion(atomic_question1);
        Question atomic_question2 = new Question(301, "Different isotopes of an element have different numbers of...", "Neutrons", "Protons", "Electrons", "Nuclei", "Neutrons");
        helper.insertQuestion(atomic_question2);
        Question atomic_question3 = new Question(302, "The chemical behavior of an atom is mostly determined by...", "The valence electrons, i.e. those closest to the nucleus", "The valence electrons, i.e. those furthest to the nucleus", "The inner electrons, i.e. those closest to the nucleus", "All the electrons in the electron cloud", "The valence electrons, i.e. those furthest to the nucleus");
        helper.insertQuestion(atomic_question3);
        Question atomic_question4 = new Question(303, "Different ions of an element have different numbers of...", "Neutrons", "Protons", "Electrons", "Nuclei", "Electrons");
        helper.insertQuestion(atomic_question4);
        Question atomic_question5 = new Question(304, "All atoms of a given element have the same number of...", "Neutrons", "Protons", "Electrons", "Nucleons", "Protons");
        helper.insertQuestion(atomic_question5);
        Question atomic_question6 = new Question(305, "Different ions of an element have different...", "Masses", "Numbers of protons", "Charges", "Atomic Numbers", "Charges");
        helper.insertQuestion(atomic_question6);
        Question atomic_question7 = new Question(306, "Different isotopes of an element have different...", "Masses", "Numbers of protons", "Charges", "Atomic Numbers", "Masses");
        helper.insertQuestion(atomic_question7);
        Question atomic_question8 = new Question(307, "AMU (atomic mass unit) is a unit of mass roughly equal to...", "The mass of a proton or electron", "The mass of an electron or neutron", "The mass of an electron or photon", "The mass of a proton or neutron", "The mass of a proton or neutron");
        helper.insertQuestion(atomic_question8);
        Question atomic_question9= new Question(308, "A single nucleus of Carbon-14 contains ___ neutrons", "5", "6","7","8","8");
        helper.insertQuestion(atomic_question9);
        Question atomic_question10= new Question(309, "A single nucleus of Nitrogen-12 contains ___ neutrons", "5", "6","7","8","5");
        helper.insertQuestion(atomic_question10);
        Question atomic_question11 = new Question(310, "An alpha particle is a helium nucleus containing ___ protons & ____ neutrons", "2 & 0", "2 & 1","2 & 2","2 & 3","2 & 2");
        helper.insertQuestion(atomic_question11);
        Question atomic_question12 = new Question(311, "a nucleus of Bromine-80 contains ___ protons & ____ neutrons", "35 & 45", "45 & 35","35 & 80","80 & 35","35 & 45");
        helper.insertQuestion(atomic_question12);
        Question atomic_question13 = new Question(312, "a nucleus of deuterium (hydrogen-2) contains ___ protons & ____ neutrons", "1 & 2", "1 & 1","1 & 0","2 & 1","1 & 1");
        helper.insertQuestion(atomic_question13);
        Question atomic_question14 = new Question(313, "A sulfur ion has 10 electrons orbiting the nucleus; what is the charge?", "-10", "+6", "-6", "+10", "+6");
        helper.insertQuestion(atomic_question14);
        Question atomic_question15=new Question(314, "Peroxide is an oxygen ion with a charge of -1; how many electrons are orbiting the nucleus?", "1","7","8","9","9");
        helper.insertQuestion(atomic_question15);
        Question atomic_question16=new Question(315, "Br+7 is a bromine ion with a charge of +7; how many electrons are orbiting the nucleus?", "35","28","42","73","28");
        helper.insertQuestion(atomic_question16);
        Question atomic_question17=new Question(316, "Rutherford's gold foil experiment proved...", "That nuclei contain neutrons", "That atoms contain negatively charged particles", "That alpha particles come from unstable nuclei", "That atoms are mostly empty space","That atoms are mostly empty space");
        helper.insertQuestion(atomic_question17);
        Question atomic_question18=new Question(317, "JJ Thomson's cathode ray tube experiment proved...", "That nuclei contain neutrons", "That atoms contain negatively charged particles", "That alpha particles come from unstable nuclei", "That atoms are mostly empty space","That atoms contain negatively charged particles");
        helper.insertQuestion(atomic_question18);
        Question atomic_question19 = new Question(318, "When an atom's nucleus emits a neutron, a ____________ is formed", "An ion of the same element", "An ion of a different element", "A different isotope of the same element", "An ion of an isotope", "A different isotope of the same element");
        helper.insertQuestion(atomic_question19);
        Question atomic_question20=new Question(319, "Mercury(II) is a mercury ion with a charge of +2; how many electrons are orbiting the nucleus?", "78","82","202","198","78");
        helper.insertQuestion(atomic_question20);






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
        Question bonding_question6 = new Question(405, "Intramolecular forces are...", "Attraction between different molecules", "Bonds between molecules and atoms", "Bonds between atoms within a single molecule", "Bonds between protons in a single atom", "Bonds between atoms within a single molecule");
        helper.insertQuestion(bonding_question6);
        Question bonding_question7 = new Question(406, "Intermolecular forces are...", "Attraction between different molecules", "Bonds between molecules and atoms", "Bonds between atoms within a single molecule", "Bonds between protons in a single atom", "Attraction between different molecules");
        helper.insertQuestion(bonding_question7);
        Question bonding_question8 = new Question(407, "All of the following are Intramolecular forces except...", "Polar bonds", "Non-polar bonds", "Ionic Bonds", "Hydrogen Bonds", "Hydrogen Bonds");
        helper.insertQuestion(bonding_question8);
        Question bonding_question9 = new Question(408, "All of the following are Intermolecular forces except...", "London Dispersion Forces", "Van der Waal Forces", "Hydrogen Bonds", "Metallic Bonds", "Metallic Bonds");
        helper.insertQuestion(bonding_question9);
        Question bond_question10= new Question(409, "Intermolecular forces of attraction are ________ compared to intramolecular forces", "stronger", "weaker", "equal", "opposite", "weaker");
        helper.insertQuestion(bond_question10);
        Question bond_question11 = new Question(410, "An ideal gas is a theoretical gas in which", "Intermolecular forces of attraction are zero", "Intramolecular forces of attraction are zero","Intermolecular forces of attraction are very high", "Intramolecular forces of attraction are very high", "Intermolecular forces of attraction are zero");
        helper.insertQuestion(bond_question11);
        Question bond_question12 = new Question(411, "_________ is an example of a polar molecule", "Carbon dioxide", "O2", "Water","Sodium Chloride","Water");
        helper.insertQuestion(bond_question12);
        Question bond_question13=new Question(412,"Water's chemical behavior is largely because of it's ____________ geometry", "Symmetric Linear", "Asymmetric Bent", "Asymmetric Linear", "Symetric Tetrahedral","Asymmetric Bent");
        helper.insertQuestion(bond_question13);
        Question bonding_question14 = new Question(413, "Ionic bonds are formed when...", "Electrons are transferred between atoms", "Electrons are shared evenly between atoms", "Electrons change energy levels", "Electrons are shared unevenly between atoms", "Electrons are transferred between atoms");
        helper.insertQuestion(bonding_question14);
        Question bond_question15 = new Question(414, "_________ is an example of an ionic compound", "Carbon dioxide", "O2", "Water","Sodium Chloride","Sodium Chloride");
        helper.insertQuestion(bond_question15);
        Question bonding_question16 = new Question(415, "Polar covalent bonds are formed when...", "Electrons are transferred between atoms", "Electrons are shared evenly between atoms", "Electrons change energy levels", "Electrons are shared unevenly between atoms", "Electrons are shared unevenly between atoms");
        helper.insertQuestion(bonding_question16);
        Question bonding_question17 = new Question(416, "Non-polar covalent bonds are formed when...", "Electrons are transferred between atoms", "Electrons are shared evenly between atoms", "Electrons change energy levels", "Electrons are shared unevenly between atoms", "Electrons are shared evenly between atoms");
        helper.insertQuestion(bonding_question17);
        Question bonding_question18 = new Question(417, "All molecules...", "Contain at least one covalent bond", "Contain at least one ionic bond", "Contain zero ionic bonds", "Contain zero covalent bond", "Contain at least one covalent bond");
        helper.insertQuestion(bonding_question18);
        Question bond_question19 = new Question(418, "_________ is an example of a non-polar molecule", "Carbon dioxide", "Ammonia", "Water","Sodium Chloride","Carbon dioxide");
        helper.insertQuestion(bond_question19);
        Question bond_question20=new Question(419,"Carbon dioxide's chemical behavior is largely because of it's ____________ geometry", "Symmetric Linear", "Asymmetric Bent", "Asymmetric Linear", "Symetric Tetrahedral","Symmetric Linear");
        helper.insertQuestion(bond_question20);










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
        Question ph_question6 = new Question(505,"As the pH of a solution increases....", "It becomes more acidic", "It becomes more basic", "It becomes a stronger acid", "It becomes a stronger base", "It becomes more basic");
        helper.insertQuestion(ph_question6);
        Question ph_question7 = new Question(506,"Bases taste _______ and turn litmus paper __________", "sour, blue", "bitter, blue", "bitter, red", "sour, red", "bitter, blue");
        helper.insertQuestion(ph_question7);
        Question ph_question8 = new Question(507,"Acids taste _______ and turn litmus paper __________", "sour, blue", "bitter, blue", "bitter, red", "sour, red", "sour, red");
        helper.insertQuestion(ph_question8);
        Question ph_question9 = new Question(508,"As the pH of a solution decreases....", "It becomes more acidic", "It becomes more basic", "It becomes a stronger acid", "It becomes a stronger base", "It becomes more acidic");
        helper.insertQuestion(ph_question9);
        Question ph_question10 = new Question(509,"The pH of pure water, neither acidic nor basic, is...", "0", "7", "14", "21", "7");
        helper.insertQuestion(ph_question10);
        Question ph_question11= new Question(510,"When the concentration of hydronium (H+) in solution increases tenfold, the pH...","Increases by 10", "Decreases by 10", "Increases by 1", "Decreases by 1", "Decreases by 1");
        helper.insertQuestion(ph_question11);
        Question ph_question12= new Question(511,"When the concentration of hydronium (H+) in solution increases one hundred-fold, the pH...","Increases by 100", "Decreases by 100", "Increases by 2", "Decreases by 2", "Decreases by 2");
        helper.insertQuestion(ph_question12);
        Question ph_question13 = new Question(512,"According to the Lewis theory...", "Acids are electron donors and Bases are proton acceptors", "Acids are proton donors and bases are proton acceptors","Acids are electron acceptors and bases are electron donors", "Acids and bases accept and donate both protons and electrons", "Acids are electron acceptors and bases are electron donors");
        helper.insertQuestion(ph_question13);
        Question ph_question14=new Question(513, "Which is the correct equation for pH?", "pH = log(-[H+])","pH = -log([H+])","pH = -log( -[H+] )","pH = log([H+])", "pH = -log([H+])");
        helper.insertQuestion(ph_question14);
        Question ph_question15=new Question(514, "The STRENGTH of an acid or base refers to...", "pH", "Concentration", "dissociation/ionization in solution", "Corrosive ability", "dissociation/ionization in solution");
        helper.insertQuestion(ph_question15);
        Question ph_question16=new Question(515,"pH is...", "an intrinsic property of an acid or base", "a measurement of an acid or base's strengh", "a measurement of acid/base concentration in solution", "a measurement of acid/base solubility","a measurement of acid/base concentration in solution");
        helper.insertQuestion(ph_question16);
        Question ph_question17=new Question(516, "A solution with a pH of 7 has ______ times _______ hydronium (H+) than a solution with a pH of 4", "3, more", "3, less", "1000, more","1000, less", "1000, less");
        helper.insertQuestion(ph_question17);
        Question ph_question18=new Question(517, "A solution with a pH of 5 has ______ times _______ hydronium (H+) than a solution with a pH of 0", "5, more", "5, less", "100,000, more","100,000, less", "100,000, less");
        helper.insertQuestion(ph_question18);
        Question ph_question19 = new Question(518, "Acids, bases, and salts are all", "Ionic compounds", "Molecular compounds", "Oxidizers", "Electrolytes", "Electrolytes");
        helper.insertQuestion(ph_question19);
        Question ph_question20 = new Question(519, "Acid + Base → _______ + _________", "Base + Acid", "Water + Carbon Dioxide", "Water + Salt", "Water + Ion", "Water + Salt");
        helper.insertQuestion(ph_question20);








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
        Question electro_question6 = new Question(605, "In electrochemical cells, the anode and cathode are connected by...", "A salt-bridge", "An insulator", "An electrode", "A glass tube", "A salt-bridge");
        helper.insertQuestion(electro_question6);
        Question electro_question7=new Question(606, "Electrolytic cells can be used for all the following except...", "Electroplating", "Hydrogen production", "Electricity production","Recharging batteries","Electricity production");
        helper.insertQuestion(electro_question7);
        Question electro_question8=new Question(607, "Chemical reactions in electrochemical cells have all of the following properties, except", "spontaneity", "exothermicity", "positive heat of reaction", "positive voltage", "positive heat of reaction");
        helper.insertQuestion(electro_question8);
        Question electro_question9 = new Question(608, "In a zinc-copper electrochemical cell...","Zinc is reduced at the anode", "Copper is oxidized at the cathode", "Zinc is oxidized at the anode", "Copper is oxidized at the anode", "Zinc is oxidized at the anode");
        helper.insertQuestion(electro_question9);
        Question electro_question10 = new Question(609, "When an substance is oxidized...", "It loses electrons and increases in charge", "It gains electrons and decreases in charge", "It gains protons and increases in charge", "It gains electrons and increases in charge", "It loses electrons and increases in charge");
        helper.insertQuestion(electro_question10);
        Question electro_question11= new Question(610, "In an electrochemical cell, _____ energy is converted to ____ energy", "chemical ; heat", "chemical ; electrical", "electrical ; chemical", "nuclear ; electrical", "chemical ; electrical");
        helper.insertQuestion(electro_question11);
        Question electro_question12= new Question(611, "In an electrolytic cell, _____ energy is converted to _____ energy", "chemical ; heat", "chemical ; electrical", "electrical ; chemical", "nuclear ; electrical", "electrical ; chemical");
        helper.insertQuestion(electro_question12);
        Question electro_question13 = new Question(612, "In electrochemical cells, salt-bridges are required to...", "Open the circuit by blocking exchange of ions", "Close the circuit by allowing exchange of ions", "Close the circuit by blocking exchange of ions", "Open the circuit by allowing exchange of ions", "Close the circuit by allowing exchange of ions");
        helper.insertQuestion(electro_question13);
        Question electro_question14 = new Question(613, "In a iron-copper electrochemical cell...","Zinc is reduced at the anode", "Copper is oxidized at the cathode", "Iron is oxidized at the anode", "Copper is oxidized at the anode", "Iron is oxidized at the anode");
        helper.insertQuestion(electro_question14);
        Question electro_question15 = new Question(614, "In a gold-copper electrochemical cell...","Gold is reduced at the anode", "Copper is oxidized at the cathode", "Gold is oxidized at the anode", "Copper is oxidized at the anode", "Copper is oxidized at the anode");
        helper.insertQuestion(electro_question15);
        Question electro_question16 = new Question(615, "In a zinc-tin electrochemical cell...","Zinc is reduced at the anode", "Tin is oxidized at the cathode", "Zinc is oxidized at the anode", "Tin is oxidized at the anode", "Zinc is oxidized at the anode");
        helper.insertQuestion(electro_question16);
        Question electro_question17 = new Question(616, "Reactions in electrolytic cells are...", "Non-spontaneous", "Exothermic", "Decompositions", "Positive Voltage", "Non-spontaneous");
        helper.insertQuestion(electro_question17);
        Question electro_question18= new Question(617, "Batteries die when the reaction...", "goes to completion", "comes to equilibrium", "reverses", "slows down", "comes to equilibrium");
        helper.insertQuestion(electro_question18);
        Question electro_question19= new Question(618, "Equilibrium constants for redox reactions are generally", "Very large", "Very small", "Zero", "Negative", "Very large");
        helper.insertQuestion(electro_question19);
        Question electro_question20 = new Question(619, "______ and ______ are good conductors of electricity", "Metals and non-metals", "Metals and ionic solids", "Non-metals and electrolytes in solution", "Metals and electrolytes in solution","Metals and electrolytes in solution");
        helper.insertQuestion(electro_question20);
















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
        Question solubility_question6=new Question(705, "When the concentration of a solution increases, the boiling point...", "increases", "decreases", "is not changed", "depends on the solute", "increases");
        helper.insertQuestion(solubility_question6);
        Question solubility_question7=new Question(706, "When the concentration of a solution increases, the freezing point...", "increases", "decreases", "is not changed", "depends on the solute", "decreases");
        helper.insertQuestion(solubility_question7);
        Question solubility_question8=new Question(707, "Colligative properties of solutions depend on _____ but do not depend on ______", "concentration, solvent", "solute, concentration", "concentration, solute", "vapor pressure, solution", "concentration, solute");
        helper.insertQuestion(solubility_question8);
        Question solubility_question9=new Question(708, "All of the following are colligative properties of a solution except", "Freezing point depression","Boiling point elevation", "Osmotic pressure", "pH", "pH");
        helper.insertQuestion(solubility_question9);
        Question solubility_question10=new Question(709, "Vapor pressure of a solution is...", "The pressure exerted by a solution on it's surroundings", "The ambient pressure at which a liquid will boil", "a value which varies with temperature and concentration", "all of the above", "all of the above");
        helper.insertQuestion(solubility_question10);
        Question solubility_question11=new Question(710, "If solute is added to a saturated solution...", "The solution will become unsaturated", "A reaction will occur", "The solution will increase in temperature", "A precipitate will form", "A precipitate will form");
        helper.insertQuestion(solubility_question11);
        Question solubility_question12=new Question(711,"A solution which is below the solubility curve is...", "Unsaturated", "Saturated", "Super-saturated", "Not enough information to say", "Unsaturated");
        helper.insertQuestion(solubility_question12);
        Question solubility_question13=new Question(712,"A solution which is above the solubility curve is...", "Unsaturated", "Saturated", "Super-saturated", "Not enough information to say", "Super-saturated");
        helper.insertQuestion(solubility_question13);
        Question solubility_question14=new Question(713,"A solution which is precisely on the solubility curve is...", "Unsaturated", "Saturated", "Super-saturated", "Not enough information to say", "Saturated");
        helper.insertQuestion(solubility_question14);
        Question solubility_question15=new Question(714, "All of the following are units of concentration except...", "Molar", "Molal", "Mole", "Gram per cubic centimeter", "Mole");
        helper.insertQuestion(solubility_question15);
        Question solubility_question16=new Question(715, "A solution is...", "A homogeneous mixture", "A heterogeneous mixture", "A solid mixed with a liquid", "A mixture in which a chemical reaction occurs", "A homogeneous mixture");
        helper.insertQuestion(solubility_question16);
        Question solubility_question17=new Question(716, "When a precipitate falls out of a solution, the result is...", "A homogeneous mixture", "A heterogeneous mixture", "A chemical reaction", "Not enough information to say", "A heterogeneous mixture");
        helper.insertQuestion(solubility_question17);
        Question solubility_question18= new Question(717, "A solution can be composed of a ______ dissolved in a ______", "liquid ; solid", "gas ; liquid", "gas ; solid", "all of the above", "all of the above");
        helper.insertQuestion(solubility_question18);
        Question solubility_question19=new Question(718, "All of the following are homogeneous mixtures except...", "Soda/pop", "Milk", "Coffee", "Chicken Soup", "Chicken Soup");
        helper.insertQuestion(solubility_question19);
        Question solubility_question20=new Question(719, "Colloids and Suspensions are mixtures with _______, when compared to solutions", "Smaller particles", "Larger particles", "Higher boiling points", "Lower freezing points", "Larger particles");
        helper.insertQuestion(solubility_question20);






















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
        Question stoich_question6 = new Question(805, "The reverse of a single replacement reaction is...", "double replacement","decomposition","single replacement","oxidation","single replacement");
        helper.insertQuestion(stoich_question6);
        Question stoich_question7 = new Question(806, "The reverse of a decomposition reaction is...", "double replacement","decomposition","single replacement","synthesis","synthesis");
        helper.insertQuestion(stoich_question7);
        Question stoich_question8 = new Question(807, "Which equation shows a decomposition reaction?", "A→BC", "A+B→AB", "AB+CD→AD+CB", "AB→A+B", "AB→A+B");
        helper.insertQuestion(stoich_question8);
        Question stoich_question9=new Question(808, "All of the following are balanced except...", "2 H₂O → 2 H₂ + O₂","2 NH₃ → N₂ + 3 H₂", "CH₄ + O₂ → CO₂ + H₂O", "2NO → N₂O₂", "CH₄ + O₂ → CO₂ + H₂O");
        helper.insertQuestion(stoich_question9);
        Question stoich_question10=new Question(809, "Which coefficients balance the following equation? _C₃H₈ + _O₂ → _CO₂ + _H₂O", "1,2,3,2", "1,5,4,3", "1,6,5,4", "4,3,2,1","1,5,4,3");
        helper.insertQuestion(stoich_question10);
        Question stoich_question11=new Question(810, "Which coefficients balance the following equation? _NaOH + _H₂SO₄ → _Na₂SO₄ + _H₂O", "1,2,2,1", "2,3,3,2", "1,3,3,1", "2,1,1,2","2,1,1,2");
        helper.insertQuestion(stoich_question11);
        Question stoich_question12=new Question(811, "In the following balanced equation, 4 ___ of Al are consumed for every ___ of Al₂O₃ produced: 4 Al + 3 O₂ → 2 Al₂O₃", "kilograms ; 2 kilograms", "moles ; 4 moles", "kilograms ; 4 kilograms", "moles ; 2 moles", "moles ; 2 moles");
        helper.insertQuestion(stoich_question12);
        Question stoich_question13=new Question(812, "Which coefficients balance the following equation? _Pb₃O₄ + _HCl → _PbCl₂ + _Cl₂ + _H₂O", "1,7,3,2,1", "2,8,3,2,4", "1,8,3,1,4", "2,3,4,5,6","1,8,3,1,4");
        helper.insertQuestion(stoich_question13);
        Question stoich_question14=new Question(813, "Which coefficients balance the following equation? _H₂S + _O₂ → _SO₂ + _H₂O", "2,3,2,2", "3,2,3,3", "3,2,3,4", "3,4,5,6","2,3,2,2");
        helper.insertQuestion(stoich_question14);
        Question stoich_question15=new Question(814, "Which coefficients balance the following equation? _Na₂S + _HCl→ _NaCl + _H₂S", "1,2,2,1", "2,3,3,2", "1,3,3,1", "2,1,1,2","1,2,2,1");
        helper.insertQuestion(stoich_question15);
        Question stoich_question16=new Question(815, "In the following balanced equation, 3 ___ of BaCl₂ are consumed for every ___ of AlCl₃ produced: 3 BaCl₂ + Al₂(SO₄)₃ → 2 AlCl₃ + 3 BaSO₄", "kilograms ; 2 kilograms", "moles ; 2 moles", "kilograms ; 3 kilograms", "moles ; 3 moles", "moles ; 2 moles");
        helper.insertQuestion(stoich_question16);
        Question stoich_question17=new Question(816, "In the following balanced equation, 3 ___ of CO₂ are produced for every ___ Fe₂O₃ of consumed: 2 Fe₂O₃ + 3 C → Fe + 3 CO₂", "kilograms ; 2 kilograms", "moles ; 2 moles", "kilograms ; 3 kilograms", "moles ; 3 moles", "moles ; 2 moles");
        helper.insertQuestion(stoich_question17);
        Question stoich_question18=new Question(817, "All of the following are decompositions except...", "2 H₂O → 2 H₂ + O₂","2 NH₃ → N₂ + 3 H₂", "CH₄ → C + 2 H₂", "2NO → N₂O₂", "2NO → N₂O₂");
        helper.insertQuestion(stoich_question18);
        Question stoich_question19=new Question(818, "All of the following are syntheses except...", "2 H₂ + O₂ → 2 H₂O","N₂ + 3 H₂ → 2NH₃", "CH₄ → C + 2 H₂", "NO + NO → N₂O₂", "CH₄ → C + 2 H₂");
        helper.insertQuestion(stoich_question19);
        Question stoich_question20=new Question(819, "All of the following are single replacement except...", "KI + Na → NaI + K","MgI₂ + Ca → CaI₂ + Mg ", "CH₄ → C + 2 H₂", "Li₂O + Mg → MgO + 2 Li", "CH₄ → C + 2 H₂");
        helper.insertQuestion(stoich_question20);











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
        Question thermo_question6 = new Question(905, "During a phase change, the temperature of a sample", "Increases", "Decreases", "Remains the same", "Depends on the phase change", "Remains the same");
        helper.insertQuestion(thermo_question6);
        Question thermo_question7 = new Question(906, "In between phase changes, the temperature of a sample", "Increases", "Decreases", "Remains the same", "Depends on the phase changes", "Depends on the phase changes");
        helper.insertQuestion(thermo_question7);
        Question thermo_question8 = new Question(907, "Condensation is the transition from...", "Solid to gas", "Liquid to gas", "Gas to liquid", "Liquid to solid", "Gas to liquid");
        helper.insertQuestion(thermo_question8);
        Question thermo_question9 = new Question(908, "Condensation is...", "Endothermic", "Exothermic", "Neither endothermic or exothermic", "Not enough information", "Exothermic");
        helper.insertQuestion(thermo_question9);
        Question thermo_question10 = new Question(909, "Sublimation is the transition from...", "Solid to gas", "Liquid to gas", "Gas to solid", "Liquid to solid", "Solid to gas");
        helper.insertQuestion(thermo_question10);
        Question thermo_question11 = new Question(910, "Sublimation is...", "Endothermic", "Exothermic", "Neither endothermic or exothermic", "Not enough information", "Endothermic");
        helper.insertQuestion(thermo_question11);
        Question thermo_question12 = new Question(911, "Deposition is the transition from...", "Solid to gas", "Liquid to gas", "Gas to solid", "Liquid to solid", "Gas to solid");
        helper.insertQuestion(thermo_question12);
        Question thermo_question13 = new Question(912, "Deposition is...", "Endothermic", "Exothermic", "Neither endothermic or exothermic", "Not enough information", "Exothermic");
        helper.insertQuestion(thermo_question13);
        Question thermo_question14 = new Question(913, "Vaporization is the transition from...", "Solid to gas", "Liquid to gas", "Gas to solid", "Liquid to solid", "Liquid to gas");
        helper.insertQuestion(thermo_question14);
        Question thermo_question15 = new Question(914, "Vaporization is...", "Endothermic", "Exothermic", "Neither endothermic or exothermic", "Not enough information", "Endothermic");
        helper.insertQuestion(thermo_question15);
        Question thermo_question16 = new Question(915, "Evaporation and boiling are types of", "Condensation", "Vaporization", "Combustion", "Sublimation", "Vaporization");
        helper.insertQuestion(thermo_question16);
        Question thermo_question17= new Question(916, "Evaporation is when vaporization occurs and the temperature is_______ the substance's boiling point", "Above", "Below", "Equal to", "Depends on the substance", "Below");
        helper.insertQuestion(thermo_question17);
        Question thermo_question18=new Question(917, "At a solution's boiling point", "The vapor pressure is equal to standard pressure", "The vapor pressure is equal to atmospheric pressure", "The heat of solution is zero", "Condensation occurs", "The vapor pressure is equal to atmospheric pressure");
        helper.insertQuestion(thermo_question18);
        Question thermo_question19=new Question(918, "Temperature is...", "Proportional to the average kinetic energy of particles in a substance", "Equal to the average heat energy in a substance", "Proportional to a substance's specific heat capacity", "Inversely proportional to a substance's mass", "Proportional to the average kinetic energy of particles in a substance" );
        helper.insertQuestion(thermo_question19);
        Question thermo_question20=new Question(919, "The heat released or absorbed by a cooling or warming substance is equal to ______, where m = Mass, ∆T = Temperature change, and C = Specific heat capacity (a constant depending on substance):", "m/(C∆T)","C/(m∆T)", "mC∆T", "∆T/(mC)", "mC∆T");
        helper.insertQuestion(thermo_question20);


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

        if (id == R.id.bookmarks) {
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
