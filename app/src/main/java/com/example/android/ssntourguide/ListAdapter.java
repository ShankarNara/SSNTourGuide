package com.example.android.ssntourguide;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ListAdapter extends ArrayAdapter<Items> {

    public ListAdapter(Activity Context , ArrayList<Items> departmentItems ){
        super(Context,0,departmentItems);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;

        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);
        }

        Items currentItem = getItem(position);

        TextView dNameView = (TextView) listItemView.findViewById(R.id.dname);

        dNameView.setText(currentItem.getName());

        ImageView image = (ImageView) listItemView.findViewById(R.id.icon);

        image.setImageResource(currentItem.getImageResourceId());

        return listItemView;
    }
}
