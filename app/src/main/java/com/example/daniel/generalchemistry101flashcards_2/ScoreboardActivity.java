package com.example.daniel.generalchemistry101flashcards_2;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Daniel on 1/12/2016.
 */
public class ScoreboardActivity extends Activity {

    TextView scoreTotal;
    TextView scoreUnits;
    TextView scorePeriodic;
    TextView scoreAtomic;
    TextView scoreBonding;
    TextView scorePh;
    TextView scoreElectro;
    TextView scoreSolubility;
    TextView scoreStoich;
    TextView scoreThermo;
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
    Bundle extras;
    String subject;
    Button sbSubmitButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scoreboard);
        scoreTotal=(TextView) findViewById(R.id.scoreTotal);
        scoreUnits= (TextView) findViewById(R.id.scoreUnits);
        scorePeriodic= (TextView) findViewById(R.id.scorePeriodic);
        scoreAtomic= (TextView) findViewById(R.id.scoreAtomic);
        scoreBonding= (TextView) findViewById(R.id.scoreBonding);
        scorePh= (TextView) findViewById(R.id.scorePh);
        scoreElectro= (TextView) findViewById(R.id.scoreElectro);
        scoreSolubility= (TextView) findViewById(R.id.scoreSolubility);
        scoreStoich= (TextView) findViewById(R.id.scoreStoich);
        scoreThermo= (TextView) findViewById(R.id.scoreThermo);
        extras=getIntent().getExtras();
        IdHelper idHelper = new IdHelper(this);
        SQLiteDatabase id_db2 = idHelper.getWritableDatabase();
        ScoreboardHelper scoreboardHelper = new ScoreboardHelper(this);
        SQLiteDatabase score_db = scoreboardHelper.getWritableDatabase();
//        try{
//            units_score=extras.getInt("units_score");
//        } catch (Exception e){
//            units_score = 0;
//        }
//        try{
//            periodic_score=extras.getInt("periodic_score");
//        } catch (Exception e){
//            periodic_score = 0;
//        }
//
//        try{
//            atomic_score=extras.getInt("atomic_score");
//        } catch (Exception e){
//            atomic_score = 0;
//        }
//
//        try{
//            bond_score=extras.getInt("bond_score");
//        } catch (Exception e){
//            bond_score = 0;
//        }
//
//        try{
//            ph_score=extras.getInt("ph_score");
//        } catch (Exception e){
//            ph_score = 0;
//        }
//
//        try{
//            electro_score=extras.getInt("electro_score");
//        } catch (Exception e){
//            electro_score = 0;
//        }
//
//
//        try{
//            solubility_score=extras.getInt("solubility_score");
//        } catch (Exception e){
//            solubility_score = 0;
//        }
//
//        try{
//            stoich_score=extras.getInt("stoich_score");
//        } catch (Exception e){
//            stoich_score = 0;
//        }
//
//        try{
//            thermo_score=extras.getInt("thermo_score");
//        } catch (Exception e){
//            thermo_score = 0;
//        }
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

        scoreTotal.setText(""+score);
        scoreUnits.setText(""+units_score);
        scorePeriodic.setText(""+periodic_score);
        scoreAtomic.setText(""+atomic_score);
        scoreBonding.setText(""+bond_score);
        scorePh.setText(""+ph_score);
        scoreElectro.setText(""+electro_score);
        scoreSolubility.setText(""+solubility_score);
        scoreStoich.setText(""+stoich_score);
        scoreThermo.setText(""+thermo_score);


    }



}
