package com.example.android.tourguideapp;

public class Attraction {
    /**
     * Name for the attraction
     */
    private String mAttractionName;

    /**
     * Working hours of the attraction
     */
    private String mAttractionHours;

    /**
     * Image Resource Id for the attraction
     */
    private int mImageResourceId = NO_IMAGE_PROVIDED;

    private static final int NO_IMAGE_PROVIDED = -1;

    /**
     * Phone number of the attraction
     */
    private String mAttractionPhone;

    /**
     * Create a new Attraction object.
     *
     * @param attractionName  is the attraction name
     * @param attractionHours is the attraction working hours
     * @param attractionPhone is the attraction phone number
     */
    public Attraction(String attractionName, String attractionHours, String attractionPhone) {
        mAttractionName = attractionName;
        mAttractionHours = attractionHours;
        mAttractionPhone = attractionPhone;
    }

    /**
     * Create a new Attraction object.
     *
     * @param attractionName  is the attraction name
     * @param attractionHours is the attraction working hours
     * @param attractionPhone is the attraction phone number
     * @param imageResourceId is the attraction photo
     */
    public Attraction(String attractionName, String attractionHours, int imageResourceId, String attractionPhone) {
        mAttractionName = attractionName;
        mAttractionHours = attractionHours;
        mAttractionPhone = attractionPhone;
        mImageResourceId = imageResourceId;
    }

    /**
     * Get the attraction name
     */
    public String getAttractionName() {

        return mAttractionName;
    }

    /**
     * Get the attraction working hours
     */
    public String getAttractionHours() {

        return mAttractionHours;
    }

    /**
     * Get the Image Resource ID of the attraction
     */
    public int getImageResourceId() {

        return mImageResourceId;
    }

    /**
     * Returns whether or not the Attraction object has an image.
     *
     * @return
     */
    public boolean hasImage() {

        return mImageResourceId != NO_IMAGE_PROVIDED;
    }

    /**
     * Get the attraction's phone number
     */
    public String getAttractionPhone() {

        return mAttractionPhone;
    }

    @Override
    public String toString() {
        return "Attraction{" +
                "mAttractionName='" + mAttractionName + '\'' +
                ", mAttractionHours='" + mAttractionHours + '\'' +
                ", mImageResourceId=" + mImageResourceId +
                ", mAttractionPhone=" + mAttractionPhone +
                '}';
    }
}
