package com.example.daniel.generalchemistry101flashcards_2;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Daniel on 1/8/2016.
 */
public class MyDialog extends DialogFragment implements View.OnClickListener{
    Button startOver, newSubject;
    String subject;
    String whereClause;
    int subjectId;
    int min;
    int max;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        subject=getArguments().getString("subject");
        View view = inflater.inflate(R.layout.dialog_ui, null);
        startOver = (Button) view.findViewById(R.id.startOver);
        newSubject = (Button) view.findViewById(R.id.newSubject);
        startOver.setOnClickListener(this);
        newSubject.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.startOver){
            IdHelper idHelper = new IdHelper(getActivity());
            SQLiteDatabase id_db2 = idHelper.getWritableDatabase();

            Intent i = new Intent(getContext(), QuestionActivity.class);
            if(subject.equals("units")) {
                i.putExtra("subject", "units");
                min=0;
                max=3;
                subjectId=100;
                whereClause="usedId BETWEEN 99 AND 103";
            } else if(subject.equals("periodic")) {
                i.putExtra("subject", "periodic");
                min=0;
                max=3;
                subjectId=200;
                whereClause="usedId BETWEEN 199 AND 203";
            } else if(subject.equals("atomic")) {
                i.putExtra("subject", "atomic");
                min=0;
                max=3;
                subjectId=300;
                whereClause="usedId BETWEEN 299 AND 303";
            } else if(subject.equals("bonding")) {
                i.putExtra("subject", "bonding");
                min=0;
                max=3;
                subjectId=400;
                whereClause="usedId BETWEEN 399 AND 403";
            }else if(subject.equals("ph")) {
                i.putExtra("subject", "ph");
                min=0;
                max=3;
                subjectId=500;
                whereClause="usedId BETWEEN 499 AND 503";
            }else if(subject.equals("electro")) {
                i.putExtra("subject", "electro");
                min=0;
                max=3;
                subjectId=600;
                whereClause="usedId BETWEEN 599 AND 603";
            }else if(subject.equals("solubility")) {
                i.putExtra("subject", "solubility");
                min=0;
                max=3;
                subjectId=700;
                whereClause="usedId BETWEEN 699 AND 703";
            }else if(subject.equals("solubility")) {
                i.putExtra("subject", "stoich");
                min=0;
                max=3;
                subjectId=800;
                whereClause="usedId BETWEEN 799 AND 803";
            }else {
                i.putExtra("subject", "thermo");
                min=0;
                max=3;
                subjectId=700;
                whereClause="usedId BETWEEN 899 AND 903";
            }


            id_db2.delete("UsedId",whereClause,null);

            ArrayList<Integer> arrayList = new ArrayList<>();
            for (int k = min; k < max; k++) {
                arrayList.add(k + subjectId);
            }
            i.putIntegerArrayListExtra("id_range", arrayList);
            i.putExtra("starting_over", true);
            startActivity(i);

//            Toast toast = Toast.makeText(getActivity(), "Start Over clicked"+subject, Toast.LENGTH_LONG);
//            toast.show();
            this.dismiss();
        }else{
            Toast toast = Toast.makeText(getActivity(), "New Subject clicked"+subject, Toast.LENGTH_LONG);
            toast.show();
            this.dismiss();
        }
    }
}
