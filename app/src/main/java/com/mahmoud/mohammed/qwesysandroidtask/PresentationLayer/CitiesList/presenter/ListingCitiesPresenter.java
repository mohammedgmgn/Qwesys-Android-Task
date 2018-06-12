package com.mahmoud.mohammed.qwesysandroidtask.PresentationLayer.CitiesList.presenter;

import android.app.Activity;

import com.mahmoud.mohammed.qwesysandroidtask.DataLayer.Callbacks;
import com.mahmoud.mohammed.qwesysandroidtask.DataLayer.Local.CityModel;
import com.mahmoud.mohammed.qwesysandroidtask.DataLayer.DataRepository;
import com.mahmoud.mohammed.qwesysandroidtask.PresentationLayer.CitiesList.ListingCitiesContracts;
import com.mahmoud.mohammed.qwesysandroidtask.PresentationLayer.CitiesList.view.ListingCitiesActivity;
import com.mahmoud.mohammed.qwesysandroidtask.base.BaseView;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;

public class ListingCitiesPresenter implements ListingCitiesContracts.CitiesPresenterInterface {
    ListingCitiesContracts.ListCitiesView listingCitiesView;
    CityModel mCityModel;
    DataRepository mDataRepo;
    ListingCitiesActivity activity;
    List<CityModel> citiesModelList;

    public ListingCitiesPresenter(BaseView baseView, Activity activity) {
        this.activity = (ListingCitiesActivity) activity;
        setView(baseView);
        mDataRepo = new DataRepository();
        citiesModelList = new ArrayList<>();
    }

    @Override
    public void setView(BaseView view) {
        listingCitiesView = (ListingCitiesContracts.ListCitiesView) view;
    }

    @Override
    public void saveNewCity(String cityName) {
        mCityModel = new CityModel(cityName);
        citiesModelList.add(mCityModel);
        listingCitiesView.onGetCitiesSuccess(citiesModelList);
        mCityModel.saveCityInLocalDb(new Realm.Transaction.OnSuccess() {
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

    @Override
    public void getCities() {
        listingCitiesView.showProgress();
        mDataRepo.getCities(new Callbacks.GetCitiesCallbacks() {
            @Override
            public void onSuccess(List<CityModel> result) {
                citiesModelList = result;
                listingCitiesView.hideProgress();
                listingCitiesView.onGetCitiesSuccess(result);
            }

            @Override
            public void onError(String error) {
                listingCitiesView.hideProgress();
                listingCitiesView.showErrMsg(error);
            }
        });
    }

    @Override
    public void onItemInteraction(int adapterPosition) {
        listingCitiesView.startWeatherResultActivity(citiesModelList.get(adapterPosition));
    }

}
