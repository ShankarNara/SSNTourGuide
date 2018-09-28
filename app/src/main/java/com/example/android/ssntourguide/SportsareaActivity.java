package com.example.android.ssntourguide;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

import java.io.File;
import java.util.ArrayList;

import java.util.ArrayList;

public class SportsareaActivity extends AppCompatActivity implements OnMapReadyCallback{

    GoogleMap map;
    boolean MapReady = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sportsarea);

        final ArrayList<Items> sportsList = new ArrayList<Items>();

        sportsList.add(new Items("Football ground",R.drawable.football_icon,new LatLng(12.752516, 80.191365)));
        sportsList.add(new Items("Cricket ground",R.drawable.cricket_icon,new LatLng(12.751354, 80.189015)));
        sportsList.add(new Items("Tennis court",R.drawable.tennis_icon,new LatLng(12.753103, 80.193426)));
        sportsList.add(new Items("Badminton court",R.drawable.badminton,new LatLng(12.752643, 80.194392)));
        sportsList.add(new Items("Table tennis",R.drawable.tt,new LatLng(12.752643, 80.194392)));
        sportsList.add(new Items("Squash area",R.drawable.squash,new LatLng(12.752643, 80.194392)));
        sportsList.add(new Items("Basketball court",R.drawable.basketball,new LatLng(12.752297, 80.193018)));
        sportsList.add(new Items("Volleyball court",R.drawable.volley,new LatLng(12.752757, 80.193243)));

        ListAdapter adapter = new ListAdapter (this,sportsList);

        ListView view = (ListView) findViewById(R.id.sportsview);

        view.setAdapter(adapter);

        view.setOnItemClickListener(new ListView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Items currentItem = sportsList.get(position);
                if(MapReady)
                    flyTo(currentItem.getTarget());
            }
        });

        MapFragment mapfragment = (MapFragment) getFragmentManager().findFragmentById(R.id.Sportsareamap);
        mapfragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;
        MapReady = true;
        CameraPosition cp = new CameraPosition.Builder().target(new LatLng(12.751451, 80.197442)).bearing(0).tilt(40).zoom(16).build();
        map.moveCamera(CameraUpdateFactory.newCameraPosition(cp));
        map.addMarker(new MarkerOptions().position(new LatLng(12.752516, 80.191365)).title("Football").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
        map.addMarker(new MarkerOptions().position(new LatLng(12.751354, 80.189015)).title("Cricket").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
        map.addMarker(new MarkerOptions().position(new LatLng(12.753103, 80.193426)).title("Tennis").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
        map.addMarker(new MarkerOptions().position(new LatLng(12.752643, 80.194392)).title("Badminton").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
        map.addMarker(new MarkerOptions().position(new LatLng(12.752643, 80.194392)).title("TT").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
        map.addMarker(new MarkerOptions().position(new LatLng(12.752643, 80.194392)).title("Squash").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
        map.addMarker(new MarkerOptions().position(new LatLng(12.752297, 80.193018)).title("Basketball").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
        map.addMarker(new MarkerOptions().position(new LatLng(12.752757, 80.193243)).title("Volleyball").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
    }

    public void flyTo(LatLng T){
        CameraPosition cp = new CameraPosition.Builder().target(T).bearing(90).tilt(40).zoom(18).build();
        map.animateCamera(CameraUpdateFactory.newCameraPosition(cp),2000,null);
    }
}
