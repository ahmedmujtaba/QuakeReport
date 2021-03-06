package com.example.android.quakereport;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by mujtaba on 10/6/2016.
 */
public class EarthquakeAdapter extends ArrayAdapter<Earthquake>
{
    public static final String LOCATION_SEPARATOR = "of ";

    public EarthquakeAdapter(Context context, List<Earthquake> earthquakes)
    {
        super(context,0,earthquakes);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        View listItemView = convertView;
        if(listItemView == null)
        {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.earthquake_data,parent,false);
        }

        Earthquake currentItem = getItem(position);

        TextView magTextView = (TextView) listItemView.findViewById(R.id.mag);
        DecimalFormat formatter = new DecimalFormat("0.0");

        // Set the proper background color on the magnitude circle.
        // Fetch the background from the TextView, which is a GradientDrawable.
        GradientDrawable magnitudeCircle = (GradientDrawable) magTextView.getBackground();

        // Get the appropriate background color based on the current earthquake magnitude
        int magnitudeColor = getMagnitudeColor(currentItem.getMagnitutde());

        // Set the color on the magnitude circle
        magnitudeCircle.setColor(magnitudeColor);

        String stringMag = formatter.format(currentItem.getMagnitutde());
        magTextView.setText(stringMag);

        TextView locTextView = (TextView) listItemView.findViewById(R.id.location_1);
        TextView loc_2TextView = (TextView) listItemView.findViewById(R.id.location_2);

        String originalString = currentItem.getLocation();

        if(originalString.contains(" of "))
        {
            String[] parts = currentItem.getLocation().split(LOCATION_SEPARATOR);

            String firstString = parts[0] + LOCATION_SEPARATOR;
            String secondString = parts[1];


            locTextView.setText(firstString);
            loc_2TextView.setText(secondString);
        }
        else
        {
            locTextView.setText("Near the");
            loc_2TextView.setText(originalString);
        }
        TextView dateTextView = (TextView) listItemView.findViewById(R.id.date);
        Date dateObject = new Date(currentItem.getTimeInMilliSeconds());
        SimpleDateFormat dateFormatter = new SimpleDateFormat("MMM DD, yyyy");
        String dateToDisplay = dateFormatter.format(dateObject);

        dateTextView.setText(dateToDisplay);

        TextView timeTextView = (TextView) listItemView.findViewById(R.id.time);
        SimpleDateFormat timeFormatter = new SimpleDateFormat("h:mm a");
        String timeToDisplay = timeFormatter.format(dateObject);

        timeTextView.setText(timeToDisplay);

        return listItemView;

    }
    private int getMagnitudeColor(double magnitude) {
        int magnitudeColorResourceId;
        int magnitudeFloor = (int) Math.floor(magnitude);
        switch (magnitudeFloor) {
            case 0:
            case 1:
                magnitudeColorResourceId = R.color.magnitude1;
                break;
            case 2:
                magnitudeColorResourceId = R.color.magnitude2;
                break;
            case 3:
                magnitudeColorResourceId = R.color.magnitude3;
                break;
            case 4:
                magnitudeColorResourceId = R.color.magnitude4;
                break;
            case 5:
                magnitudeColorResourceId = R.color.magnitude5;
                break;
            case 6:
                magnitudeColorResourceId = R.color.magnitude6;
                break;
            case 7:
                magnitudeColorResourceId = R.color.magnitude7;
                break;
            case 8:
                magnitudeColorResourceId = R.color.magnitude8;
                break;
            case 9:
                magnitudeColorResourceId = R.color.magnitude9;
                break;
            default:
                magnitudeColorResourceId = R.color.magnitude10plus;
                break;
        }
        return ContextCompat.getColor(getContext(), magnitudeColorResourceId);
    }
}
