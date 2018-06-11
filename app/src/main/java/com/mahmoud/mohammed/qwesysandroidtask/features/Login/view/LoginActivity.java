package com.mahmoud.mohammed.qwesysandroidtask.features.Login.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.facebook.login.widget.LoginButton;
import com.mahmoud.mohammed.qwesysandroidtask.R;
import com.mahmoud.mohammed.qwesysandroidtask.features.CitiesList.CitiesListActivity;
import com.mahmoud.mohammed.qwesysandroidtask.features.Login.presenter.LoginPresenter;

import java.util.Arrays;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity implements LoginView {
    private static final String EMAIL = "email";
    @BindView(R.id.login_button)
    LoginButton facebookBtn;
    @BindView(R.id.progress_bar)
    ProgressBar progressBar;
    LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter=new LoginPresenter(this);
        ButterKnife.bind(this);
        facebookBtn.setReadPermissions(Arrays.asList(EMAIL));
        facebookBtn.setOnClickListener(view -> {
            presenter.loginWithFacebook();

        });
    }

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
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();

    }



    @Override
    public void showErrMsg(String msg) {
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void showNoInternetMsg() {
        Toast.makeText(getApplicationContext(), getString(R.string.NO_Internet_Error), Toast.LENGTH_SHORT).show();

    }
}
