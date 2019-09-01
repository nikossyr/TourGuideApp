package com.example.android.tourguideapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class MuseumsFragment extends Fragment {
    public MuseumsFragment() {
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
        attractions.add(new Attraction(getResources().getString(R.string.attraction_museum_ancient_agora_name),
                getResources().getString(R.string.attraction_museum_ancient_agora_hours),
                getResources().getString(R.string.attraction_museum_ancient_agora_phone)));
        attractions.add(new Attraction(getResources().getString(R.string.attraction_national_archeological_museum_name),
                getResources().getString(R.string.attraction_national_archeological_museum_hours),
                getResources().getString(R.string.attraction_national_archeological_museum_phone)));
        attractions.add(new Attraction(getResources().getString(R.string.attraction_school_life_and_education_name),
                getResources().getString(R.string.attraction_school_life_and_education_hours),
                getResources().getString(R.string.attraction_school_life_and_education_phone)));
        attractions.add(new Attraction(getResources().getString(R.string.attraction_museum_cycladic_art_name),
                getResources().getString(R.string.attraction_museum_cycladic_art_hours),
                getResources().getString(R.string.attraction_museum_cycladic_art_phone)));
        attractions.add(new Attraction(getResources().getString(R.string.attraction_cultural_center_name),
                getResources().getString(R.string.attraction_cultural_center_hours),
                getResources().getString(R.string.attraction_cultural_center_phone)));
        attractions.add(new Attraction(getResources().getString(R.string.attraction_digital_museum_plato_name),
                getResources().getString(R.string.attraction_digital_museum_plato_hours),
                getResources().getString(R.string.attraction_digital_museum_plato_phone)));

        AttractionAdapter adapter = new AttractionAdapter(getActivity(), attractions, R.color.category_museums);

        ListView listView = (ListView) rootView.findViewById(R.id.list);

        // Make the {@link ListView} use the {@link AttractionAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Attraction} in the list.
        listView.setAdapter(adapter);

        return rootView;
    }
}

