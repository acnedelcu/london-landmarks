package com.example.londonlandmarks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.net.URI;

public class Details extends AppCompatActivity {

    ImageView landmarkImg=null;
    TextView landmarkTitle=null;
    TextView landmarkDescription=null;
    Button internetPage=null;
    Button locationButton =null;
    Landmark landmark=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        /*Intent intent= getIntent();
        Bundle bundle= intent.getExtras();
        landmark= (Landmark) bundle.getSerializable("landmark");*/

        //wire UI
        landmarkImg=findViewById(R.id.landmark_img);
        landmarkTitle=findViewById(R.id.landmark_title);
        landmarkDescription=findViewById(R.id.description_txtview);
        internetPage=findViewById(R.id.website_button);
        locationButton =findViewById(R.id.maps_button);

        landmarkTitle.setText(getIntent().getStringExtra("name"));
        landmarkDescription.setText(getIntent().getStringExtra("longDescription"));

        String imageName = getIntent().getStringExtra("image").substring(0, getIntent().getStringExtra("image").lastIndexOf('.'));
        landmarkImg.setImageResource(getResources().getIdentifier(imageName,"drawable", getPackageName()));

        //Website button click listener
        final String website=getIntent().getStringExtra("website");
        internetPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Details.this, WebActivity.class);
                intent.putExtra("website", website);
                startActivity(intent);

            }
        });

        //Maps button click listener
        final String location=getIntent().getStringExtra("location");
        locationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse(location));

                startActivity(intent);
            }
        });
    }
}