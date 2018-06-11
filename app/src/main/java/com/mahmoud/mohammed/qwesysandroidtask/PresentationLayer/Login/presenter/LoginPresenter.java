package com.mahmoud.mohammed.qwesysandroidtask.PresentationLayer.Login.presenter;
import com.mahmoud.mohammed.qwesysandroidtask.PresentationLayer.Login.LoginContract;

import android.app.Activity;
import android.content.Intent;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.mahmoud.mohammed.qwesysandroidtask.base.BaseView;
import com.mahmoud.mohammed.qwesysandroidtask.PresentationLayer.Login.LoginContract;
import com.mahmoud.mohammed.qwesysandroidtask.PresentationLayer.Login.view.LoginActivity;

import java.util.Arrays;

public class LoginPresenter implements LoginContract.LoginPresenterInterface, FacebookCallback<LoginResult> {
    CallbackManager callbackManager;

    private LoginContract.LoginView view;
    private LoginActivity activity;

    public LoginPresenter(BaseView view, Activity activity) {
        callbackManager = CallbackManager.Factory.create();
        this.activity = (LoginActivity) activity;
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
        this.view = (LoginContract.LoginView) view;

    }

    @Override
    public void onSuccess(LoginResult loginResult) {
        view.hideProgress();
        view.navigateToHomeListActivity();
    }

    @Override
    public void onCancel() {
        if (AccessToken.getCurrentAccessToken() == null) {
            return; // already logged out
        }

    }

    @Override
    public void onError(FacebookException error) {
        AccessToken.setCurrentAccessToken(null);
        LoginManager.getInstance().logInWithReadPermissions(activity, Arrays.asList("user_posts,user_friends"));
        view.onLoginFail(error.getMessage());
    }
}
