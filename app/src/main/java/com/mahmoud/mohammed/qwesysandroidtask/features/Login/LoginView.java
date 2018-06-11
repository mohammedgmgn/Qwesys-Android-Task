package com.mahmoud.mohammed.qwesysandroidtask.features.Login;

import com.mahmoud.mohammed.qwesysandroidtask.base.BaseView;

public interface LoginView extends BaseView {
    void showProgress();

    void hideProgress();
    void onLoginFail(String errorMessage);
    void navigateToHomeListActivity();

}
