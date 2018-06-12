package com.mahmoud.mohammed.qwesysandroidtask.PresentationLayer.CitiesList.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mahmoud.mohammed.qwesysandroidtask.DataLayer.Local.Model.CityModel;
import com.mahmoud.mohammed.qwesysandroidtask.PresentationLayer.CitiesList.presenter.ListingCitiesPresenter;
import com.mahmoud.mohammed.qwesysandroidtask.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ListingCitiesAdapter extends RecyclerView.Adapter<ListingCitiesAdapter.CitiesListHolder> {
    private final Context context;
    private List<CityModel> items;
    private ListingCitiesPresenter presenter;

    public ListingCitiesAdapter(List<CityModel> items, Context context, ListingCitiesPresenter presenter) {
        this.items = items;
        this.context = context;
        this.presenter = presenter;
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
        CityModel cityModel = items.get(position);
        holder.cityNameTv.setText(cityModel.getCityName());
        //TODO Fill in your logic for binding the view.
    }

    public void updateCitiesList(List<CityModel> items) {
        this.items.clear();
        this.items.addAll(items);
        this.notifyDataSetChanged();

    }

    @Override
    public int getItemCount() {
        if (items == null) {
            return 0;
        }
        return items.size();
    }


    class CitiesListHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.city_bane_tv)
        TextView cityNameTv;

        public CitiesListHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            presenter.onItemInteraction(getAdapterPosition());
        }
    }
}