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

public class DepartmentsActivity extends AppCompatActivity implements OnMapReadyCallback{

    GoogleMap map;
    boolean mapReady = false;

    LatLng target;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_departments);

        final ArrayList<Items> departmentlist = new ArrayList<Items>();

        departmentlist.add(new Items("CSE Department",R.drawable.ic_school_black_48dp,new LatLng(12.751416, 80.197271)));
        departmentlist.add(new Items("IT Department",R.drawable.ic_school_black_48dp,new LatLng(12.751385, 80.197056)));
        departmentlist.add(new Items("ECE Department",R.drawable.ic_school_black_48dp,new LatLng(12.750751, 80.196232)));
        departmentlist.add(new Items("EEE Department",R.drawable.ic_school_black_48dp,new LatLng(12.749051, 80.197090)));
        departmentlist.add(new Items("MECH Department",R.drawable.ic_school_black_48dp,new LatLng(12.751806, 80.194306)));
        departmentlist.add(new Items("CIVIL Department",R.drawable.ic_school_black_48dp,new LatLng(12.749084, 80.195946)));
        departmentlist.add(new Items("CHEMICAL Department",R.drawable.ic_school_black_48dp,new LatLng(12.748979, 80.196354)));
        departmentlist.add(new Items("BIO-MEDICAL Department",R.drawable.ic_school_black_48dp,new LatLng(12.749230, 80.197910)));
        departmentlist.add(new Items("Humanities Department",R.drawable.ic_school_black_48dp,new LatLng(12.751346, 80.192600)));
        departmentlist.add(new Items("Physics Department",R.drawable.ic_school_black_48dp,new LatLng(12.750540, 80.193555)));
        departmentlist.add(new Items("Chemistry Department",R.drawable.ic_school_black_48dp,new LatLng(12.750540, 80.193555)));

        ListAdapter adapter = new ListAdapter(this,departmentlist);

        ListView deptListView = (ListView) findViewById(R.id.departmentsview);

        deptListView.setOnItemClickListener(new ListView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Items currentItem = departmentlist.get(position);
                target = currentItem.getTarget();
                if(mapReady)
                    flyTo(target);
            }
        });

        deptListView.setAdapter(adapter);

        MapFragment mapfragment = (MapFragment) getFragmentManager().findFragmentById(R.id.departmentsmap);
        mapfragment.getMapAsync(this);

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;
        mapReady = true;
        LatLng chennai = new LatLng(13.0827,80.2707);
        CameraPosition cp = new CameraPosition.Builder().target(new LatLng(12.751451, 80.197442)).bearing(0).tilt(40).zoom(16).build();
        map.moveCamera(CameraUpdateFactory.newCameraPosition(cp));
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
    }

    public void flyTo(LatLng T){
        CameraPosition cp = new CameraPosition.Builder().target(T).bearing(0).tilt(40).zoom(18).build();
        map.animateCamera(CameraUpdateFactory.newCameraPosition(cp),2000,null);
    }
}
