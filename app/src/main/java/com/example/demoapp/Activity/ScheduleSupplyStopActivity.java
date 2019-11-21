package com.example.demoapp.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.demoapp.Adapter.AddressListAdapter;
import com.example.demoapp.Object.Address;
import com.example.demoapp.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;

public class ScheduleSupplyStopActivity extends AppCompatActivity {

    TextView tv_company_type;
    EditText edt_startDate, edt_endDate;
    Spinner spinner_Provinces, spinner_regions;
    Button btnAccept;
    ArrayList<String> provincesList, regionsList;

    ArrayList<Address> addressArrayList;

    int years, months, days;
    int hours, minutes;
    final Calendar calendar = Calendar.getInstance();
    String dateShow;

    /* date time format java */
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
    Date currentDate = Calendar.getInstance().getTime();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule_supply_stop);

        createWidget();

        final String flag = getIntent().getStringExtra("flag");

        if (flag.equals("electric")) {
            electric_data();
            electric_setSpinner_provinces();
            electric_setSpinner_regions();
        }
        else {
            tv_company_type.setText(R.string.watercompany);
            water_data();
            water_setSpinner_provinces();
            water_setSpinner_regions();
        }

        /* get current time */
        years = calendar.get(Calendar.YEAR);
        months = calendar.get(Calendar.MONTH);
        days = calendar.get(Calendar.DAY_OF_MONTH);


        btnAccept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (flag.equals("electric")) {
                    Toast.makeText(ScheduleSupplyStopActivity.this, R.string.donhavaanyschdule_electric, Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(ScheduleSupplyStopActivity.this, R.string.donhavaanyschdule_water, Toast.LENGTH_LONG).show();
                }
            }
        });


        edt_startDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startDate();
            }
        });

        edt_endDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                endDate();
            }
        });
    }

    private void createWidget() {
        edt_startDate = findViewById(R.id.edt_startdate);
        edt_endDate = findViewById(R.id.edt_enddate);
        spinner_Provinces = findViewById(R.id.planets_spinner_province);
        spinner_regions = findViewById(R.id.planets_spinner_regions);
        btnAccept = findViewById(R.id.btnAccept);
        tv_company_type = findViewById(R.id.tv_company_type);
    }

    private void startDate() {
        DatePickerDialog datePickerDialog = new DatePickerDialog(ScheduleSupplyStopActivity.this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        dateShow = i2 + "/" + (i1 + 1) + "/" + i;

                        edt_startDate.setText(dateShow);

                        calendar.set(i,i1,i2);
                        years = calendar.get(Calendar.YEAR);
                        months = calendar.get(Calendar.MONTH);
                        days = calendar.get(Calendar.DAY_OF_MONTH);

                    }
                }, years, months, days);
        datePickerDialog.show();
    }

    private void endDate() {
        DatePickerDialog datePickerDialog = new DatePickerDialog(ScheduleSupplyStopActivity.this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        dateShow = i2 + "/" + (i1 + 1) + "/" + i;

                        edt_endDate.setText(dateShow);

                        calendar.set(i,i1,i2);
                        years = calendar.get(Calendar.YEAR);
                        months = calendar.get(Calendar.MONTH);
                        days = calendar.get(Calendar.DAY_OF_MONTH);

                    }
                }, years, months, days);
        datePickerDialog.show();
    }

    /*
    *  Electric
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
     *  Water
     * */

    private void water_data() {
        addressArrayList = new ArrayList<>();
        addressArrayList.add(new Address(0, "Điểm thu số 1", "23 Võ Thị Sáu, Phường Xuân Hòa", "Thu tiền từ 7 giờ sáng đến 5 giờ chiều."));
        addressArrayList.add(new Address(1, "Điểm thu số 2", "14 Trường Trinh, Phường Gò Gai", "Thu tiền từ 1 giờ chiều đến 5 giờ chiều."));
        addressArrayList.add(new Address(2, "Điểm thu số 3", "65 Lê Văn Sỹ, Phường Ông Già", "Thu tiền từ 9 giờ sáng đến 3 giờ chiều."));
        addressArrayList.add(new Address(3, "Điểm thu số 4", "21B Huỳnh Văn Bánh, Phường Nghi Lộc", "Thu tiền từ 7 giờ sáng đến 5 giờ chiều."));
        addressArrayList.add(new Address(4, "Điểm thu số 5", "15 Hùng Vương, Phường Thắng Lợi", "Thu tiền từ 7 giờ sáng đến 12 giờ trưa."));
        addressArrayList.add(new Address(5, "Điểm thu số 6", "33 Võ Văn Tần, Phường 17", "Thu tiền từ 1 giờ chiều đến 5 giờ chiều."));
        addressArrayList.add(new Address(6, "Điểm thu số 7", "201 Mai Cư Trinh, Phường 9", "Thu tiền từ 7 giờ sáng đến 5 giờ chiều."));
    }

    private void water_setSpinner_provinces() {
        provincesList = new ArrayList<>();
        provincesList.add("Gia Lai");
        provincesList.add("Bình Định");
        provincesList.add("Lâm Đồng");
        provincesList.add("Yên Bái");
        provincesList.add("Điện Biên");
        provincesList.add("Bạc Liêu");
        provincesList.add("Sóc Trăng");
        provincesList.add("Cà Mau");
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
