package com.mahmoud.mohammed.qwesysandroidtask.DataLayer.Remote.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class WeatherGeneralData implements Parcelable {
    @SerializedName("id")
    int id;
    @SerializedName("main")
    String main;
    @SerializedName("description")
    String description;
    @SerializedName("icon")
    String icon;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMain() {
        return main;
    }


    public String getDescription() {
        return description;
    }


    public String getIcon() {
        return icon;
    }



    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.main);
        dest.writeString(this.description);
        dest.writeString(this.icon);
    }

    public WeatherGeneralData() {
    }

    protected WeatherGeneralData(Parcel in) {
        this.id = in.readInt();
        this.main = in.readString();
        this.description = in.readString();
        this.icon = in.readString();
    }

    public static final Parcelable.Creator<WeatherGeneralData> CREATOR = new Parcelable.Creator<WeatherGeneralData>() {
        @Override
        public WeatherGeneralData createFromParcel(Parcel source) {
            return new WeatherGeneralData(source);
        }

        @Override
        public WeatherGeneralData[] newArray(int size) {
            return new WeatherGeneralData[size];
        }
    };
}
