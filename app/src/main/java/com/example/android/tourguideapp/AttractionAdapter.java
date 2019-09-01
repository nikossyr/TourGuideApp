package com.example.android.tourguideapp;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AttractionAdapter extends ArrayAdapter<Attraction> {
    /**
     * Resource ID for the background color for this list of attractions
     */
    private int mColorResourceId;

    private static final String LOG_TAG = AttractionAdapter.class.getSimpleName();

    /**
     * This is our own custom constructor (it doesn't mirror a superclass constructor).
     * The context is used to inflate the layout file, and the list is the data we want
     * to populate into the lists.
     *
     * @param context     The current context. Used to inflate the layout file.
     * @param attractions A List of Attractions objects to display in a list
     */
    public AttractionAdapter(Activity context, ArrayList<Attraction> attractions, int colorResourceId) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, attractions);
        mColorResourceId = colorResourceId;
    }

    /**
     * Provides a view for an AdapterView (ListView, GridView, etc.)
     *
     * @param position    The position in the list of data that should be displayed in the
     *                    list item view.
     * @param convertView The recycled view to populate.
     * @param parent      The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        // Get the {@link Attraction} object located at this position in the list
        Attraction currentAttraction = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView nameTextView = (TextView) listItemView.findViewById(R.id.attraction_name_text_view);
        // Get the version name from the current Attraction object and
        // set this text on the name TextView
        nameTextView.setText(currentAttraction.getAttractionName());

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView hoursTextView = (TextView) listItemView.findViewById(R.id.attraction_hours_text_view);
        // Get the working hours from the current Attraction object and
        // set this text on the number TextView
        String hoursOpen = getContext().getText(R.string.working_hours_label)
                + " " + currentAttraction.getAttractionHours();
        hoursTextView.setText(hoursOpen);

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView phoneTextView = (TextView) listItemView.findViewById(R.id.attraction_phone_text_view);
        // Get the working hours from the current Attraction object and
        // set this text on the number TextView
        String phoneNumber = currentAttraction.getAttractionPhone();
        phoneTextView.setText(phoneNumber);

        // Find the ImageView in the list_item.xml layout with the ID version_number
        ImageView imageIcon = (ImageView) listItemView.findViewById(R.id.image_icon);
        if (currentAttraction.hasImage()) {
            imageIcon.setVisibility(View.VISIBLE);
            // Get the imageIcon from the current Attraction object and
            // set this image on the number ImageView
            imageIcon.setImageResource(currentAttraction.getImageResourceId());
        } else {
            imageIcon.setVisibility(View.GONE);
        }

        //Set the theme color for the list item
        View textContainer = listItemView.findViewById(R.id.word_layout);
        //Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        //Set the background color of the text container View
        textContainer.setBackgroundColor(color);

        // Return the whole list item layout so that it can be shown in the ListView
        return listItemView;
    }
}
