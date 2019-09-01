package com.example.android.tourguideapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class CafesFragment extends Fragment {
    public CafesFragment() {
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
        attractions.add(new Attraction(getResources().getString(R.string.attraction_cafe_boheme_name),
                getResources().getString(R.string.attraction_cafe_boheme_hours),
                getResources().getString(R.string.attraction_cafe_boheme_phone)));
        attractions.add(new Attraction(getResources().getString(R.string.attraction_spiti_mas_name),
                getResources().getString(R.string.attraction_spiti_mas_hours),
                getResources().getString(R.string.attraction_spiti_mas_phone)));
        attractions.add(new Attraction(getResources().getString(R.string.attraction_harvest_coffee_name),
                getResources().getString(R.string.attraction_harvest_coffee_hours),
                getResources().getString(R.string.attraction_harvest_coffee_phone)));
        attractions.add(new Attraction(getResources().getString(R.string.attraction_cafe_bar_name),
                getResources().getString(R.string.attraction_cafe_bar_hours),
                getResources().getString(R.string.attraction_cafe_bar_phone)));
        attractions.add(new Attraction(getResources().getString(R.string.attraction_azzuro_cafe_name),
                getResources().getString(R.string.attraction_azzuro_cafe_hours),
                getResources().getString(R.string.attraction_azzuro_cafe_phone)));
        attractions.add(new Attraction(getResources().getString(R.string.attraction_cafe_plaka_name),
                getResources().getString(R.string.attraction_cafe_plaka_hours),
                getResources().getString(R.string.attraction_cafe_plaka_phone)));

        AttractionAdapter adapter = new AttractionAdapter(getActivity(), attractions, R.color.category_cafes);

        ListView listView = (ListView) rootView.findViewById(R.id.list);

        // Make the {@link ListView} use the {@link AttractionAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Attraction} in the list.
        listView.setAdapter(adapter);

        return rootView;
    }
}
