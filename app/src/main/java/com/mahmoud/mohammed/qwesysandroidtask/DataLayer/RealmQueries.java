package com.mahmoud.mohammed.qwesysandroidtask.DataLayer;

import io.realm.Realm;
import io.realm.RealmAsyncTask;

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

}
