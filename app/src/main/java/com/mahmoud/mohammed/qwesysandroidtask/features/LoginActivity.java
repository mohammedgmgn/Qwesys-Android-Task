package com.mahmoud.mohammed.qwesysandroidtask.features;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookButtonBase;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.HttpMethod;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.mahmoud.mohammed.qwesysandroidtask.R;

import java.util.Arrays;

public class LoginActivity extends AppCompatActivity {
    CallbackManager callbackManager;
    private static final String EMAIL = "email";
    LoginButton facebookBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        facebookBtn =  findViewById(R.id.login_button);
        callbackManager = CallbackManager.Factory.create();
        facebookBtn.setReadPermissions(Arrays.asList(EMAIL));

        facebookBtn.setOnClickListener(view->{
            facebookLogin();

        });
    }

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


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);

        super.onActivityResult(requestCode, resultCode, data);
    }


}
