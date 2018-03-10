package com.mjdroid.glimpsee;


import java.io.Serializable;

public class PlanActivity implements Serializable {
    private String mLongText;
    private String mFromTime;
    private String mToTime;
    private String mDate;
    private String mContact;
    private String mNumber;


    public PlanActivity(String longText, String fromTime, String toTime, String date, String contact, String number) {
        mLongText = longText;
        mFromTime = fromTime;
        mToTime = toTime;
        mDate = date;
        mContact = contact;
        mNumber = number;
    }



    public String getLongText() {
        return mLongText;
    }

    public String getFromTime() {
        return mFromTime;
    }

    public String getToTime() {
        return mToTime;
    }

    public String getDate() {
        return mDate;
    }

    public String getContact() {
        return mContact;
    }

    public String getNumber() {
        return mNumber;
    }

    public void setLongText(String longText) {
        mLongText = longText;
    }

    public void setToTime(String toTime) {
        mToTime = toTime;
    }

    public void setFromTime(String fromTime) {
        mFromTime = fromTime;
    }

    public void setDate(String date) {
        mDate = date;
    }

    public void setContact(String contact) {
        mContact = contact;
    }

    public void setNumber(String number) {
        mNumber = number;
    }

    public int findImageResource() {
        int imageResource;
        switch (mLongText) {
            case "Take a walk":
                imageResource = R.drawable.ic_directions_walk_black_48dp;
                break;
            case "Go for a run":
                imageResource = R.drawable.ic_directions_run_black_48dp;
                break;
            case "Go take a hike":
                imageResource = R.drawable.ic_directions_walk_black_48dp;
                break;
            case "Learn coding":
                imageResource = R.drawable.ic_code_black_48dp;
                break;
            case "Watch TV":
                imageResource = R.drawable.ic_tv_black_48dp;
                break;
            case "Go to cinema":
                imageResource = R.drawable.ic_local_movies_black_48dp;
                break;
            case "Go shopping":
                imageResource = R.drawable.ic_local_grocery_store_black_48dp;
                break;
            case "Go to lunch":
                imageResource = R.drawable.ic_local_dining_black_48dp;
                break;
            case "Go to dinner":
                imageResource = R.drawable.ic_local_dining_black_48dp;
                break;
            case "Read a book":
                imageResource = R.drawable.ic_local_library_black_48dp;
                break;
            case "Visit someone":
                imageResource = R.drawable.ic_person_pin_black_48dp;
                break;
            case "Do nothing":
                imageResource = R.drawable.ic_weekend_black_48dp;
                break;
            default:
                imageResource = R.drawable.eye_green;
        }
        return imageResource;
    }

}
