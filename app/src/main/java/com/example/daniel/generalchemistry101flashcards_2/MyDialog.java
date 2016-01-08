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
            if(subject=="units"){
                IdHelper idHelper = new IdHelper(getActivity());
                SQLiteDatabase id_db2 = idHelper.getWritableDatabase();
                String whereClause="usedId BETWEEN 99 AND 103";
                id_db2.delete("UsedId",whereClause,null);

                Intent i = new Intent(getContext(), QuestionActivity.class);
                i.putExtra("subject", "units");

                ArrayList<Integer> arrayList = new ArrayList<>();
                for (int k = 0; k < 3; k++) {
                        arrayList.add(k + 100);
                }
                i.putIntegerArrayListExtra("id_range", arrayList);
                startActivity(i);
            }
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
