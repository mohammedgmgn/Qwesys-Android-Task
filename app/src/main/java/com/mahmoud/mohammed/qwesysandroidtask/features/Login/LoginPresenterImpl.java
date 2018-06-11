package com.mahmoud.mohammed.qwesysandroidtask.features.Login;

import android.content.Context;
import android.content.Intent;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.mahmoud.mohammed.qwesysandroidtask.base.BaseView;

import java.util.Arrays;

public class LoginPresenterImpl implements LoginPresenter, FacebookCallback<LoginResult> {
    CallbackManager callbackManager;

    private LoginView view;
    private Context mContext;

    public LoginPresenterImpl(BaseView view, Context context) {
        mContext = context;
        callbackManager = CallbackManager.Factory.create();
        setView(view);
    }

    @Override
    public void loginWithFacebook() {
        view.showProgress();
        LoginManager.getInstance().registerCallback(callbackManager, this);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void setView(BaseView view) {
        this.view = (LoginView) view;

    }

    @Override
    public void onSuccess(LoginResult loginResult) {
        view.hideProgress();
        view.navigateToHomeListActivity();
    }

    @Override
    public void onCancel() {

    }

    @Override
    public void onError(FacebookException error) {
        view.showErrMsg(error.getMessage());
    }
}
