package com.mahmoud.mohammed.qwesysandroidtask;

import com.mahmoud.mohammed.qwesysandroidtask.DataLayer.Callbacks;
import com.mahmoud.mohammed.qwesysandroidtask.DataLayer.Local.LocalDataRepository;
import com.mahmoud.mohammed.qwesysandroidtask.DataLayer.Local.LocalRepositorySource;
import com.mahmoud.mohammed.qwesysandroidtask.DataLayer.Local.Model.CityModel;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class DataRepositoryTest {
    LocalRepositorySource mDateRepositoryUnderTesting;

    @Before
    void initRepoUnderTesting() {
        mDateRepositoryUnderTesting = new LocalDataRepository();
    }


    @Test
    void getCitiesFail() {

        mDateRepositoryUnderTesting.getCities(new Callbacks.GetCitiesCallbacks() {
            @Override
            public void onSuccess(List<CityModel> result) {
                assert (false);

            }

            @Override
            public void onError(String error) {
                assert (!error.isEmpty());

            }
        });
    }

    @Test
    void getCitiesSuccess() {
        mDateRepositoryUnderTesting.getCities(new Callbacks.GetCitiesCallbacks() {
            @Override
            public void onSuccess(List<CityModel> result) {
                assert (!result.isEmpty());
            }

            @Override
            public void onError(String error) {
                assert (false);

            }
        });
    }


}
