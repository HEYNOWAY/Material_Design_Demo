package com.example.android.materialdesigncodelab;

import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

public class DetialActivity extends AppCompatActivity {
    public static final String EXTRA_INTENT = "postion";
    private CollapsingToolbarLayout collapsingToolbar;
    private TextView placeDetail;
    private TextView placeLocation;
    private  ImageView placePicutre;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detial);

        initViews();

        initDatas();
    }

    private void initViews() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        collapsingToolbar = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        placeDetail = (TextView) findViewById(R.id.place_detail);
        placeLocation =  (TextView) findViewById(R.id.place_location);
        placePicutre = (ImageView) findViewById(R.id.image);
    }

    private void initDatas() {
        Intent intent = getIntent();
        int position = intent.getIntExtra(EXTRA_INTENT,0);

        Resources resources = getResources();
        String[] places = resources.getStringArray(R.array.places);
        collapsingToolbar.setTitle(places[position % places.length]);

        String[] placeDetails = resources.getStringArray(R.array.place_details);
        placeDetail.setText(placeDetails[position % placeDetails.length]);

        String[] placeLocations = resources.getStringArray(R.array.place_locations);
        placeLocation.setText(placeLocations[position % placeLocations.length]);

        TypedArray placePictures = resources.obtainTypedArray(R.array.places_picture);
        placePicutre.setImageDrawable(placePictures.getDrawable(position % placePictures.length()));

        placePictures.recycle();
    }


}
