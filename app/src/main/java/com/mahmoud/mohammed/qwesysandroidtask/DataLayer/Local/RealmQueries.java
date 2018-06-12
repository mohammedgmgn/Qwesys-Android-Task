package com.mahmoud.mohammed.qwesysandroidtask.DataLayer.Local;

import android.webkit.ValueCallback;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmAsyncTask;
import io.realm.RealmResults;

public class RealmQueries {
    private static RealmAsyncTask transaction;

    private static Realm getInstanceOfRealm() {
        Realm realm;
        {
            realm = Realm.getDefaultInstance();
        }
        return realm;
    }

    public static void saveCityData(CityModel cityData, Realm.Transaction.OnSuccess onSuccess, Realm.Transaction.OnError onError) {

        transaction = getInstanceOfRealm().executeTransactionAsync(realm -> realm.copyToRealmOrUpdate(cityData), onSuccess, onError);
    }

    public static void  getCitiesList(ValueCallback<List <CityModel>>callback, Realm.Transaction.OnError onError) {
        List<CityModel> cityModelList = new ArrayList<>();

        getInstanceOfRealm().executeTransaction(realm -> {
            RealmResults<CityModel> cityModels = getInstanceOfRealm().where(CityModel.class).findAll();
            if (cityModels != null && cityModels.size() > 0) {
                cityModelList.addAll(cityModels);
                callback.onReceiveValue(cityModelList);
            }
        }
        );
    }
}
