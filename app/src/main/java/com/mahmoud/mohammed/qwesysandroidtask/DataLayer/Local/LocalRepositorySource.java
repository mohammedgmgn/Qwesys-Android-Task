package com.mahmoud.mohammed.qwesysandroidtask.DataLayer.Local;

import com.mahmoud.mohammed.qwesysandroidtask.DataLayer.Callbacks;

public interface LocalRepositorySource {
    void getCities(Callbacks.GetCitiesCallbacks callbacks);

}
