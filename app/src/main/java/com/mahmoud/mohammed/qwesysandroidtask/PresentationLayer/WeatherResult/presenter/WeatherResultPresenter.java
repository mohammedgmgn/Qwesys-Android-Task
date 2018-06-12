package com.mahmoud.mohammed.qwesysandroidtask.PresentationLayer.WeatherResult.presenter;

import android.content.Context;
import android.content.Intent;

import com.mahmoud.mohammed.qwesysandroidtask.DataLayer.Callbacks;
import com.mahmoud.mohammed.qwesysandroidtask.DataLayer.Local.Model.CityModel;
import com.mahmoud.mohammed.qwesysandroidtask.DataLayer.Remote.RemoteDataRepository;
import com.mahmoud.mohammed.qwesysandroidtask.DataLayer.Remote.RetrofitModule;
import com.mahmoud.mohammed.qwesysandroidtask.DataLayer.Remote.Services.WeatherDataService;
import com.mahmoud.mohammed.qwesysandroidtask.DataLayer.Remote.model.CurrentWeatherInfo;
import com.mahmoud.mohammed.qwesysandroidtask.PresentationLayer.WeatherResult.WeatherResultContract;
import com.mahmoud.mohammed.qwesysandroidtask.PresentationLayer.WeatherResult.view.WeatherResultActivity;
import com.mahmoud.mohammed.qwesysandroidtask.R;
import com.mahmoud.mohammed.qwesysandroidtask.base.BaseView;

public class WeatherResultPresenter implements WeatherResultContract.WeatherResultPresenterInterface {
    WeatherResultActivity activity;
    WeatherResultContract.WeatherResultView weatherResultView;
    WeatherDataService weatherDataService;
    RemoteDataRepository mRemoteDataRepo;
    Context mContext;

    @Override
    public void getWeatherData(Intent intent) {
        CityModel cityObj = intent.getParcelableExtra(activity.getString(R.string.city_obj_key));
        getCityWeatherData(cityObj.getCityName());

    }


    @Override
    public void setView(BaseView view) {
        weatherResultView = (WeatherResultContract.WeatherResultView) view;
    }

    public WeatherResultPresenter(BaseView baseView, WeatherResultActivity activity, Context context) {
        this.activity = activity;
        this.mContext = context;
        setView(baseView);
        weatherDataService = RetrofitModule.provideRetrofit(mContext).create(WeatherDataService.class);
        mRemoteDataRepo=new RemoteDataRepository();
    }

    private void getCityWeatherData(String cityName) {
        weatherResultView.showProgress();
        mRemoteDataRepo.getCities(weatherDataService, cityName, new Callbacks.GetWeatherCallbacks() {
            @Override
            public void onSuccess(CurrentWeatherInfo result) {
                weatherResultView.hideProgress();
                weatherResultView.showWeatherResult(result);
            }

            @Override
            public void onError(String error) {
                weatherResultView.showErrMsg(error);
            }
        });
    }

}
