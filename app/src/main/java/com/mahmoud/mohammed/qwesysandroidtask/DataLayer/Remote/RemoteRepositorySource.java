package com.mahmoud.mohammed.qwesysandroidtask.DataLayer.Remote;

import com.mahmoud.mohammed.qwesysandroidtask.DataLayer.Callbacks;
import com.mahmoud.mohammed.qwesysandroidtask.DataLayer.Remote.Services.WeatherDataService;

public interface RemoteRepositorySource {
    void getCities(WeatherDataService weatherDataService, String cityName, Callbacks.GetWeatherCallbacks callbacks);

}
