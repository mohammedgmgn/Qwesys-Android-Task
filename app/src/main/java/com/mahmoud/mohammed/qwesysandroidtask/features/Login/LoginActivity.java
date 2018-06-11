package com.mahmoud.mohammed.qwesysandroidtask.features.Login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.HttpMethod;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.mahmoud.mohammed.qwesysandroidtask.R;
import com.mahmoud.mohammed.qwesysandroidtask.features.CitiesList.CitiesListActivity;

import java.util.Arrays;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity implements LoginView {
    CallbackManager callbackManager;
    private static final String EMAIL = "email";
    @BindView(R.id.login_button)
    LoginButton facebookBtn;
    @BindView(R.id.progress_bar)
    ProgressBar progressBar;
    LoginPresenterImpl presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter=new LoginPresenterImpl(this,this);
        ButterKnife.bind(this);
        callbackManager = CallbackManager.Factory.create();
        facebookBtn.setReadPermissions(Arrays.asList(EMAIL));
        facebookBtn.setOnClickListener(view -> {
            // facebookLogin();
            presenter.loginWithFacebook();

        });
    }
/*
    private void facebookLogin() {
        facebookBtn.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                Log.v("onSuccess", loginResult.toString());

            }

            @Override
            public void onCancel() {
                if (AccessToken.getCurrentAccessToken() == null) {
                    Log.e("ON CANCEL", "Login attempt failed.");
                    return; // already logged out
                }
                new GraphRequest(AccessToken.getCurrentAccessToken(), "/me/permissions/", null, HttpMethod.DELETE, graphResponse -> {
                    LoginManager.getInstance().logOut();
                    LoginManager.getInstance().logInWithReadPermissions(LoginActivity.this, Arrays.asList("user_posts,user_friends"));
                    facebookLogin();

                }).executeAsync();

            }

            @Override
            public void onError(FacebookException error) {
                Log.e("ON ERROR", "Login attempt failed.");


                AccessToken.setCurrentAccessToken(null);
                LoginManager.getInstance().logInWithReadPermissions(LoginActivity.this, Arrays.asList("user_posts,user_friends"));

            }
        });

    }
*/

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        presenter.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
    }


    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);

    }

    @Override
    public void onLoginFail(String errorMessage) {
        Toast.makeText(getApplicationContext(), errorMessage, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void navigateToHomeListActivity() {
        startActivity(new Intent(this, CitiesListActivity.class));
    }

    @Override
    public void showMessage(String message) {

    }

    @Override
    public void showLoadingDialog(String message) {

    }

    @Override
    public void dismissLoadingDialog() {

    }

    @Override
    public void showErrMsg(String msg) {

    }

    @Override
    public void showNoInternetMsg() {

    }
}
