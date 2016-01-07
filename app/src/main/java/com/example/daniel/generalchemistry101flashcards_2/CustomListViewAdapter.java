package com.example.daniel.generalchemistry101flashcards_2;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Daniel on 12/27/2015.
 */
public class CustomListViewAdapter extends ArrayAdapter<Subject>  {


    Context context; // save context reference

    public CustomListViewAdapter(Context context, int resourceId, //resourceId=your layout
                                 List<Subject> items) {
        super(context, resourceId, items);
        this.context = context;
    }

    /*private view holder class*/
    private class ViewHolder {
        TextView name;
        ImageView pic;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        Subject subject = getItem(position);

        LayoutInflater mInflater = (LayoutInflater) context
                .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        // if the view is not created, create it
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.list_layout1,
                    null); // inflate the layout programmatically to create in memory model
            holder = new ViewHolder();
            holder.pic = (ImageView) convertView.findViewById(R.id.imageView);
            holder.name = (TextView) convertView.findViewById(R.id.textView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag(); // when view is getting reused
        }


        holder.name.setText(subject.getName());
        holder.pic.setImageDrawable(subject.getPic());

        return convertView;
    }
}
