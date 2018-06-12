package com.mahmoud.mohammed.qwesysandroidtask.DataLayer.Remote.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public final class CurrentWeatherInfo implements Parcelable {

    @SerializedName("main")
     TemperatureInfoData temperature;
    @SerializedName("weather")
     List<WeatherGeneralData> weatherGeneralData;
    @SerializedName("name")
     String cityName;

    public String getCityName() {
        return cityName;
    }

    public TemperatureInfoData getTemperature() {
        return temperature;
    }

    public void setTemperature(TemperatureInfoData temperature) {
        this.temperature = temperature;
    }

    public CurrentWeatherInfo() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.temperature, flags);
        dest.writeTypedList(this.weatherGeneralData);
        dest.writeString(this.cityName);
    }

    protected CurrentWeatherInfo(Parcel in) {
        this.temperature = in.readParcelable(TemperatureInfoData.class.getClassLoader());
        this.weatherGeneralData = in.createTypedArrayList(WeatherGeneralData.CREATOR);
        this.cityName = in.readString();
    }

    public static final Parcelable.Creator<CurrentWeatherInfo> CREATOR = new Parcelable.Creator<CurrentWeatherInfo>() {
        @Override
        public CurrentWeatherInfo createFromParcel(Parcel source) {
            return new CurrentWeatherInfo(source);
        }

        @Override
        public CurrentWeatherInfo[] newArray(int size) {
            return new CurrentWeatherInfo[size];
        }
    };
}
