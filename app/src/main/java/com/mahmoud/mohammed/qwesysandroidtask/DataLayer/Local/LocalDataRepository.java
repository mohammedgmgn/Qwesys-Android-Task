package com.mahmoud.mohammed.qwesysandroidtask.DataLayer.Local;

import android.webkit.ValueCallback;

import com.mahmoud.mohammed.qwesysandroidtask.DataLayer.Callbacks;
import com.mahmoud.mohammed.qwesysandroidtask.DataLayer.Local.Model.CityModel;

import java.util.List;

import io.realm.Realm;

public class LocalDataRepository implements LocalRepositorySource {
    @Override
    public void getCities(Callbacks.GetCitiesCallbacks callbacks) {
      RealmQueries.getCitiesList(new ValueCallback<List<CityModel>>() {
          @Override
          public void onReceiveValue(List<CityModel> cityModels) {
            callbacks.onSuccess(cityModels);
          }
      }, new Realm.Transaction.OnError() {
          @Override
          public void onError(Throwable error) {
              callbacks.onError(error.getMessage());
          }
      });
    }
}
