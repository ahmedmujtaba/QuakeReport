package com.example.android.quakereport;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by mujtaba on 10/6/2016.
 */
public class Earthquake
{
    private double mMagnitutde;
    private String mLocation;
    private long mtimeInMilliSeconds;
    private String mUrl;

    public Earthquake(double magnitude,String location, long timeInMilliSeconds, String url)
    {
        mMagnitutde = magnitude;
        mLocation = location;
        mtimeInMilliSeconds = timeInMilliSeconds;
        mUrl = url;
    }

    //return the values to the earthquake adapter for putting in the list
    public double getMagnitutde()
    {
        return mMagnitutde;
    }
    public String getLocation()
    {
        return mLocation;
    }
    public long getTimeInMilliSeconds()
    {
        return mtimeInMilliSeconds;
    }

    public String getUrl()
    {
        return mUrl;
    }
}

