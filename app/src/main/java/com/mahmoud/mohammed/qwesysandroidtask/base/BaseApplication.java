package com.mahmoud.mohammed.qwesysandroidtask.base;

import android.app.Application;

import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class BaseApplication extends Application {
    public static final String NAME = "QwesysApp";

    @Override
    public void onCreate() {
        super.onCreate();
        FacebookSdk.sdkInitialize(getApplicationContext());
        AppEventsLogger.activateApp(this);

        initRealm();
    }

    private void initRealm() {

        Realm.init(this);
        RealmConfiguration config = new RealmConfiguration.Builder().name(NAME).build();
        Realm.setDefaultConfiguration(config);
    }

}