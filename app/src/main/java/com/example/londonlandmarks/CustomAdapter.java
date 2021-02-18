package com.example.londonlandmarks;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class CustomAdapter extends ArrayAdapter<String> {
    Context context;

    String rTitle[];
    String rShortDescription[];
    int rImg[];

    //Constructor
    CustomAdapter(Context c, String mainTitle[], String shortDescription[], int images[]){
        super(c, R.layout.list_item, R.id.shortDescription, mainTitle);
        this.context=c;
        this.rTitle=mainTitle;
        this.rShortDescription=shortDescription;
        this.rImg=images;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater= (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        //var folosita pentru creeare fiecarui element din lista
        View listItem= layoutInflater.inflate(R.layout.list_item, parent, false);

        ImageView images= listItem.findViewById(R.id.image);
        TextView title= listItem.findViewById(R.id.landmarkName);
        TextView shortDescription= listItem.findViewById(R.id.shortDescription);

        //put resources in views
        images.setImageResource(rImg[position]);
        title.setText(rTitle[position]);
        shortDescription.setText(rShortDescription[position]);

        return listItem;
    }
}
