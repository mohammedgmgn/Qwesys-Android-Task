package com.mahmoud.mohammed.qwesysandroidtask.features.CitiesList;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mahmoud.mohammed.qwesysandroidtask.DataLayer.CityModel;
import com.mahmoud.mohammed.qwesysandroidtask.R;

import java.util.List;

public class ListingCitiesAdapter extends RecyclerView.Adapter<ListingCitiesAdapter.CitiesListHolder> {
    private final Context context;
    private List<CityModel> items;

    public ListingCitiesAdapter(List<CityModel> items, Context context) {
        this.items = items;
        this.context = context;
    }

    @Override
    public CitiesListHolder onCreateViewHolder(ViewGroup parent,
                                               int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.city_item_row, parent, false);
        return new CitiesListHolder(v);
    }

    @Override
    public void onBindViewHolder(CitiesListHolder holder, int position) {
        CityModel item = items.get(position);
        //TODO Fill in your logic for binding the view.
    }

    @Override
    public int getItemCount() {
        if (items == null) {
            return 0;
        }
        return items.size();
    }
     class CitiesListHolder extends RecyclerView.ViewHolder{

         public CitiesListHolder(View itemView) {
             super(itemView);
         }
     }
}