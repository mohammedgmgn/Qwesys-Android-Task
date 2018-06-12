package com.mahmoud.mohammed.qwesysandroidtask.DataLayer.Local;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.UUID;

import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class CityModel extends RealmObject implements Parcelable {
    @PrimaryKey
    private String cityId = UUID.randomUUID().toString();
    private String CityName;

    public CityModel(String cityName) {
        CityName = cityName;
    }
    public CityModel() {
    }


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

        RealmQueries.saveCityData(this, onSuccess, onError);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.cityId);
        dest.writeString(this.CityName);
    }

    protected CityModel(Parcel in) {
        this.cityId = in.readString();
        this.CityName = in.readString();
    }

    public static final Parcelable.Creator<CityModel> CREATOR = new Parcelable.Creator<CityModel>() {
        @Override
        public CityModel createFromParcel(Parcel source) {
            return new CityModel(source);
        }

        @Override
        public CityModel[] newArray(int size) {
            return new CityModel[size];
        }
    };
}
