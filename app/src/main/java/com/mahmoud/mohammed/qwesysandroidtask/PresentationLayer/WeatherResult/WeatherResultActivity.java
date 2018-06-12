package com.mahmoud.mohammed.qwesysandroidtask.PresentationLayer.WeatherResult;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.mahmoud.mohammed.qwesysandroidtask.DataLayer.Local.CityModel;
import com.mahmoud.mohammed.qwesysandroidtask.R;

public class WeatherResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_result_screen);
        CityModel cityObj =  getIntent().getParcelableExtra(getString(R.string.city_obj_key));
        Log.v("cityObj",cityObj.getCityName());

    }
}
