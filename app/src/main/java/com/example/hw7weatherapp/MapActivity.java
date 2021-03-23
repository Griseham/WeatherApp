package com.example.hw7weatherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MapActivity extends AppCompatActivity {

    TextView cityName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        cityName = findViewById(R.id.cityName);
        cityName.setText("Map of " + wDisplay.name);
    }
}