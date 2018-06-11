package com.mahmoud.mohammed.qwesysandroidtask.features.Login;

import android.content.Intent;

import com.mahmoud.mohammed.qwesysandroidtask.base.BasePresenter;
import com.mahmoud.mohammed.qwesysandroidtask.base.BaseView;

public interface LoginContract {

    interface LoginView extends BaseView {
        void showProgress();

        void hideProgress();

        void onLoginFail(String errorMessage);

        void navigateToHomeListActivity();

    }

    interface LoginPresenterInterface extends BasePresenter {
        void loginWithFacebook();

        void onActivityResult(int requestCode, int resultCode, Intent data);
    }
}
