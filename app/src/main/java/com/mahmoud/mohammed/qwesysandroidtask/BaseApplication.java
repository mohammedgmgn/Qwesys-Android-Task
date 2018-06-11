package com.mahmoud.mohammed.qwesysandroidtask;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class BaseApplication extends Application {
    public static final String NAME = "QwesysApp";

    @Override
    public void onCreate() {

        super.onCreate();
        initRealm();
    }

    private void initRealm() {

        Realm.init(this);
        RealmConfiguration config = new RealmConfiguration.Builder().name(NAME).build();
        Realm.setDefaultConfiguration(config);
    }

}