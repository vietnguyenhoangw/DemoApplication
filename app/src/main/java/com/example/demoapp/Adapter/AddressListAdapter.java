package com.example.demoapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.demoapp.Object.Address;
import com.example.demoapp.Object.BillMenu;
import com.example.demoapp.R;

import java.util.ArrayList;

public class AddressListAdapter extends ArrayAdapter<Address> {

    Context layout;
    ArrayList<Address> arrayList;
    int resource;

    TextView name, addressDetail, time;

    public AddressListAdapter(@NonNull Context context, int resource, ArrayList<Address> arrayList) {
        super(context, resource, arrayList);
        this.layout = context;
        this.resource = resource;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(layout);
        convertView = layoutInflater.inflate(resource, null);

        name = convertView.findViewById(R.id.name);
        addressDetail = convertView.findViewById(R.id.address_detail);
        time = convertView.findViewById(R.id.timeDetail);

        Address address = arrayList.get(position);

        name.setText(address.getName());
        addressDetail.setText(address.getAddress());
        time.setText(address.getTimeDetail());

        return convertView;
    }
}
