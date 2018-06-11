package com.mahmoud.mohammed.qwesysandroidtask.features.Login;

import android.content.Intent;

import com.mahmoud.mohammed.qwesysandroidtask.base.BasePresenter;

public interface LoginPresenter extends BasePresenter{
    void loginWithFacebook();
    void onActivityResult(int requestCode, int resultCode, Intent data);
}