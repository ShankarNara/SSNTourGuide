package com.example.android.ssntourguide;

import com.google.android.gms.maps.model.LatLng;

public class Items {

    private String mName;

    private int mImageResourceId = CURRENT_IMG_ID;

    private LatLng mTarget;

    private static final int CURRENT_IMG_ID = -1;

    public Items(String name,int imgResourceId){
        mName = name;
        mImageResourceId = imgResourceId;
    }

    public Items(String name,int imgResourceId,LatLng target){
        mName = name;
        mImageResourceId = imgResourceId;
        mTarget = target;
    }

    public String getName(){
        return mName;
    }

    public int getImageResourceId(){
        return mImageResourceId;
    }

    public LatLng getTarget(){return mTarget;}
}
