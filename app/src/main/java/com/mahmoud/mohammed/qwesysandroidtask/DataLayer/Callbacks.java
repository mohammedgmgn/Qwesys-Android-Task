package com.mahmoud.mohammed.qwesysandroidtask.DataLayer;

import com.mahmoud.mohammed.qwesysandroidtask.DataLayer.Local.Model.CityModel;
import com.mahmoud.mohammed.qwesysandroidtask.DataLayer.Remote.model.CurrentWeatherInfo;

import java.util.List;

public interface Callbacks {
    interface BaseNetworkCallbacks<OnSuccessReturnType> {
        void onSuccess (OnSuccessReturnType result);
        void onError (String error);
    }

    interface GetCitiesCallbacks extends BaseNetworkCallbacks<List<CityModel>>{} ;
    interface GetWeatherCallbacks extends BaseNetworkCallbacks<CurrentWeatherInfo>{} ;

}
