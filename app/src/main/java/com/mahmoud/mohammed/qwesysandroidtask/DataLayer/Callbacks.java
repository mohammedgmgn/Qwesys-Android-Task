package com.mahmoud.mohammed.qwesysandroidtask.DataLayer;

import com.mahmoud.mohammed.qwesysandroidtask.DataLayer.Local.CityModel;

import java.util.List;

public interface Callbacks {
    interface BaseNetworkCallbacks<OnSuccessReturnType> {
        void onSuccess (OnSuccessReturnType result);
        void onError (String error);

    }

    interface GetCitiesCallbacks extends BaseNetworkCallbacks<List<CityModel>>{} ;

}
