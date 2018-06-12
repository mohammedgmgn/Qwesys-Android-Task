package com.mahmoud.mohammed.qwesysandroidtask.PresentationLayer.WeatherResult.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.mahmoud.mohammed.qwesysandroidtask.DataLayer.Remote.model.CurrentWeatherInfo;
import com.mahmoud.mohammed.qwesysandroidtask.DataLayer.Remote.model.TemperatureInfoData;
import com.mahmoud.mohammed.qwesysandroidtask.PresentationLayer.WeatherResult.WeatherResultContract;
import com.mahmoud.mohammed.qwesysandroidtask.PresentationLayer.WeatherResult.presenter.WeatherResultPresenter;
import com.mahmoud.mohammed.qwesysandroidtask.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WeatherResultActivity extends AppCompatActivity implements WeatherResultContract.WeatherResultView {
    WeatherResultPresenter presenter;
    @BindView(R.id.city_name_tv)
    TextView cityNameTv;
    @BindView(R.id.high_temperature)
    TextView highTemp;
    @BindView(R.id.low_temperature)
    TextView lowTemp;
    @BindView(R.id.weather_progress_bar)
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_result_screen);
        ButterKnife.bind(this);
        presenter=new WeatherResultPresenter(this,this,this);
        presenter.getWeatherData(getIntent());

    }

    @Override
    public void showWeatherResult(CurrentWeatherInfo currentWeatherInfo) {
        cityNameTv.setText(currentWeatherInfo.getCityName());
        highTemp.setText( String.valueOf(currentWeatherInfo.getTemperature().getTemp_max())+"\u00b0");
        lowTemp.setText( String.valueOf(currentWeatherInfo.getTemperature().getTemp_min())+"\u00b0");
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void showErrMsg(String msg) {
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void showNoInternetMsg() {

    }
}
