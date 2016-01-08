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
    Button ok, cancel;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_ui, null);
        ok = (Button) view.findViewById(R.id.ok);
        cancel = (Button) view.findViewById(R.id.cancel);
        ok.setOnClickListener(this);
        cancel.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.ok){
            Toast toast = Toast.makeText(getActivity(), "OK clicked", Toast.LENGTH_LONG);
            toast.show();
            this.dismiss();
        }else{
            Toast toast = Toast.makeText(getActivity(), "Cancel clicked", Toast.LENGTH_LONG);
            toast.show();
            this.dismiss();
        }
    }
}
