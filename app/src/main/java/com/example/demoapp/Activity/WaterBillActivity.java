package com.example.demoapp.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.demoapp.Adapter.ElectricBillMenuAdapter;
import com.example.demoapp.Adapter.WaterBillMenuAdapter;
import com.example.demoapp.Object.BillMenu;
import com.example.demoapp.R;

import java.util.ArrayList;

public class WaterBillActivity extends AppCompatActivity {

    ListView listView;
    WaterBillMenuAdapter waterBillMenuAdapter;
    ArrayList<BillMenu> waterBillMenuArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_water_bill);

        listView = findViewById(R.id.lv_waterbill_menu);
        waterBillMenuArrayList = new ArrayList<>();
        waterBillMenuArrayList.add(new BillMenu(R.drawable.point_of_sale ,getString(R.string.address)));
        waterBillMenuArrayList.add(new BillMenu(R.drawable.calendar ,getString(R.string.schedule_of_water_supply_stopping)));
        waterBillMenuArrayList.add(new BillMenu(R.drawable.sale ,getString(R.string.water_selling_price)));
        waterBillMenuArrayList.add(new BillMenu(R.drawable.website ,getString(R.string.collection_point)));
        waterBillMenuArrayList.add(new BillMenu(R.drawable.website_sign ,getString(R.string.procedure)));
        waterBillMenuArrayList.add(new BillMenu(R.drawable.quality_control ,getString(R.string.safety_and_saving)));

        waterBillMenuAdapter = new WaterBillMenuAdapter(this, R.layout.listmenu_item
                ,waterBillMenuArrayList);

        listView.setAdapter(waterBillMenuAdapter);
    }
}
