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

import com.example.demoapp.Object.BillMenu;
import com.example.demoapp.R;

import java.util.ArrayList;

public class ElectricBillMenuAdapter extends ArrayAdapter<BillMenu> {

    Context layout;
    ArrayList<BillMenu> arrayList;
    int resource;

    ImageView img_icon;
    TextView tv_title;

    public ElectricBillMenuAdapter(@NonNull Context context, int resource, ArrayList<BillMenu> arrayList) {
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

        img_icon = convertView.findViewById(R.id.menu_list_icon);
        tv_title = convertView.findViewById(R.id.menu_list_title);

        BillMenu electricBillMenu = arrayList.get(position);

        img_icon.setImageResource(electricBillMenu.getIcon());
        tv_title.setText(electricBillMenu.getTitle().toString());

        return convertView;
    }
}
