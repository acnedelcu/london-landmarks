package com.example.londonlandmarks;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.io.Console;
import java.io.Serializable;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    String mainTitle[]=null;
    String shortDescription[]=null;
    String longDescription[]=null;
    int images[]= null;
    String websites[]=null;
    String locations[]=null;

    List<Landmark> list=null;



    @RequiresApi(api = Build.VERSION_CODES.Q)
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final XMLData data= new XMLData(this);

        list=data.getLendmarks();
        mainTitle=data.getLendmarkNames();
        shortDescription=data.getLendmarkShortDesc();
        longDescription=data.getLendmarkLongDescription();
        images=data.getImagesInt();
        websites=data.getLandmarksWebsite();
        locations=data.getLandmarksLocations();

        listView= findViewById(R.id.listView);
        CustomAdapter customAdapter= new CustomAdapter(this, mainTitle,shortDescription,images);
        listView.setAdapter(customAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent= new Intent(MainActivity.this, Details.class);

                /*Bundle bundle= new Bundle();
                bundle.putSerializable("landmark",data.getLendmark(position));*/

                intent.putExtra("name",data.getLendmark(position).getName());
                intent.putExtra("longDescription",data.getLendmark(position).getLongDescription());
                intent.putExtra("image", data.getLendmark(position).getImage());
                intent.putExtra("website",data.getLendmark(position).getWebsite());
                intent.putExtra("location",data.getLendmark(position).getLocation());

                startActivity(intent);
            }
        });
    }
}