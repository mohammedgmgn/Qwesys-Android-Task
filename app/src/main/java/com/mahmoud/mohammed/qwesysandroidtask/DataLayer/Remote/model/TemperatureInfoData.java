package com.mahmoud.mohammed.qwesysandroidtask.DataLayer.Remote.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class TemperatureInfoData implements Parcelable {

    @SerializedName("temp")
    float temp;
    @SerializedName("pressure")
    float pressure;
    @SerializedName("humidity")
    float humidity;
    @SerializedName("temp_min")
    float temp_min;
    @SerializedName("temp_max")
    float temp_max;

    public float getTemp() {
        return temp;
    }

    public void setTemp(float temp) {
        this.temp = temp;
    }

    public float getPressure() {
        return pressure;
    }

    public void setPressure(float pressure) {
        this.pressure = pressure;
    }

    public float getHumidity() {
        return humidity;
    }

    public void setHumidity(float humidity) {
        this.humidity = humidity;
    }

    public float getTemp_min() {
        return temp_min;
    }

    public void setTemp_min(float temp_min) {
        this.temp_min = temp_min;
    }

    public float getTemp_max() {
        return temp_max;
    }

    public void setTemp_max(float temp_max) {
        this.temp_max = temp_max;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeFloat(this.temp);
        dest.writeFloat(this.pressure);
        dest.writeFloat(this.humidity);
        dest.writeFloat(this.temp_min);
        dest.writeFloat(this.temp_max);
    }

    public TemperatureInfoData() {
    }

    protected TemperatureInfoData(Parcel in) {
        this.temp = in.readFloat();
        this.pressure = in.readFloat();
        this.humidity = in.readFloat();
        this.temp_min = in.readFloat();
        this.temp_max = in.readFloat();
    }

    public static final Parcelable.Creator<TemperatureInfoData> CREATOR = new Parcelable.Creator<TemperatureInfoData>() {
        @Override
        public TemperatureInfoData createFromParcel(Parcel source) {
            return new TemperatureInfoData(source);
        }

        @Override
        public TemperatureInfoData[] newArray(int size) {
            return new TemperatureInfoData[size];
        }
    };
}
