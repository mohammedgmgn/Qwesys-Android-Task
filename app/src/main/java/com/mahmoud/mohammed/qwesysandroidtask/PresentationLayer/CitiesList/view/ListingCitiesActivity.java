package com.mahmoud.mohammed.qwesysandroidtask.PresentationLayer.CitiesList.view;

import android.content.DialogInterface;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import com.mahmoud.mohammed.qwesysandroidtask.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ListingCitiesActivity extends AppCompatActivity {
    @BindView(R.id.add_city_btn_id)
    FloatingActionButton addNewCityBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cities_list);
        ButterKnife.bind(this);
        addNewCityBtn.setOnClickListener(view->{
            showChangeLangDialog();
        });
    }

    public void showChangeLangDialog() {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(getApplicationContext());
        LayoutInflater inflater = this.getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.custom_dialog, null);
        dialogBuilder.setView(dialogView);
        final EditText cityName = dialogView.findViewById(R.id.city_name_ed);
        dialogBuilder.setTitle(getString(R.string.add_new_city));
        dialogBuilder.setMessage(getString(R.string.city_name));
        dialogBuilder.setPositiveButton("Done", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                //do something with edt.getText().toString();
            }
        });
        dialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                //pass
            }
        });
        AlertDialog b = dialogBuilder.create();
        b.show();
    }

}
