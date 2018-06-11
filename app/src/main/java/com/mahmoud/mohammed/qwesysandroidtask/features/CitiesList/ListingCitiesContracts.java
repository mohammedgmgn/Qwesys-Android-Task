package com.mahmoud.mohammed.qwesysandroidtask.features.CitiesList;

import android.content.Intent;

import com.mahmoud.mohammed.qwesysandroidtask.base.BasePresenter;
import com.mahmoud.mohammed.qwesysandroidtask.base.BaseView;

public interface ListingCitiesContracts {

    interface ListCitiesView extends BaseView {
        void startWeatherResultActivity();
    }

    interface CitiesPresenterInterface extends BasePresenter {

    }

}
