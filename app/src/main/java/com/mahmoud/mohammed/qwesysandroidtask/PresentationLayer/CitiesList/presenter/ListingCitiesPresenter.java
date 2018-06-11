package com.mahmoud.mohammed.qwesysandroidtask.PresentationLayer.CitiesList.presenter;

import com.mahmoud.mohammed.qwesysandroidtask.DataLayer.CityModel;
import com.mahmoud.mohammed.qwesysandroidtask.PresentationLayer.CitiesList.ListingCitiesContracts;
import com.mahmoud.mohammed.qwesysandroidtask.base.BaseView;

import io.realm.Realm;

public class ListingCitiesPresenter implements ListingCitiesContracts.CitiesPresenterInterface {
    ListingCitiesContracts.ListCitiesView listingCitiesView;
    CityModel cityModel;
    @Override
    public void setView(BaseView view) {
        listingCitiesView=( ListingCitiesContracts.ListCitiesView)view;
    }

    @Override
    public void saveNewCity(String cityName) {
        cityModel=new CityModel();
        cityModel.setCityName(cityName);
        cityModel.saveCityInLocalDb(new Realm.Transaction.OnSuccess() {
            @Override
            public void onSuccess() {
                listingCitiesView.onCitySavedSuccesufully();
            }
        }, new Realm.Transaction.OnError() {
            @Override
            public void onError(Throwable error) {
                listingCitiesView.onCityFaillToSave();
            }
        });
    }
}
