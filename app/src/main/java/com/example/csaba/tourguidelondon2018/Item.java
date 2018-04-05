package com.example.csaba.tourguidelondon2018;

/**
 * Created by csaba on 4/1/2018.
 */

public class Item {


    private String title;
    private String description;
    private String additional;
    private int picture;
    private android.location.Location location;


    public Item (String mTitle, String mDescription, String mAddition, int mPicture, android.location.Location mLocation) {

        title = mTitle;
        description = mDescription;
        additional = mAddition;
        picture = mPicture;
        location = mLocation;
    }

    public String getmTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getAdditional() {
        return additional;
    }

    public int getPicture() {
        return picture;
    }

    public android.location.Location getLocation() {
        return location;
    }



}
