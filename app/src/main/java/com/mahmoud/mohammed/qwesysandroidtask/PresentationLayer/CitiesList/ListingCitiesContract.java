package com.mahmoud.mohammed.qwesysandroidtask.PresentationLayer.CitiesList;

import com.mahmoud.mohammed.qwesysandroidtask.DataLayer.Local.Model.CityModel;
import com.mahmoud.mohammed.qwesysandroidtask.base.BasePresenter;
import com.mahmoud.mohammed.qwesysandroidtask.base.BaseView;

import java.util.List;

public interface ListingCitiesContract {

    interface ListCitiesView extends BaseView {
        void startWeatherResultActivity(CityModel selectedCity);

        void onCitySavedSuccesufully();

        void onCityFaillToSave();

        void onGetCitiesSuccess(List<CityModel> cityModelList);

        void showProgress();

        void hideProgress();

    }

    interface CitiesPresenterInterface extends BasePresenter {
        void saveNewCity(String cityName);

        void getCities();

        void onItemInteraction(int adapterPosition);

    }

}
