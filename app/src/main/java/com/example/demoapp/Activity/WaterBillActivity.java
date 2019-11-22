package com.example.demoapp.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

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

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                menu_select(i);
            }
        });
    }

    private void menu_select(int i) {
        switch (i) {
            case 0:
                Intent i1 = new Intent(WaterBillActivity.this, AddressActivity.class);
                i1.putExtra("flag", "water");
                startActivity(i1);
                break;
            case 1:
                Intent i2 = new Intent(WaterBillActivity.this, ScheduleSupplyStopActivity.class);
                i2.putExtra("flag", "water");
                startActivity(i2);
                break;
            case 2:
                Intent i3 = new Intent(WaterBillActivity.this, PriceActivity.class);
                i3.putExtra("flag", "water");
                startActivity(i3);
                break;
            case 3:
                Toast.makeText(this, "3", Toast.LENGTH_SHORT).show();
                break;
            case 4:
                Toast.makeText(this, "4", Toast.LENGTH_SHORT).show();
                break;
            case 5:
                Toast.makeText(this, "5", Toast.LENGTH_SHORT).show();
                break;
            default:
                return;
        }
    }
}
