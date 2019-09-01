package com.example.android.tourguideapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class ActivitiesFragment extends Fragment {
    public ActivitiesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.attraction_list, container, false);
        if (getActivity().getActionBar() != null) {
            getActivity().getActionBar().setDisplayHomeAsUpEnabled(true);
        }

        // Create an array of attractions
        final ArrayList<Attraction> attractions = new ArrayList<Attraction>();
        attractions.add(new Attraction(getResources().getString(R.string.attraction_athens_by_bike_name),
                getResources().getString(R.string.attraction_athens_by_bike_hours), R.drawable.athens_by_bike,
                getResources().getString(R.string.attraction_athens_by_bike_phone)));
        attractions.add(new Attraction(getResources().getString(R.string.attraction_walks_tour_company_name),
                getResources().getString(R.string.attraction_walks_tour_company_hours), R.drawable.athens_walks_tour_company,
                getResources().getString(R.string.attraction_walks_tour_company_phone)));
        attractions.add(new Attraction(getResources().getString(R.string.attraction_walks_tour_company_name),
                getResources().getString(R.string.attraction_blue_water_sailing_hours), R.drawable.sailing_athens,
                getResources().getString(R.string.attraction_walks_tour_company_phone)));
        attractions.add(new Attraction(getResources().getString(R.string.attraction_athens_insiders_name),
                getResources().getString(R.string.attraction_athens_insiders_hours), R.drawable.athens_insiders,
                getResources().getString(R.string.attraction_athens_insiders_phone)));
        attractions.add(new Attraction(getResources().getString(R.string.attraction_blue_water_sailing_name),
                getResources().getString(R.string.attraction_blue_water_sailing_hours), R.drawable.blue_water_sailing_greece,
                getResources().getString(R.string.attraction_blue_water_sailing_phone)));
        attractions.add(new Attraction(getResources().getString(R.string.attraction_extreme_divers_name),
                getResources().getString(R.string.attraction_extreme_divers_hours), R.drawable.extreme_divers,
                getResources().getString(R.string.attraction_extreme_divers_phone)));
        attractions.add(new Attraction(getResources().getString(R.string.attraction_skydive_athens_name),
                getResources().getString(R.string.attraction_skydive_athens_hours), R.drawable.skydive_athens,
                getResources().getString(R.string.attraction_skydive_athens_phone)));

        AttractionAdapter adapter = new AttractionAdapter(getActivity(), attractions, R.color.category_activities);

        ListView listView = (ListView) rootView.findViewById(R.id.list);

        // Make the {@link ListView} use the {@link AttractionAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Attraction} in the list.
        listView.setAdapter(adapter);

        return rootView;
    }
}

