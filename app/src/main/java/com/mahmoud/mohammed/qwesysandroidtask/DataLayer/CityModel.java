package com.mahmoud.mohammed.qwesysandroidtask.DataLayer;

import java.util.UUID;

import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class CityModel extends RealmObject {
    @PrimaryKey
    private String cityId = UUID.randomUUID().toString();
    private String CityName;

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return CityName;
    }

    public void setCityName(String cityName) {
        CityName = cityName;
    }

    public void saveCityInLocalDb(Realm.Transaction.OnSuccess onSuccess, Realm.Transaction.OnError onError) {

        RealmQueries.saveCityData(this,onSuccess,onError);
    }
}
