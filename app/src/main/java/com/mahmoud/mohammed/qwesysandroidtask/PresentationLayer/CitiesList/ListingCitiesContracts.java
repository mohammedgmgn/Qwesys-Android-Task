package com.mahmoud.mohammed.qwesysandroidtask.PresentationLayer.CitiesList;

import android.content.Intent;

import com.mahmoud.mohammed.qwesysandroidtask.base.BasePresenter;
import com.mahmoud.mohammed.qwesysandroidtask.base.BaseView;

public interface ListingCitiesContracts {

    interface ListCitiesView extends BaseView {
        void startWeatherResultActivity();
        void onCitySavedSuccesufully();
        void onCityFaillToSave();

    }

    interface CitiesPresenterInterface extends BasePresenter {
      void saveNewCity(String cityName);


    }

}
