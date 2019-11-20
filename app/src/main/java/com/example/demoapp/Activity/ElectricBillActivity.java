package com.example.demoapp.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.demoapp.Adapter.ElectricBillMenuAdapter;
import com.example.demoapp.Object.BillMenu;
import com.example.demoapp.R;

import java.util.ArrayList;

public class ElectricBillActivity extends AppCompatActivity {

    ListView listView;
    ElectricBillMenuAdapter electricBillMenuAdapter;
    ArrayList<BillMenu> electricBillMenuArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_electric_bill);

        listView = findViewById(R.id.lv_electricbill_menu);
        electricBillMenuArrayList = new ArrayList<>();
        electricBillMenuArrayList.add(new BillMenu(R.drawable.point_of_sale ,getString(R.string.address)));
        electricBillMenuArrayList.add(new BillMenu(R.drawable.calendar ,getString(R.string.schedule_of_electric_supply_stopping)));
        electricBillMenuArrayList.add(new BillMenu(R.drawable.sale ,getString(R.string.electricity_price)));
        electricBillMenuArrayList.add(new BillMenu(R.drawable.website ,getString(R.string.collection_point)));
        electricBillMenuArrayList.add(new BillMenu(R.drawable.website_sign ,getString(R.string.procedure)));
        electricBillMenuArrayList.add(new BillMenu(R.drawable.quality_control ,getString(R.string.safety_and_saving)));

        electricBillMenuAdapter = new ElectricBillMenuAdapter(this, R.layout.listmenu_item
                ,electricBillMenuArrayList);

        listView.setAdapter(electricBillMenuAdapter);

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
                Intent intent = new Intent(ElectricBillActivity.this, AddressActivity.class);
                startActivity(intent);

                break;
            case 1:
                Toast.makeText(this, "1", Toast.LENGTH_SHORT).show();
                break;
            case 2:
                Toast.makeText(this, "2", Toast.LENGTH_SHORT).show();
                break;
                default:
                    return;
        }
    }
}
