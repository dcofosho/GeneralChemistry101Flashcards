package com.example.daniel.generalchemistry101flashcards_2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

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
            Toast toast = Toast.makeText(getActivity(), "Start Over clicked"+subject, Toast.LENGTH_LONG);
            toast.show();
            this.dismiss();
        }else{
            Toast toast = Toast.makeText(getActivity(), "New Subject clicked"+subject, Toast.LENGTH_LONG);
            toast.show();
            this.dismiss();
        }
    }
}
