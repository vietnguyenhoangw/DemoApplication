package com.example.demoapp.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.demoapp.Adapter.AddressListAdapter;
import com.example.demoapp.Object.Address;
import com.example.demoapp.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class AddressActivity extends AppCompatActivity {

    Spinner spinner_Provinces, spinner_regions;
    Button btnAccept;
    ArrayList<String> provincesList, regionsList;

    ListView listView;
    ArrayList<Address> addressArrayList;
    AddressListAdapter addressListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address);

        createWidget();

        final String flag = getIntent().getStringExtra("flag");

        if (flag.equals("electric")) {
            electric_setSpinner_provinces();
            electric_setSpinner_regions();
            electric_data();
        }
        else {
            water_setSpinner_provinces();
            water_setSpinner_regions();
            water_data();
        }

        btnAccept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (flag.equals("electric")) {
                    Collections.shuffle(addressArrayList);
                    listView.setAdapter(addressListAdapter);
                }
                else {
                    Collections.shuffle(addressArrayList);
                    listView.setAdapter(addressListAdapter);
                }
            }
        });
    }

    private void createWidget() {
        spinner_Provinces = findViewById(R.id.planets_spinner_province);
        spinner_regions = findViewById(R.id.planets_spinner_regions);
        btnAccept = findViewById(R.id.btnAccept);
        listView = findViewById(R.id.lv_address);
    }

    /*
    * Electric
    * */

    private void electric_data() {
        addressArrayList = new ArrayList<>();
        addressArrayList.add(new Address(0, "Điểm thu số 1", "23 Võ Thị Sáu, Phường Xuân Hòa", "Thu tiền từ 7 giờ sáng đến 5 giờ chiều."));
        addressArrayList.add(new Address(1, "Điểm thu số 2", "14 Trường Trinh, Phường Gò Gai", "Thu tiền từ 1 giờ chiều đến 5 giờ chiều."));
        addressArrayList.add(new Address(2, "Điểm thu số 3", "65 Lê Văn Sỹ, Phường Ông Già", "Thu tiền từ 9 giờ sáng đến 3 giờ chiều."));
        addressArrayList.add(new Address(3, "Điểm thu số 4", "21B Huỳnh Văn Bánh, Phường Nghi Lộc", "Thu tiền từ 7 giờ sáng đến 5 giờ chiều."));
        addressArrayList.add(new Address(4, "Điểm thu số 5", "15 Hùng Vương, Phường Thắng Lợi", "Thu tiền từ 7 giờ sáng đến 12 giờ trưa."));
        addressArrayList.add(new Address(5, "Điểm thu số 6", "33 Võ Văn Tần, Phường 17", "Thu tiền từ 1 giờ chiều đến 5 giờ chiều."));
        addressArrayList.add(new Address(6, "Điểm thu số 7", "201 Mai Cư Trinh, Phường 9", "Thu tiền từ 7 giờ sáng đến 5 giờ chiều."));

        addressListAdapter = new AddressListAdapter(this, R.layout.list_address_item, addressArrayList);
    }

    private void electric_setSpinner_provinces() {
        provincesList = new ArrayList<>();
        provincesList.add("Quảng Ninh");
        provincesList.add("Thái Bình");
        provincesList.add("Thanh Hóa");
        provincesList.add("Tuyên Quang");
        provincesList.add("Điện Biên");
        provincesList.add("Lào Cai");
        provincesList.add("Sóc Trăng");
        provincesList.add("Quảng Trị");
        provincesList.add("Hòa Bình");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, provincesList);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_Provinces.setAdapter(dataAdapter);
    }

    private void electric_setSpinner_regions() {
        regionsList = new ArrayList<>();
        regionsList.add("Khu vực 1");
        regionsList.add("Khu vực 2");
        regionsList.add("Khu vực 3");
        regionsList.add("Khu vực 4");
        regionsList.add("Khu vực 5");


        ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, regionsList);
        dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_regions.setAdapter(dataAdapter2);
    }

    /*
    * Water
    * */

    private void water_data() {
        addressArrayList = new ArrayList<>();
        addressArrayList.add(new Address(0, "Điểm thu A", "177 Võ Thị Sáu, Phường Xuân Hòa", "Thu tiền từ 7 giờ sáng đến 5 giờ chiều."));
        addressArrayList.add(new Address(1, "Điểm thu B", "255 Trường Trinh, Phường Gò Gai", "Thu tiền từ 1 giờ chiều đến 5 giờ chiều."));
        addressArrayList.add(new Address(2, "Điểm thu C", "165 Lê Văn Sỹ, Phường Ông Già", "Thu tiền từ 9 giờ sáng đến 3 giờ chiều."));
        addressArrayList.add(new Address(3, "Điểm thu D", "21B Huỳnh Văn Bánh, Phường Nghi Lộc", "Thu tiền từ 7 giờ sáng đến 5 giờ chiều."));
        addressArrayList.add(new Address(4, "Điểm thu E", "153 Hùng Vương, Phường Thắng Lợi", "Thu tiền từ 7 giờ sáng đến 12 giờ trưa."));
        addressArrayList.add(new Address(5, "Điểm thu F", "331 Võ Văn Tần, Phường 17", "Thu tiền từ 1 giờ chiều đến 5 giờ chiều."));
        addressArrayList.add(new Address(6, "Điểm thu G", "01 Mai Cư Trinh, Phường 9", "Thu tiền từ 7 giờ sáng đến 5 giờ chiều."));

        addressListAdapter = new AddressListAdapter(this, R.layout.list_address_item, addressArrayList);
    }

    private void water_setSpinner_provinces() {
        provincesList = new ArrayList<>();
        provincesList.add("Gia Lai");
        provincesList.add("Vũng Tàu");
        provincesList.add("Thái Nguyên");
        provincesList.add("Tuyên Quang");
        provincesList.add("Yên Bái");
        provincesList.add("Lào Cai");
        provincesList.add("Thái Bình");
        provincesList.add("Quảng Trị");
        provincesList.add("Hòa Bình");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, provincesList);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_Provinces.setAdapter(dataAdapter);
    }

    private void water_setSpinner_regions() {
        regionsList = new ArrayList<>();
        regionsList.add("Khu vực A");
        regionsList.add("Khu vực B");
        regionsList.add("Khu vực C");
        regionsList.add("Khu vực D");
        regionsList.add("Khu vực E");


        ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, regionsList);
        dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_regions.setAdapter(dataAdapter2);
    }
}
