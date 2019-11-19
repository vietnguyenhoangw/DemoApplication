package com.example.demoapp.Fragment;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.demoapp.Activity.DriverLicenceActivity;
import com.example.demoapp.Activity.ElectricBillActivity;
import com.example.demoapp.Activity.WaterBillActivity;
import com.example.demoapp.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    LinearLayout ln_electricBill_item, ln_waterBill_item, ln_driverLience_item;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        createWidget(view);

        ln_electricBill_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { menuItemSelect(view);
            }
        });
        ln_waterBill_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                menuItemSelect(view);
            }
        });
        ln_driverLience_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { menuItemSelect(view);
            }
        });
    }

    // Create widget
    private void createWidget(View view) {
        ln_electricBill_item = view.findViewById(R.id.ln_electricBill_item);
        ln_waterBill_item = view.findViewById(R.id.ln_waterBill_item);
        ln_driverLience_item = view.findViewById(R.id.ln_driverLicence_item);
    }

    // Menu's item select
    private void menuItemSelect(View view) {
        switch (view.getId()) {
            case R.id.ln_electricBill_item:
                Intent i1 = new Intent(getContext(), ElectricBillActivity.class);
                startActivity(i1);
                break;
            case R.id.ln_waterBill_item:
                Intent i2 = new Intent(getContext(), WaterBillActivity.class);
                startActivity(i2);
                break;
            case R.id.ln_driverLicence_item:
                Intent i3 = new Intent(getContext(), DriverLicenceActivity.class);
                startActivity(i3);
                break;
        }
    }

}
