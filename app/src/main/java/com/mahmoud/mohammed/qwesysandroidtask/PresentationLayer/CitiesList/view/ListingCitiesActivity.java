package com.mahmoud.mohammed.qwesysandroidtask.PresentationLayer.CitiesList.view;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.mahmoud.mohammed.qwesysandroidtask.DataLayer.Local.CityModel;
import com.mahmoud.mohammed.qwesysandroidtask.PresentationLayer.CitiesList.ListingCitiesContracts;
import com.mahmoud.mohammed.qwesysandroidtask.PresentationLayer.CitiesList.adapter.ListingCitiesAdapter;
import com.mahmoud.mohammed.qwesysandroidtask.PresentationLayer.CitiesList.presenter.ListingCitiesPresenter;
import com.mahmoud.mohammed.qwesysandroidtask.PresentationLayer.WeatherResult.WeatherResultActivity;
import com.mahmoud.mohammed.qwesysandroidtask.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ListingCitiesActivity extends AppCompatActivity implements ListingCitiesContracts.ListCitiesView {
    @BindView(R.id.add_city_btn_id)
    FloatingActionButton addNewCityBtn;
    @BindView(R.id.cities_rec_view)
    RecyclerView recyclerView;
    @BindView(R.id.list_progress_bar)
    ProgressBar progressBar;
    Toolbar toolbar;
    ListingCitiesPresenter presenter;
    ListingCitiesAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cities_list);
        ButterKnife.bind(this);
        presenter = new ListingCitiesPresenter(this, this);
        initUi();

        presenter.getCities();
        addNewCityBtn.setOnClickListener(view -> {
            showChangeLangDialog();
        });
    }

    @SuppressLint("NewApi")
    private void initUi() {
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.cities_list_title);
        setSupportActionBar(toolbar);
        adapter = new ListingCitiesAdapter(new ArrayList<>(), this, presenter);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(llm);
        DefaultItemAnimator defaultItemAnimator = new DefaultItemAnimator();
        defaultItemAnimator.setAddDuration(1000);
        defaultItemAnimator.setRemoveDuration(1000);
        recyclerView.setItemAnimator(defaultItemAnimator);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                if (dy > 0)
                    addNewCityBtn.hide();
                else if (dy < 0)
                    addNewCityBtn.show();

            }
        });
        recyclerView.setAdapter(adapter);

    }

    public void showChangeLangDialog() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(ListingCitiesActivity.this);
        alertDialog.setTitle(getString(R.string.add_new_city));
        alertDialog.setMessage(getString(R.string.city_name));
        final EditText input = new EditText(ListingCitiesActivity.this);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        input.setLayoutParams(lp);
        alertDialog.setView(input);
        alertDialog.setPositiveButton(getString(R.string.done),
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        presenter.saveNewCity(input.getText().toString());
                    }
                });

        alertDialog.setNegativeButton(getString(R.string.cancel),
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

        alertDialog.show();
    }

    @Override
    public void startWeatherResultActivity(CityModel selectedCity) {
        Intent intent = new Intent(this, WeatherResultActivity.class);
        intent.putExtra(getString(R.string.city_obj_key), selectedCity);
        startActivity(intent);
    }

    @Override
    public void onCitySavedSuccesufully() {
        Toast.makeText(getApplicationContext(), getString(R.string.success), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onCityFaillToSave() {
        Toast.makeText(getApplicationContext(), getString(R.string.faill_save_error), Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onGetCitiesSuccess(List<CityModel> cityModelList) {
        adapter.updateCitiesList(cityModelList);
        Log.v("sizeList", cityModelList.size() + "");
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
    public void showMessage(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void showErrMsg(String err) {
        Toast.makeText(getApplicationContext(), err, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void showNoInternetMsg() {

    }
}

