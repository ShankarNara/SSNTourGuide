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
import java.util.ArrayList;


import java.util.ArrayList;

public class CanteensActivity extends AppCompatActivity implements OnMapReadyCallback{

    GoogleMap map;
    boolean MapReady = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canteens);

        final ArrayList<Items> canteenslist = new ArrayList<Items>();

        canteenslist.add(new Items("Satyas",R.drawable.ic_restaurant_menu_black_48dp,new LatLng(12.751015, 80.195086)));
        canteenslist.add(new Items("Vishwas",R.drawable.ic_restaurant_menu_black_48dp,new LatLng(12.751284, 80.195129)));
        canteenslist.add(new Items("Snow Cube",R.drawable.ic_restaurant_menu_black_48dp,new LatLng(12.751394, 80.195148)));
        canteenslist.add(new Items("Main Canteen",R.drawable.ic_restaurant_menu_black_48dp,new LatLng(12.753284, 80.194617)));
        canteenslist.add(new Items("Shiv joint",R.drawable.ic_restaurant_menu_black_48dp,new LatLng(12.750876, 80.195040)));
        canteenslist.add(new Items("Vishwas 2",R.drawable.ic_restaurant_menu_black_48dp,new LatLng(12.753355, 80.196724)));

        ListAdapter adapter = new ListAdapter(this,canteenslist);

        ListView listview = (ListView) findViewById(R.id.canteensview);

        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new ListView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Items currentItem = canteenslist.get(position);
                if(MapReady)
                    flyTo(currentItem.getTarget());
            }
        });
        MapFragment mapfragment = (MapFragment) getFragmentManager().findFragmentById(R.id.canteenssmap);
        mapfragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;
        MapReady = true;
        CameraPosition cp = new CameraPosition.Builder().target(new LatLng(12.751451, 80.197442)).bearing(0).tilt(40).zoom(16).build();
        map.moveCamera(CameraUpdateFactory.newCameraPosition(cp));
        map.addMarker(new MarkerOptions().position(new LatLng(12.751015, 80.195086)).title("Satyas").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
        map.addMarker(new MarkerOptions().position(new LatLng(12.751284, 80.195129)).title("Vishwas").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
        map.addMarker(new MarkerOptions().position(new LatLng(12.751394, 80.195148)).title("Snow Cube").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
        map.addMarker(new MarkerOptions().position(new LatLng(12.753284, 80.194617)).title("Main Canteen").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
        map.addMarker(new MarkerOptions().position(new LatLng(12.750876, 80.195040)).title("Shiv joint").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
        map.addMarker(new MarkerOptions().position(new LatLng(12.753355, 80.196724)).title("Vishwas 2").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
    }

    public void flyTo(LatLng T) {
        CameraPosition cp = new CameraPosition.Builder().target(T).bearing(90).tilt(40).zoom(18).build();
        map.animateCamera(CameraUpdateFactory.newCameraPosition(cp), 2000, null);
    }
}
