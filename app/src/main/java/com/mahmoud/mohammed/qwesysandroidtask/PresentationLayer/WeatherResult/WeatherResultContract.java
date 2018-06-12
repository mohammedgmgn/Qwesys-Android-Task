package com.mahmoud.mohammed.qwesysandroidtask.PresentationLayer.WeatherResult;

import android.content.Intent;

import com.mahmoud.mohammed.qwesysandroidtask.DataLayer.Remote.model.CurrentWeatherInfo;
import com.mahmoud.mohammed.qwesysandroidtask.base.BasePresenter;
import com.mahmoud.mohammed.qwesysandroidtask.base.BaseView;

public interface WeatherResultContract {
    interface WeatherResultView extends BaseView {
        void showWeatherResult(CurrentWeatherInfo currentWeatherInfo);
        void showProgress();
        void hideProgress();

    }

    interface WeatherResultPresenterInterface extends BasePresenter {
        void getWeatherData(Intent intent);
    }

}
