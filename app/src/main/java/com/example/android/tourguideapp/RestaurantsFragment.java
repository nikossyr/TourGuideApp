package com.example.android.tourguideapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class RestaurantsFragment extends Fragment {
    public RestaurantsFragment() {
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
        attractions.add(new Attraction(getResources().getString(R.string.attraction_greek_stories_name),
                getResources().getString(R.string.attraction_greek_stories_hours),
                getResources().getString(R.string.attraction_greek_stories_phone)));
        attractions.add(new Attraction(getResources().getString(R.string.attraction_montakiou_name),
                getResources().getString(R.string.attraction_montakiou_hours),
                getResources().getString(R.string.attraction_montakiou_phone)));
        attractions.add(new Attraction(getResources().getString(R.string.attraction_pente_fi_name),
                getResources().getString(R.string.attraction_pente_fi_hours),
                getResources().getString(R.string.attraction_pente_fi_phone)));
        attractions.add(new Attraction(getResources().getString(R.string.attraction_oroscopo_name),
                getResources().getString(R.string.attraction_oroscopo_hours),
                getResources().getString(R.string.attraction_oroscopo_phone)));

        AttractionAdapter adapter = new AttractionAdapter(getActivity(), attractions, R.color.category_restaurants);

        ListView listView = (ListView) rootView.findViewById(R.id.list);

        // Make the {@link ListView} use the {@link AttractionAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Attraction} in the list.
        listView.setAdapter(adapter);

        return rootView;
    }
}
