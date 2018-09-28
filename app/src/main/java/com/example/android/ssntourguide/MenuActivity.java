package com.example.android.ssntourguide;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MenuActivity extends AppCompatActivity implements OnMapReadyCallback {

    GoogleMap map;
    boolean mapReady = false;

    LatLng target;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        LinearLayout deptButton = (LinearLayout) findViewById(R.id.department);
        LinearLayout canteenButton = (LinearLayout) findViewById(R.id.canteens);
        LinearLayout sportsAreaButton = (LinearLayout) findViewById(R.id.sportsarea);

        deptButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent deptIntent = new Intent(MenuActivity.this,DepartmentsActivity.class);
                startActivity(deptIntent);
            }
        });


        canteenButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent deptIntent = new Intent(MenuActivity.this,CanteensActivity.class);
                startActivity(deptIntent);
            }
        });


        sportsAreaButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent deptIntent = new Intent(MenuActivity.this,SportsareaActivity.class);
                startActivity(deptIntent);
            }
        });

        MapFragment mapfragment = (MapFragment) getFragmentManager().findFragmentById(R.id.depmap);
        mapfragment.getMapAsync(this);


    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;
        mapReady = true;
        LatLng chennai = new LatLng(12.751451, 80.197442);
        CameraPosition target = new CameraPosition.Builder().target(chennai).bearing(0).zoom(16).tilt(40).build();
        map.moveCamera(CameraUpdateFactory.newCameraPosition(target));
        map.addMarker(new MarkerOptions().position(new LatLng(12.751416, 80.197271)).title("CSE").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));
        map.addMarker(new MarkerOptions().position(new LatLng(12.751385, 80.197056)).title("IT").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));
        map.addMarker(new MarkerOptions().position(new LatLng(12.750751, 80.196232)).title("ECE").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));
        map.addMarker(new MarkerOptions().position(new LatLng(12.749051, 80.197090)).title("EEE").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));
        map.addMarker(new MarkerOptions().position(new LatLng(12.749084, 80.195946)).title("CIVIL").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));
        map.addMarker(new MarkerOptions().position(new LatLng(12.748979, 80.196354)).title("CHEMICAL").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));
        map.addMarker(new MarkerOptions().position(new LatLng(12.749230, 80.197910)).title("BIO-MEDICAL").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));
        map.addMarker(new MarkerOptions().position(new LatLng(12.751806, 80.194306)).title("MECH").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));
        map.addMarker(new MarkerOptions().position(new LatLng(12.751346, 80.192600)).title("Humanities").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));
        map.addMarker(new MarkerOptions().position(new LatLng(12.750540, 80.193555)).title("Physics").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));
        map.addMarker(new MarkerOptions().position(new LatLng(12.750540, 80.193555)).title("Chemistry").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));
        map.addMarker(new MarkerOptions().position(new LatLng(12.751015, 80.195086)).title("Satyas").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
        map.addMarker(new MarkerOptions().position(new LatLng(12.751284, 80.195129)).title("Vishwas").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
        map.addMarker(new MarkerOptions().position(new LatLng(12.751394, 80.195148)).title("Snow Cube").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
        map.addMarker(new MarkerOptions().position(new LatLng(12.753284, 80.194617)).title("Main Canteen").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
        map.addMarker(new MarkerOptions().position(new LatLng(12.750876, 80.195040)).title("Shiv joint").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
        map.addMarker(new MarkerOptions().position(new LatLng(12.753355, 80.196724)).title("Vishwas 2").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
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
        CameraPosition cp = new CameraPosition.Builder().target(T).bearing(0).tilt(40).zoom(18).build();
        map.animateCamera(CameraUpdateFactory.newCameraPosition(cp),2000,null);
    }

}




