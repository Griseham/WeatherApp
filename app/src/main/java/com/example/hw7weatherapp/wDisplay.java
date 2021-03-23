package com.example.hw7weatherapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Date;

public class wDisplay extends AppCompatActivity {

    TextView cityView;
    TextView sunriseView;
    TextView sunsetView;
    TextView tempView;

    public static String name;
    public static Double lat;
    public static Double lon;


    String temp;
    String city2;
    //String lat;
    //String lon;
    String country;
    //String weatherResult;
    TextView textView;
    TextView latlonView;
    TextView minView;
    TextView maxView;
    TextView feelsView;

    TextView countryView;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        cityView = (TextView) findViewById(R.id.cityView);
        sunsetView = (TextView) findViewById(R.id.sunsetView);
        sunriseView = (TextView) findViewById(R.id.sunriseView);
        textView = (TextView) findViewById(R.id.text);
        tempView = (TextView) findViewById(R.id.tempView);
        latlonView = (TextView) findViewById(R.id.latlonView);
        minView = (TextView) findViewById(R.id.minView);
        maxView = (TextView) findViewById(R.id.maxView);
        countryView = (TextView) findViewById(R.id.countryView);
        feelsView = (TextView) findViewById(R.id.feelsView) ;

        JSONObject weatherdata = MainActivity.savedResponse;
        JSONObject coord = null;
        JSONObject main = null;
        JSONArray weather = null;
        JSONObject sys = null;
        JSONObject innerWeather = null;

        try{
            coord = weatherdata.getJSONObject("coord");
            main = weatherdata.getJSONObject("main");
            weather = weatherdata.getJSONArray("weather");
            sys = weatherdata.getJSONObject("sys");
            innerWeather = weather.getJSONObject(0);
        }
        catch(JSONException e){
            System.out.println("Something went wrong! ");
        }

        if (coord != null && main!= null && weather!= null && sys != null){

            try {

                cityView.setText("Weather for: " + weatherdata.getString("name"));
                name = weatherdata.getString("name");
                tempView.setText(main.getString("temp") + "F");

                Date sunset = new Date(sys.getLong("sunset") * 1000);
                Date sunrise = new Date(sys.getLong("sunrise") *1000);
                lat = coord.getDouble("lat");
                lon = coord.getDouble("lon");
                sunsetView.setText("Sunset: " + sunset.toString());
                sunriseView.setText("Sunrise: " + sunrise.toString());
                latlonView.setText("Lat: " + lat + " long: " + lon);
                minView.setText("Minimum Temperature: " + main.getString("temp_min"));
                countryView.setText("Country: " + sys.getString("country"));
                maxView.setText("Maximum Temperature: " + main.getString("temp_max"));
                feelsView.setText("Feels like: " + main.getString("feels_like"));


            }
            catch(JSONException e){
                System.out.println("Something went wrong! ");

            }

        }


    }

    public void onMapButtonClick(View v){

        Intent intent = new Intent(this, MapActivity.class );
        startActivity(intent);
    }


}
